window.onload = function(){
    let jsonCars = `[{
        "id" : 345,
        "make": "Toyota",
        "model" : "Corolla",
        "year" : 1996
    }, {
        "id" : 347,
        "make": "Mercury",
        "model" : "Sable",
        "year" : 2000
    }, {
        "id" : 8202,
        "make": "Oldsmobile",
        "model" : "Intrigue",
        "year" : 1998
    }]`;

    document.getElementById("addCarBtn").addEventListener("click", addNew);
    
    let intialCars = JSON.parse(jsonCars);


let counter =0 ;

    function addNew(){
        let make = document.getElementById("make-input").value;
        let model = document.getElementById("model-input").value;
        let year = document.getElementById("year-input").value;

        if(make && model && year){
            counter++
            let tbl = document.getElementById("carTable");
        
            
            addRow(make, model, year);
            
            
            
            
            //this also works.
            /*tbl.innerHTML += `<tr>
                        <td>${counter}</td>
                        <td>${make}</td>
                        <td>${model}</td>
                        <td>${year}</td>
                        </tr>`;*/
  
        }

    }

    let addRow = function(make, model, year, id){
        let row = document.createElement("tr");
        let cell1 = document.createElement("td");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");
        let cell4 = document.createElement("td");
        
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);

        if(id === undefined)
            cell1.innerHTML = counter++;
        else
            cell1.innerHTML = id;
        cell2.innerHTML = make;
        cell3.innerHTML = model;
        cell4.innerHTML = year;

        document.getElementById("carTable").appendChild(row);

    }

    for(car of intialCars){
        addRow(car.make, car.model, car.year, car.id);
    }
}
