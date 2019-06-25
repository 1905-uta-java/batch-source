
document.getElementById("login-button").addEventListener("click", requestLogin);

function requestLogin()
{
	let url = "http://localhost:8080/ProjectOne/api/auth";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
			var authorized = xhr.getResponseHeader("authentication");

			console.log(authorized);

			sessionStorage.setItem("token", authorized);
			
			if (authorized.substring(2) === "Employee")
			{
				window.location.href= "http://localhost:8080/ProjectOne/employeehome";
			}
			else if (authorized.substring(2) === "Manager")
			{
				window.location.href = "http://localhost:8080/ProjectOne/managerhome"
			}
		}
	}
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username=" + user + "&password=" + pass;
	xhr.send(requestBody);
}