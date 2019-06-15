// 1. Make each link direct the user to its respective website (see id) 
let googleLink = document.getElementById('google');
googleLink.href = "https://www.google.com/";
let twitterLink = document.getElementById('twitter');
twitterLink.href = "https://twitter.com/"
let slackLink = document.getElementById('slack');
slackLink.href = "https://revaturepro.slack.com/"
let javadocs = document.getElementById('javadocs');
javadocs.href = "https://docs.oracle.com/javase/8/docs/"
// 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!) 
document.getElementById("planet").options[2].disabled = true;

// 3. Define a function alienText() which shows the hidden element displaying an alien message. 
// When any planet other than Earth is selected, execute this function.
// Where el is the DOM element you'd like to test for visibility
function alienText(){    
    let currentPlanet = document.getElementById("planet").value;
    let earth = document.getElementById("planet").options[0].value;
    if(currentPlanet != earth){
        document.getElementsByTagName("P")[5].removeAttribute("hidden");
    }
}
document.getElementById("planet").addEventListener("change", alienText);

// 4. When inputs with id n1 and n2 have valid numerical input, 
//perform the operation specified in the select. 
// Display the result in the element with id result. 
var result = 0;
var operation = document.getElementById("operation");
document.getElementById("n1").type = "number";
document.getElementById("n2").type = "number";
var firstNumber = document.getElementById("n1");
var secondNumber = document.getElementById("n2");

function calculate(operation, firstNumber, secondNumber){
    switch(operation) {
        case "Add":
            result = firstNumber + secondNumber;
            document.getElementById("result").innerHTML = `${result}`;
            break;
        case "Subtract":
            result = firstNumber - secondNumber;
            document.getElementById("result").innerHTML = `${result}`;
            break;
        case "Divide":
            result = firstNumber / secondNumber;
            document.getElementById("result").innerHTML = `${result}`;
            break;
        case "Multiply":
            result = firstNumber * secondNumber;
            document.getElementById("result").innerHTML = `${result}`;
            break;
        default:
            console.log("that's not a valid operation here");
            break;  
      }
}
//once both have values call to calculate
function readyToCalculate(){
    // cast string inputs to number data type
    let x = Number(firstNumber.value);
    let y = Number(secondNumber.value);    
    if(x != null && 
    y != null && 
    operation.value != null){
        calculate(operation.value, x, y);
    }
}
operation.addEventListener("change", readyToCalculate);
firstNumber.addEventListener("change", readyToCalculate);
secondNumber.addEventListener("change", readyToCalculate);

// 5. Create a function openDetails() which opens the details element. 
// Invoke this function when the details’ summary is moused over. 
// The details should be hidden when the mouse is removed from the summary.  
function openDetails(){
    let details = document.getElementsByTagName("details")[0];
    return details.open ? details.open = false : details.open = true;
}
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
 
// 6. Create a function that concatenates the inner HTML of 
// all of the span elements
// and prints the results to the console. 
function concatInnerHTML(elements){ 
    for (i=0; i < elements.length; i++){
        console.log(elements[i].innerHTML)
    }
} 
// calls on page load
let spans = document.getElementsByTagName("span");
concatInnerHTML(spans);

// 7. Create a function that displays the current time 
// on earth in the span with id “earth_time”. 
// Invoke this function when “Earth time” button is clicked.
function displayEarthTime(){
    let aTimeString = "";
    let today = new Date();
    let hh = today.getHours();
    let mm = "0" + today.getMinutes();
    let ss = "0" + today.getSeconds();
    // stores military time with seconds
    aTimeString = hh + ':' + mm.substr(-2) + ':' + ss.substr(-2);  
    console.log(`Hello earthling, your time is ${aTimeString}`);
}

document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);
// challenge questions 

// 8. Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri Bb if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri Bb. (try http://www.astropical.space/astrodb/apiref.php​) Provide an implementation for getting this value using both AJAX and the fetch API. 
 
// 9. Three seconds after a user clicks on the “Intergalactic Directory” heading, 
// the background color should change to a random color. 
//Make sure this color is never black so we can still read our black text! 
//(there are other dark colors it could change to where we also couldn’t see the 
// text but it’s enough to just accommodate for a black background) 
function getRandomColor(){
    var letters = "0123456789ABCDEF";
    var color = "#";
    for (var i = 0; i < 6; i++){
      color += letters[Math.floor(Math.random() * 16)];
    }
    // while color returns a range of black get another one
    while(color.startsWith("0") || color.startsWith("1") || 
        color.startsWith("2") || color.startsWith("3")){
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }   
    }
    return color;
  }
    
function changeBackgroundToRandomColor(){
    let randomColor = getRandomColor();
    document.body.style.backgroundColor = randomColor;
}
changeBackgroundToRandomColor();
 
// 10.When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, check that first and last name are at least 
// two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows. 
 
// 11.Define function walkTheDom(node, func) This function should traverse every node in the DOM.  Use recursion. On each node, calle func(node). 
 