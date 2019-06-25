// generate request for all employees

let url = "http://localhost:8080/ProjectOne/api/viewAllEmps";
function viewAllEmps(url, displayEmps)
{
	console.log("THE GET REQUEST IS BEING GENERATED");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function()
	{
		if (this.readyState === 4 && this.status === 200)
		{
			console.log("YOU GOT THE REQUEST TO EXECUTE SUCCESSFULLY!");
			displayEmps(this);
		}
    }
    xhr.send();
}

function displayEmps(xhr)
{
console.log("THE DISPLAY FUNCITON IS EXECUTING!!");
  let employees = JSON.parse(xhr.response);
  let table = document.getElementById("tableEmpInfo");
  console.log(employees);
  for (let i in employees)
  	{
	  let newRow = document.createElement("tr");

	  newRow.innerHTML = 
	  `<td>${employees[i].empID}</td>
	  <td>${employees[i].firstname}</td>
	  <td>${employees[i].lastname}</td>
	  <td>${employees[i].username}</td>
	  <td>${employees[i].password}</td>
	  <td>${employees[i].position}</td>`

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
viewAllEmps(url, displayEmps);
