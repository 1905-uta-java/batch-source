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
            console.log(returnedObject);
            callback(returnedObject);
        } else if (this.readyState===4){
            let readyStateMessage = this.readyState;
            let HTTPResponse = this.status;
            console.log(`An error occured. Ready state complete with no returned object.\n
            Ready state returned status code: ${this.readyState}\n
            HTTP response returned status code: ${this.status}`);
            errorMessage(readyStateMessage, HTTPResponse);
        }
    }
    xhr.send();
}

function displayCharacter(returnedObject){
    console.log(returnedObject);
    document.getElementById("resultsTable").hidden=false;
    document.getElementById("result").hidden=false;
    document.getElementById("name").innerHTML = `${returnedObject.name}`;
    document.getElementById("height").innerHTML = `${returnedObject.height}`;
    document.getElementById("mass").innerHTML = `${returnedObject.mass}`;
    document.getElementById("birthYear").innerHTML = `${returnedObject.birth_year}`;

}
function errorMessage(readyStateMessage, HTTPResponse){
    document.getElementById("messageToUser").hidden=false;
    document.getElementById("error").hidden=false;
    document.getElementById("errorPart2").hidden=false;
    document.getElementById("messageToUser").innerHTML = `That was not a valid character number.`;
    document.getElementById("error").innerHTML = `Ready state is: ${readyStateMessage}`;
    document.getElementById("errorPart2").innerHTML = `HTTP response returned status code: ${HTTPResponse}`;
}