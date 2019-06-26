document.getElementById("getD").addEventListener('click', getData);

function getData() {
    let g = document.getElementById("empID").value;
    var x = '' + g;
    console.log(x);

   let url = "http://localhost:8080/ERS/api/requests?empID=" +x;
   var ourRequest = new XMLHttpRequest();
   ourRequest.open("GET", url);
   ourRequest.onload = function() {
   if (ourRequest.status >= 200 && ourRequest.status < 400) {
         var ourData = JSON.parse(ourRequest.response);
         console.log(ourData);
         console.log(x);
         console.log("Test")
         for(let a of ourData){
               if(a.empId == x){
                addRow(a.reqID, a.empId, a.amount, a.description, a.status, a.resolvedBy);
         }
   
           }
       }
   
   }
   ourRequest.send(); 
}

function addRow(rID, empId, amount, desc, status, resolvedBy) {

    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
   

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    
   

    cell1.innerHTML = rID;
    cell2.innerHTML = empId;
    cell3.innerHTML = amount;
    cell4.innerHTML = desc;
    cell5.innerHTML = status;
    cell6.innerHTML = resolvedBy;
    
   

    document.getElementById("spec-table").appendChild(row);
}