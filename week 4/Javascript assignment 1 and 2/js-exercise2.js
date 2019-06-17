//1
document.getElementById("google").href = "https://www.google.com";
document.getElementById("twitter").href = "https://www.twitter.com";
document.getElementById("slack").href = "https://www.slack.com";
document.getElementById("javadocs").href = "https://www.javadocs.com";


//2
let planet = document.getElementById("planet");
planet = planet.options[2].disabled = true;

//3

let alienPlanet = function(){
    let hiddenText = document.querySelector("[hidden]");
    hiddenText.removeAttribute("hidden");
}
let selected = document.getElementById("planet").selectedIndex;
let selection = document.getElementById("planet").options[selected].value;
console.log(selection);
if(selection != "Earth"){
    alienPlanet();
}



//4 FINISH OFF WITH INPUT VALIDATION


    let Si = document.getElementById("operation").selectedIndex;
    let mathing = document.getElementById("operation").options[Si].value;
    if(mathing == "Add"){
        let sum = parseInt(document.getElementById("n1").value) + parseInt(document.getElementById("n2").value);
        document.write(sum);
    }
    else if(mathing == "Subtract"){
        let sum = parseInt(document.getElementById("n1").value) - parseInt(document.getElementById("n2").value);
        document.write(sum);
    }
    else if(mathing == "Divide"){
        let sum = parseInt(document.getElementById("n1").value) / parseInt(document.getElementById("n2").value);
        document.write(sum);
    }
    else if(mathing == "Multiply"){
        let sum = parseInt(document.getElementById("n1").value) * parseInt(document.getElementById("n2").value);
        document.write(sum);
    }

//5
let deets = document.querySelector("details");
deets.addEventListener("mouseover",openDocument);
deets.addEventListener("mouseleave",closeDocument);

function openDocument(){
    deets.open = true;
}
function closeDocument(){
    deets.open = false;
}


//6
let allThings = document.querySelectorAll("span");
let writeThing = "";
for(let i = 0; i < allThings.length; i++){
    writeThing = writeThing + allThings[i].innerHTML;
}
console.log(writeThing);

//7

let timeButton = document.getElementById("earth_time_check");

timeButton.addEventListener("click", changeTime());

function changeTime(){
    let date = new Date();
    let time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    console.log(time);
    document.getElementById("earth_time").innerHTML = time;
}


