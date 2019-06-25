document.getElementById("login-button").addEventListener("click", requestLogin);

function requestLogin()
{
    console.log("THE LOGOUT REQUEST IS BEING SENT!");
	let url = "http://localhost:8080/ProjectOne/login";
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
            console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
            window.location.href = "http://localhost:8080/ProjectOne/login";
		}
	}
	xhr.send();
}