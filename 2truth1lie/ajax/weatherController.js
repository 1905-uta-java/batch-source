document.getElementById("submitButton").addEventListener("click", getZip);

let baseUrl = "http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=";

function getZip(){
    let zip = document.getElementById("zip").value;
    sendReq(baseUrl+zip, displayWeather);
}

function sendReq(url, callback){
    let xhr = new XMLHttpRequest();

    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            //let jsonResponse = this.response();
            let weather = JSON.parse(this.response);
            console.log(weather);
            callback(weather);
        } 
    }
    xhr.send();
}

//gets request from server, then displays weather
function displayWeather(weather){
    console.log("Got weather");
    document.getElementById("loc").innerHTML = 
    weather.location.name + ", " + weather.location.region + ", " +
    weather.location.country;
    
    document.getElementById("condition").innerHTML = 
    weather.current.condition.text;
    
    document.getElementById("temp").innerHTML = 
    weather.current.temp_f + "&#176;\tFeels like: " + weather.current.feelslike_f + "&#176;" ;
    
    document.getElementById("icon").src = 
    "http:"+ weather.current.condition.icon;
    
}
