
document.getElementById("viewAllPending").href = "http://localhost:8080/ProjectOne/viewAllPending";
document.getElementById("viewAllResolved").href = "http://localhost:8080/ProjectOne/viewAllResolved";
document.getElementById("viewAllEmployees").href = "http://localhost:8080/ProjectOne/viewAllEmps";
document.getElementById("viewReqFromSingleEmp").href = "http://localhost:8080/ProjectOne/viewReqFromSingleEmp";
document.getElementById("approveOrDeny").href = "http://localhost:8080/ProjectOne/approveOrDeny";



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