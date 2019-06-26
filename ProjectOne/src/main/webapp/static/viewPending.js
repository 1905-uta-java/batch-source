
let url = "http://localhost:8080/ProjectOne/api/viewPending";
  
function sendPostRequest(url, callback)
{
  let xhr = new XMLHttpRequest();
  xhr.open("POST", url);
  xhr.onreadystatechange = function()
  {
      if (this.readyState === 4 && this.status === 200)
      {
          callback(this);
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

  function displayRequests(xhr)
  {
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
  
  sendPostRequest(url, displayRequests);
  console.log("THE REQUEST HAS BEEN SENT!");