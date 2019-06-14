// add an event listener to submit button
document.getElementById("submitButton").addEventListener("click", searchWeather);

let baseUrl = "http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=";

// get input value from zipcode input element
function searchWeather(){
    let zipInput = document.getElementById("zipcode").value;
    sendAjaxGet(baseUrl+zipInput, displayWeather);
    // sendAjaxGet(userUrl, displayUsers);
}


// use input to make a GET request to weather api using zipcode
function sendAjaxGet(url, callback){
    let xhr = new XMLHttpRequest(); // || new ActiveXObject 
    
    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState===4 && this.status===200){
            let returnedObject = JSON.parse(this.response);
            callback(returnedObject);
        } else if (this.readyState===4){
            console.log("something went wrong!")
        }
    }

    xhr.send();
}


// takes in the response we get from our request to the server and displays weather info accordingly
function displayWeather(weatherInfo){
    console.log(weatherInfo)
}