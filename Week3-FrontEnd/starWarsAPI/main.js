// add an event listener to submit button
document.getElementById("submitButton").addEventListener("click", searchByCharacterNumber);

let baseUrl = "https://swapi.co/api/people/";


function searchByCharacterNumber(){
    let characterNumber = document.getElementById("characterNumber").value;
    sendAjaxGet(baseUrl+characterNumber, displayCharacter);
}

function sendAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();

    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState===4 && this.status===200){
            let returnedObject=JSON.parse(this.response);
            callback(returnedObject);
            console.log(returnedObject);
        } else if (this.readyState===4){
            console.log("error message 4");
        }
    }
    xhr.send();
}

function displayCharacter(returnedObject){
    console.log(returnedObject);
    document.getElementById("result").hidden=false;
    // add boot strap class to new row
    document.getElementById("name").innerHTML = `${returnedObject.name}`;
    document.getElementById("height").innerHTML = `${returnedObject.height}`;
    document.getElementById("mass").innerHTML = `${returnedObject.mass}`;
    document.getElementById("birthYear").innerHTML = `${returnedObject.birth_year}`;

}
function errorMessage(){

}