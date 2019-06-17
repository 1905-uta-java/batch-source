window.onload = function() {
    submitButton.addEventListener("click", getShips);
    console.log("working");
}

let ships;
let table = document.getElementById("searchtable");
// let searchField = document.getElementById("searchfield");
let submitButton = document.getElementById("submit");


function getShips() {
    console.log(`Submitted`);
    // if(event.keyCode === 13) {

        // let inputString = searchField.value;
        let xhr = new XMLHttpRequest();
        // inputString = inputString.replace(" ", "%20");

        xhr.open("GET", "https://swapi.co/api/starships/");

        xhr.onreadystatechange = function() {

            if(xhr.readyState === 4) {

                if(xhr.status === 200) {

                    let shipsJson = xhr.response;
                    ships = JSON.parse(shipsJson);
                    setShips(ships.results);

                } else {

                    console.log("Something went wrong");
                }
            }
        };

        console.log(`Ready State: ${xhr.readyState}`);

        xhr.send();

        console.log(`Ready State: ${xhr.readyState}`);
    // }
}

function setShips(ships) {

    table.innerHTML = `<tr>
                            <th>Name</td>
                            <th>Model</td>
                            <th>Length</td>
                            <th>Hyperdrive Rating</td>
                        </tr>`;
    for(ship of ships)
        addShip(ship);
}

function addShip(ship) {

    table.innerHTML += `<tr>
                            <td>${ship.name}</td>
                            <td>${ship.model}</td>
                            <td>${ship.length}</td>
                            <td>${ship.hyperdrive_rating}</td>
                        </tr>`;
}