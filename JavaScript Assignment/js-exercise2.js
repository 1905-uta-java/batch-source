//QUESTION 1
/**
    Make each link direct the user to its respective website (see id)
 */
document.getElementById("google").href = 'https://www.google.com';
document.getElementById("twitter").href = 'https://www.twitter.com';
document.getElementById("slack").href = 'https://www.slack.com';
document.getElementById("javadocs").href = 'https://www.javadocs.com';



//QUESTON 2
/*
    Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
 */
 let planet = document.getElementById("planet");
 planet.options[2].disabled = "true";




 //QUESTION 3
 /*
    Define a function alienText() which shows the hidden element displaying 
    an alien message. When any planet other than Earth is selected, execute 
    this function.
 */

document.getElementById("planet").addEventListener("change", alienText);

function alienText(){
    if(planet.options[planet.selectedIndex].value != "Earth"){
        let p  = document.getElementsByTagName("p");
        for(let i = 0; i < p.length; i++){
            if(p.item(i).hasAttribute("hidden")){
                p.item(i).removeAttribute("hidden");
                break;
            }
        }
    }
}



//QUESTION 4
/*
    When inputs with id n1 and n2 have valid numerical input, perform the
    operation specified in the select. Display the result in the element 
    with id result.
 */
 //isNaN(x)

let n1 = document.getElementById("n1");
let n2 = document.getElementById("n2");
let calcOp, answer, n1Val, n2Val;
document.getElementById("n1").addEventListener("change", calculate);
document.getElementById("n2").addEventListener("change", calculate);

function calculate(){
    console.log("made it to calculate");
    console.log("N1: " + n1.value + " n2: "+ n2.value);
    
    n1Val = parseInt(n1.value);
    n2Val = parseInt(n2.value);
    
    if(!isNaN(n1Val) && !isNaN(n2Val)){
        calcOp = document.getElementById("operation");
        calcOp = calcOp.options[calcOp.selectedIndex].value;

        switch(calcOp){
            case "Add":
                answer = n1Val + n2Val;
                break;
            case "Subtract":
                answer = n1Val-n2Val;
                break;
            case "Divide":
                if(n2 != 0)
                    answer = n1Val/n2Val;
                else
                    answer = "Can't divide by 0";
                break;
            case "Multiply":
                answer = n1Val*n2Val;
                break;
            default:
                answer = "Error....wait how'd you get here?";
                break;
        }
        
    } else{
        answer = "Input is bad";
    }

    document.getElementById("result").innerHTML = answer;
}



//QUESTION 5
/*
    Create a function openDetails() which opens the details element.
    Invoke this function when the details’ summary is moused over.
    The details should be hidden when the mouse is removed from the summary.
*/

document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);

function openDetails(){
    document.getElementsByTagName("details")[0].open = true;
}
function closeDetails(){
    document.getElementsByTagName("details")[0].open = false;
}



//QUESTION 6
/*
    Create a function that concatenates the inner HTML of all of the span 
    elements and prints the results to the console.
*/
function printAllSpans(){
    let spanArr = document.getElementsByTagName("span");
    let spanStr = "";
    for(let i = 0; i < spanArr.length; i++){
        spanStr += spanArr[i].innerHTML;
    }

    console.log(spanStr);
}


//QUESTION 7
/*
    Create a function that displays the current time on earth in the span 
    with id “earth_time”. Invoke this function when “Earth time” button is clicked. 
*/
document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);
let uHours, uMin, uSec, currUTC, suff;
let date = new Date();

function displayEarthTime(){
    uHours = date.getUTCHours();
    uMin = date.getUTCMinutes();
    uSec = date.getUTCSeconds();

    if(uHours > 12) suff = "PM";
    else suff = "AM";
    
    if(uHours != 12) uHours %= 12;

    currUTC = uHours + ":" + uMin + ":" + uSec + " " +  suff;
    
    document.getElementById("earth_time").innerHTML = currUTC;
}