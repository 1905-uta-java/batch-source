
document.getElementById("createRequest").href = "http://localhost:8080/ProjectOne/createRequest";
document.getElementById("viewPending").href = "http://localhost:8080/ProjectOne/viewPending";
document.getElementById("viewResolved").href = "http://localhost:8080/ProjectOne/viewResolved";
document.getElementById("viewInformation").href = "http://localhost:8080/ProjectOne/viewInformation";
document.getElementById("updateInformation").href = "http://localhost:8080/ProjectOne/updateInformation";


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

// // adding an event listener to the navbar option to create a request
// document.getElementById("createRequest").addEventListener("click", toCreateReqeust);
// function toCreateReqeust()
// {
// 	let url = "http://localhost:8080/ProjectOne/createRequest";
// 	let xhr = new XMLHttpRequest();
// 	xhr.open("GET", url);
// 	xhr.onreadystatechange = function()
// 	{
// 		if (this.readyState === 4 && this.status === 200)
// 		{
//             console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
//             window.location.href = "http://localhost:8080/ProjectOne/createRequest";
// 		}
// 	}
// }

// // adding an event listener to the navbar option to view requests
// document.getElementById("viewPending").addEventListener("click", toViewPending);
// function toViewPending()
// {
// 	let url = "http://localhost:8080/ProjectOne/viewPending";
// 	let xhr = new XMLHttpRequest();
// 	xhr.open("GET", url);
// 	xhr.onreadystatechange = function()
// 	{
// 		if (this.readyState === 4 && this.status === 200)
// 		{
//             console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
//             window.location.href = "http://localhost:8080/ProjectOne/viewPending";
// 		}
// 	}
// }


// // adding an event listener to the navbar option to view requests
// document.getElementById("viewResolved").addEventListener("click", toViewResolved);
// function toViewResolved()
// {
// 	let url = "http://localhost:8080/ProjectOne/viewResolved";
// 	let xhr = new XMLHttpRequest();
// 	xhr.open("GET", url);
// 	xhr.onreadystatechange = function()
// 	{
// 		if (this.readyState === 4 && this.status === 200)
// 		{
//             console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
//             window.location.href = "http://localhost:8080/ProjectOne/viewResolved";
// 		}
// 	}
// }