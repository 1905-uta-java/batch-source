window.onload = buttonListener;
function buttonListener(){
    document.getElementById('submit_btn').addEventListener("click",getFact);
}

var baseUrl = 'http://numbersapi.com/';

function getFact(){
    let num = document.getElementById("input").value;
    if(num != ""){
        let option = document.getElementById("optionAPIs").options[document.getElementById("optionAPIs").selectedIndex].innerHTML.toLowerCase();
        sendAjaxGet(baseUrl+num+'/'+option, displayFact);
    } else {
        displayFact("Can't leave input blank");
    }
}

function displayFact(fact){
    document.getElementById("fact").innerHTML = fact;
}

function sendAjaxGet(url, callback){
    let xhr = new XMLHttpRequest();

    xhr.open("GET", url);

    xhr.onreadystatechange = function(){
        if(this.readyState===4 && this.status===200){
            let returnedObject = this.response;
            callback(returnedObject);
        }
        else if(this.readyState===4){
            let returnedObject = "API call failed.";
            callback(returnedObject);
        }
    }

    xhr.send();
}