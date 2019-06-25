
document.getElementById("submit-btn").addEventListener("click", updateRequest);
let url = "http://localhost:8080/ProjectOne/api/updateRequest";

function updateRequest()
{
	console.log("THE PUT REQUEST IS BEING GENERATED!");
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
			console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
			displayRequests(this);
		}
	}

	let reqId = document.getElementById("reqId").value;
	let outcome = document.getElementById("outcome").value;
	let token = sessionStorage.getItem("token");
	// VALIDATE INPUT HERE!
	console.log(reqId + " is entered ID number!");
	console.log(outcome + " is outcome!");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "reqId="+reqId+"&outcome="+outcome+"&token="+token;
	console.log(requestBody + " is requestBody");
	xhr.send(requestBody);
}

function displayRequests(xhr)
{
	console.log("YOUR UPDATE WORKED!");
}



document.getElementById("logout-btn").addEventListener("click", requestLogout);
function requestLogout()
{
    console.log("THE LOGOUT REQUEST IS BEING SENT!");
	let url = "http://localhost:8080/ProjectOne/logout";
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
            console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
            sessionStorage.removeItem('token');
            window.location.href = "http://localhost:8080/ProjectOne/logout";
		}
    }
    xhr.send();
}