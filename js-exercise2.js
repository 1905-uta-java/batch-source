/*
Make each link direct the user to its respective website (see id)
*/

document.getElementById("google").href = "https://www.google.com";
document.getElementById("twitter").href = "https://www.twitter.com";
document.getElementById("slack").href = "https://www.slack.com";
document.getElementById("javadocs").href = "https://www.javadocs.com";

/*
Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
*/

//console.log(document.getElementById("planet").options[2]); 
let PlutoOption = document.getElementById("planet").options[2];
PlutoOption.disabled = true;

/*
Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.
*/

// add eventListner to planet selector
let planetSelector = document.getElementById("planet");
planetSelector.addEventListener("change", alienText);

// when planet selector is changed to something other than earth, call alienText()
function alienText()
{    
     if (planet.options[planet.selectedIndex].value != "Earth")
     {
         // console.log(document.querySelectorAll("[hidden]"));
          let hiddenMessage = document.querySelectorAll("[hidden]");
          hiddenMessage.removeAttribute("hidden"); 
     }    
}




/*
When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.
*/

// grab elements from document
let n1 = document.getElementById("n1");
let n2 = document.getElementById("n2");
let operation = document.getElementById("operation");
operation = operation.options[operation.selectedIndex].value;

//  console.log(n1);
//  console.log(n2);
n1.addEventListener("change", getResults);
n2.addEventListener("change", getResults);

// verify input and display results
function getResults()
{
     let result = 0;
     let n1 = document.getElementById("n1").value;
     let n2 = document.getElementById("n2").value;
     console.log(`n1 is ${n1}, n2 is ${n2}`);
     let n1Number = parseInt(n1);
     let n2Number = parseInt(n2);
     console.log(`n1Number is ${n1Number}, n2Number is ${n2Number}`);
     
     // if numbers are valid inputs, perform the following mathematical operations
     if (!isNaN(n1Number) && !isNaN(n2Number))
     {
          console.log("Entered the if-block");
          console.log("Operation is: " + operation);
     
         if (operation == "Add")
         {
              result = n1Number + n2Number;
         }
         else if (operation == "Subtract")
         {
              result = n1Number - n2Number;
         }
         else if (operation == "Multiply")
         {
              result = n1Number * n2Number;
         }
         else if (operation == "Divide")
         {
              result = n1Number / n2Number;
         }
         console.log("Result inside the if block: " + result);
         //document.getElementById("result").innerHTML = result;

     }
     console.log("Result outside the if-block: " + result);
     // enter the result into the documents inner HTML.
     document.getElementById("result").innerHTML = result;
}



/*
Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.
*/

var detailsElement = document.getElementsByTagName("details");
var summaryElement = document.getElementsByTagName("summary");
summaryElement[0].addEventListener("mouseover", openDetails);
summaryElement[0].addEventListener("mouseout", closeDetails);

function openDetails()
{
     detailsElement[0].open = true;
}

function closeDetails()
{
     detailsElement[0].open = false;
}

/*
Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
*/

function concatenateSpans()
{
     let allSpans = document.querySelectorAll("span");
     let concatenatedSpans = "";
     for (let i = 0; i < allSpans.length; ++i)
     {
          let innerHTML = allSpans[i].innerHTML;
          concatenatedSpans += innerHTML;
     }
     console.log(concatenatedSpans);
}

/*
Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked.
*/

let earthTime = document.getElementById("earth_time");
let earthTimeButton = document.getElementById("earth_time_check");

earthTimeButton.addEventListener("click", currentTime);
console.log(earthTimeButton);
//console.log(earthTime);
//earthTime[0].addEventListener("click", currentTime);
function currentTime()
{
     let date = new Date();
     //console.log(date);
      let hours = date.getHours();
      let minutes = date.getMinutes();
      let seconds = date.getSeconds();
      console.log(`Earthian Time: ${hours} hours, ${minutes} minutes, ${seconds} seconds`);
}


