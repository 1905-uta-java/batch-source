// 1. link direct the user to its respective website 

let link1 = document.getElementById("google");
link1.setAttribute("href", "https://www.google.com/");

let link2 = document.getElementById("twitter");
link2.setAttribute("href", "https://twitter.com/");

let link3 = document.getElementById("slack");
link3.setAttribute("href", "https://slack.com/");

let link4 = document.getElementById("javadocs");
link4.setAttribute("href", "https://docs.oracle.com/en/java/");

// 2. Disable pluto
let p =  document.getElementById("planet").getElementsByTagName("option");

for(let i = 0; i < p.length; i++) {
    if(p[i].value.toLowerCase() == "pluto") {
        p[i].setAttribute("disabled",true);
    }
}

// 3. Shows the hidden element displaying an alien message.

document.getElementById("planet").addEventListener("change", alienText);

function alienText(){
    // Get value selected for residency
    let planetChoice = document.getElementById("planet").value;
    // If not Earth
    if(planetChoice != "Earth") {
        // Search for hidden elements
        let k = document.getElementsByTagName("p");
        for(let i = 0; i < k.length; i++) {
            // If an element of p is hidden, un hide it
            if (window.getComputedStyle(k[i]).display === "none") {
                k[i].hidden = false;

            }
        }

    }
}


// 4. Calculator

document.getElementById("n1").addEventListener("change", calculate);
document.getElementById("n2").addEventListener("change", calculate);
document.getElementById("operation").addEventListener("change", calculate);

function calculate(){
    let a = Number.parseInt(document.getElementById("n1").value);
    let b = Number.parseInt(document.getElementById("n2").value);
    let result = document.getElementById("result");
    if (Number.isInteger(a) && Number.isInteger(b)){

        switch(document.getElementById("operation").value){
            case "Add":
                result.innerHTML = a+b;
                break;
            case "Subtract":
                result.innerHTML = a-b;
                break;
            case "Multiply":
                result.innerHTML = a*b;
                break;
            case "Divide":
                result.innerHTML = a/b;
                break;
            default:
                result.innerHTML = "invalid";
        }
    }
}

// 5. Show details using mouseover

let d = document.getElementsByTagName("details")[0];

d.addEventListener("mouseover", openDetails);
d.addEventListener("mouseout", closeDetails);

function openDetails() {
    d.open = true;
}
function closeDetails() {
    d.open = false;
}


// 6. prints all innerHTML of sapn to the console
function getAllSpan() {
    let allSpan = document.getElementsByTagName("span");

    for(let i = 0; i < allSpan.length; i++) {

        console.log(allSpan[i].innerHTML);

    }
}

// 7. Earth Time

let time = document.getElementById("earth_time_check");
time.addEventListener("click", getTime);

function getTime() {

    var today = new Date();
    var n = today.toLocaleTimeString();
    ///var h = today.getHours();
    //var m = today.getMinutes();
   // var s = today.getSeconds();

    document.getElementById("earth_time").innerHTML ="<span>" + n +"</span>"
}