document.getElementById("empHome").href =  "http://localhost:8080/ProjectOne/employeehome";

document.getElementById("updateInformation").addEventListener("click", updateInfo);

function updateInfo()
{
    console.log("THE UPDATE REQUEST IS BEING SENT!");
	let url = "http://localhost:8080/ProjectOne/api/updateInformation";
	let xhr = new XMLHttpRequest();
    xhr.open("PUT", url);
    var token = sessionStorage.getItem("token");
    console.log("Token is: " + token);
    var split = token.split(':');
    let id = split[0];
    console.log(id);

	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
           console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
           window.location.href = "http://localhost:8080/ProjectOne/employeehome";
		}
    }

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    console.log(username);
    console.log(password);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    let requestBody = "username="+username+"&password="+password+"&id="+id;
    console.log(requestBody + " is request body!");
  //  console.log(sessionStorage.getItem("token"));
    xhr.send(requestBody);
}