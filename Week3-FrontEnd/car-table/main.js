window.onload = function(){
    document.getElementById("addCarBtn").addEventListener("click", addNew);
}

let counter = 1000;

function addNew(){
    let make = document.getElementById("make-input").value;
    let model = document.getElementById("model-input").value;
    let year = document.getElementById("year-input").value;
    console.log(`You have submitted a ${year} ${make} ${model}`);

    if(make&&model&&year){
        addRow(make, model, year);
    } else {
        // display error to user
    }
}

function addRow(make, model, year){

    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);

    cell1.innerHTML = counter++;
    cell2.innerHTML = make;
    cell3.innerHTML = model;
    cell4.innerHTML = year;

    document.getElementById("car-table").appendChild(row);

}