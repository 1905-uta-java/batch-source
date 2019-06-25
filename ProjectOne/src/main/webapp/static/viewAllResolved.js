// generate request for all employees

let url = "http://localhost:8080/ProjectOne/api/viewResolvedAll";
function pendingRequestsForAllEmps(url, displayRequests)
{
	console.log("THE GET REQUEST IS BEING GENERATED");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
			console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
			displayRequests(this);
		}
    }
    xhr.send();
}

function displayRequests(xhr)
{
	console.log("THE DISPLAY FUNCITON IS EXECUTING!!");
  let requests = JSON.parse(xhr.response);
  let table = document.getElementById("table");
  console.log(requests);
  for (let i in requests)
  	{
	  let newRow = document.createElement("tr");

	  newRow.innerHTML = 
	  `<td>${requests[i].reqID}</td>
	  <td>${requests[i].ammount}</td>
	  <td>${requests[i].reason}</td>
	  <td>${requests[i].status}</td>
	  <td>${requests[i].createdBy}</td>
	  <td>${requests[i].resolvedBy}</td>
	  <td>${requests[i].outcome}</td>`

	  //document.getElementById("table").innerHTML += newRow;
	  table.appendChild(newRow);
  	}
}

// logoout
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



// call function to send request
pendingRequestsForAllEmps(url, displayRequests);
