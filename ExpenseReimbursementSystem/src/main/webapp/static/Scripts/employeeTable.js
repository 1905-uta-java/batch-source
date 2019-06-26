
let url = "http://localhost:8080/ERS/api/employees";
var ourRequest = new XMLHttpRequest();
ourRequest.open("GET", url);
ourRequest.onload = function() {
if (ourRequest.status >= 200 && ourRequest.status < 400) {
      var ourData = JSON.parse(ourRequest.response);
      console.log(ourData);
      for(let a of ourData){
        addRow(a.id, a.firsName + " "+ a.lastName, a.title, a.user, a.hireDate, a.address, a.city, a.state, a.zip, a.phone, a.email);
        }
    }

}
ourRequest.send();

function addRow(id, name, title, user, hDate, address, city, state, zip, phone, email){

    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");
    let cell8 = document.createElement("td");
    let cell9 = document.createElement("td");
    let cell10 = document.createElement("td");
    let cell11 = document.createElement("td");
    

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    row.appendChild(cell8);
    row.appendChild(cell9);
    row.appendChild(cell10);
    row.appendChild(cell11);

    cell1.innerHTML = id;
    cell2.innerHTML = name;
    cell3.innerHTML = title;
    cell4.innerHTML = user;
    cell5.innerHTML = hDate;
    cell6.innerHTML = address;
    cell7.innerHTML = city;
    cell8.innerHTML = state;
    cell9.innerHTML = zip;
    cell10.innerHTML = phone;
    cell11.innerHTML = email;
   

    document.getElementById("emp-table").appendChild(row);
}