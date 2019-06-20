let planetSelect;
let hiddenMessage;

let googleLink;
let twitterLink;
let slackLink;
let javadocsLink;

let number1Select;
let number2Select;
let operationSelect;
let resultText;

let detailsElement;

let earthTimeSpan;
let earthTimeButton;

// Part 1
function setLinks() {
    
    googleLink.innerHTML = "Google";
    googleLink.href = "https://www.google.com/";

    twitterLink.innerHTML = "Twitter";
    twitterLink.href = "https://www.twitter.com/";

    slackLink.innerHTML = "Slack";
    slackLink.href = "https://www.slack.com/";

    javadocsLink.innerHTML = "Javadocs";
    javadocsLink.href = "https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html";
}

// Part 2
function removePluto() {

    if(planetSelect.selectedIndex === 2)
        planetSelect.selectedIndex = -1;

    planetSelect.remove(2);
}

// Part 3
function alienText() {

    hiddenMessage.removeAttribute("hidden");
}

// Part 4
function calculate() {

    let number1 = number1Select.value;
    
    if(isNaN(number1)) {
        resultText.innerHTML = "";
        return;
    }
    
    let number2 = number2Select.value;
    
    if(isNaN(number2)) {
        resultText.innerHTML = "";
        return;
    }

    let operation = operationSelect.selectedIndex;

    /*
        0: Add
        1: Subtract
        2: Divide
        3: Multiply
    */
    switch(operation) {
        case 0:
            resultText.innerHTML = Number(number1) + Number(number2);
            break;
        case 1:
            resultText.innerHTML = Number(number1) - Number(number2);
            break;
        case 2:
            resultText.innerHTML = Number(number1) / Number(number2);
            break;
        case 3:
            resultText.innerHTML = Number(number1) * Number(number2);
            break;
        default:
            resultText.innerHTML = "";
    }
}

// Part 5
function openDetails() {

    detailsElement.open = true;
}

function closeDetails() {

    detailsElement.open = false;
}

// Part 6
function getSpanElements() {

    let spanElements = document.getElementsByTagName("span");
    let result = "";

    for(let sElement of spanElements) {
        result += sElement.innerHTML;
    }
    
    console.log(result);
}

// Part 7
function getEarthTime() {

    earthTimeSpan.innerHTML = new Date().toTimeString();
}

// Part 8


window.onload = function() {

    planetSelect = document.getElementById("planet");
    hiddenMessage = document.getElementsByTagName("p")[5];

    googleLink = document.getElementsByName("google")[0];
    javadocsLink = document.getElementsByName("javadocs")[0];
    twitterLink = document.getElementsByName("twitter")[0];
    slackLink = document.getElementsByName("slack")[0];
    
    number1Select = document.getElementById("n1");
    number2Select = document.getElementById("n2");
    operationSelect = document.getElementById("operation");
    resultText = document.getElementById("result");

    detailsElement = document.getElementsByTagName("details")[0];

    earthTimeSpan = document.getElementById("earth_time");
    earthTimeButton = document.getElementById("earth_time_check");

    // Part 1
    setLinks();

    // Part 2
    removePluto();

    // Part 3
    planetSelect.addEventListener("change", alienText);

    // Part 4
    operationSelect.addEventListener("change", calculate);
    number1Select.addEventListener("change", calculate);
    number2Select.addEventListener("change", calculate);

    // Part 5
    detailsElement.addEventListener("mouseover", openDetails);
    detailsElement.addEventListener("mouseout", closeDetails);

    // Part 7
    earthTimeButton.addEventListener("click", getEarthTime);
}