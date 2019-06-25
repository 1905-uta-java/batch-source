
document.getElementById("createReq").addEventListener("click", createRequest);
function createRequest()
{
   // console.log("THE LOGOUT REQUEST IS BEING SENT!");
	let url = "http://localhost:8080/ProjectOne/api/createReq";
    let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
            console.log("REQUEST SUCCESSFUL!");
            window.location.href = window.location.href= "http://localhost:8080/ProjectOne/employeehome";
		}
  }
    
    var token = sessionStorage.getItem("token");
    console.log("Token is: " + token);

	var ammount = document.getElementById("ammount").value;
    var reason = document.getElementById("reason").value;
    console.log(ammount + "is ammount!");
    console.log(reason + "is reason!");

	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    let requestBody = "ammount="+ammount+"&reason="+reason+"&token="+token;
    console.log(requestBody + " is request body!");
  //  console.log(sessionStorage.getItem("token"));
	xhr.send(requestBody);
}