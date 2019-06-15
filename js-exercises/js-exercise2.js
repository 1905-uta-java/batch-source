// 1. Make each link direct to the respective website
let google = document.getElementById("google").href = "https://www.google.com/";
let twitter = document.getElementById("twitter").href = "https://www.twitter.com/";
let slack = document.getElementById("slack").href = "https://www.slack.com/";
let javadocs = document.getElementById("javadocs").href = "https://www.javadocs.com/";

// 2. Disable Pluto as an option
document.getElementById("planet").options[2].disabled = true;

// 3. Define a function alienText() which shows the hidden element displaying an alien message. 
// When any planet other than Earth is selected, execute this function.

// Use a QuerySelector "select" and an Event Listener to check when the planet of residency is changed. Then proceed 
// with the function. Check if the source is not equal to earth, and if true, print out words.

document.querySelector("select").addEventListener("change", function (event) {
    let planetChoice = document.getElementById("planet");
    let selectedChoice = planetChoice.options[planetChoice.selectedIndex].value; // Getting the specific value that is currently selected.

    if (selectedChoice !== "Earth") {
        alienText();
    } 
});

let alienText = function(){
    let allP = document.getElementsByTagName("p");
    for (let i = 0; i < allP.length; i++){
        if (allP[i].hasAttribute("hidden")){
            allP[i].removeAttribute("hidden");
        }
    }
}

// 4. When inputs with id n1 and n2 have valid numerical input, perform the operation
// specified in the select. Display the result in the element with id result.

let numberOne = document.getElementById("n1"); // Get value of n1
let numberTwo = document.getElementById("n2"); // Get value of n2
let result = document.getElementById("result"); // Get result of value
let operation = document.getElementById("operation"); // Get operation element
numberOne.addEventListener("change", function(event) {
    numberOne = document.getElementById("n1").value
    numberOne = parseInt(numberOne);
    console.log(numberTwo);
});
numberTwo.addEventListener("change", function(event) {
    numberTwo = document.getElementById("n2").value;
    numberTwo = parseInt(numberTwo);
    console.log(numberTwo);
});
operation.addEventListener("change", function (event) {
    let selectChoice = operation.options[operation.selectedIndex].value; // Store currently selected operation
    let answer;
    if (!isNaN(numberOne) && !isNaN(numberTwo)){ // Check if the values are numbers
        switch (selectChoice) { // Check which is selected
            case ("Add") : 
                 answer = numberOne + numberTwo;
                 console.log("Add chosen");
                 console.log(result);
                 break;
            case ("Subtract") :
                answer = numberOne - numberTwo;
                console.log("Subtract chosen");
                console.log(result);
                break;
            case ("Divide") :
                if (numberTwo !== 0) {
                answer = numberOne / numberTwo;
                console.log("Divide chosen");
                } else {
                    console.log("Can not divide by 0")
                }
                break;
            case ("Multiply") :
                answer = numberOne * numberTwo;
                console.log("Multiply chosen");
        }
        result.innerHTML = answer;
    } else {
        console.log("Not numbers");
    }
});

// Not sure how to make it recognize when number input changes.

// 5. Create a function openDetails() which opens the details element. Invoke this function
// when the details' summary is moused over. The details should be hidden when the mouse is
// removed from the summary.

let details = document.querySelector("details"); // Get details element from documnet
let openDetails = function(){ // Open details function
    details.open = true;
}
let closeDetails = function(){ // Close details function
    details.open = false;
}
details.addEventListener("mouseover", openDetails); // When moused over, open details
details.addEventListener("mouseleave", closeDetails); // When mouse leaves, close details


// 6. Create a function that concatenates the innter HTML of all of the span elements and 
// prints the results to the console.
let innerHtmlConcate = function() {
    let allSpan = document.querySelectorAll("span"); // Get all span from document
    let spanArray = [];
    let inHtml = [];
    for (let i of allSpan){
    spanArray.push(i);
    }
    for (let i = 0; i < spanArray.length; i++){
        let phrase = document.getElementsByTagName("span")[i].innerHTML;
        inHtml.push(phrase);
    }
    let joinedArray = inHtml.join(" ");
    console.log(joinedArray);
}

// 7. Create a function that displays the current time on earth in the span with id "earth_time".
// Invoke this function when "Earth time" button is clicked.
    let displayEarthTime = function() {
    let today = new Date();
    let currentTime = today.getUTCHours() + ":" + today.getUTCMinutes();
    console.log(currentTime);
    let eartTimeSpan = document.getElementById("earth_time");
    let earthTimeBtn = document.getElementById("earth_time_check");

    earthTimeBtn.addEventListener("click", function(event){
        eartTimeSpan.innerHTML = currentTime;
    })
};