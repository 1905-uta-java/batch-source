
let url = "http://localhost:8080/ProjectOne/api/viewOwnInformation";
console.log("THIS JS FILE IS BEING EXECUTED!!");
  
function sendPostRequest(url, displayEmployeeInfo)
{
      // console.log("THE LOGOUT REQUEST IS BEING SENT!");
  let xhr = new XMLHttpRequest();
  xhr.open("POST", url);
  xhr.onreadystatechange = function()
  {
      if (this.readyState === 4 && this.status === 200)
      {
          displayEmployeeInfo(this);
      }
  }
  
    var token = sessionStorage.getItem("token");
    console.log("Token is: " + token);

    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    let requestBody = "token="+token;
    console.log(requestBody + " is request body!");
//  console.log(sessionStorage.getItem("token"));
    xhr.send(requestBody);
}

  function displayEmployeeInfo(xhr)
  {
    let employee = JSON.parse(xhr.response);
    let table = document.getElementById("tableEmpInfo");
    console.log(employee);
   
        //let newRow = document.createElement("tr");

        table.innerHTML += 
        `<td>${employee.empID}</td>
        <td>${employee.firstname}</td>
        <td>${employee.lastname}</td>
        <td>${employee.username}</td>
        <td>${employee.password}</td>
        <td>${employee.position}</td>`

        // document.getElementById("tableEmpInfo").innerHTML += newRow;
        //table.appendChild(newRow);
  }
  
  sendPostRequest(url, displayEmployeeInfo);
  console.log("THE REQUEST HAS BEEN SENT!");