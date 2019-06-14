/*****************************************************************
//Make each link direct the user to its respective website
//See id
*****************************************************************/

document.getElementsByName("google")[0].href = "https://google.com";
document.getElementsByName("twitter")[0].href = "https://twitter.com";
document.getElementsByName("slack")[0].href = "https://slack.com/";
document.getElementsByName("javadocs")[0].href = "https://docs.oracle.com/javase/8/docs/api/";



/*****************************************************************
//Disable the Pluto Planet of Residency option
*****************************************************************/

document.getElementById("planet").children[2].style.display = 'none';



/*****************************************************************
//Define a function alienText() which show the hidden element displaying an alien message.
//When any planet other than Earth is selected, execute this function.
*****************************************************************/

document.getElementById("planet").addEventListener("change",alienText);

function alienText(){
    let ps = document.getElementsByTagName("p");
    for(i of ps){
        if(document.getElementById("planet").value !== "Earth"){
            if(i.innerHTML === "Beep boop"){
                i.hidden = false;
            }
        }else{
            if(i.innerHTML === "Beep boop"){
                    i.hidden = true;
            }
        }
    }
    
}



/*****************************************************************
//When inputs with id n1 and n2 have valid numerical input, perform the operation specified
//Display the result in the element with the id result
*****************************************************************/

document.getElementById("operation").addEventListener("change",calculate);
document.getElementById("n1").addEventListener("input",calculate);
document.getElementById("n2").addEventListener("input",calculate);

function calculate(){
    let num1 = parseFloat(document.getElementById("n1").value);
    let num2 = parseFloat(document.getElementById("n2").value);
    let operation = document.getElementById("operation").value;

    //Check if n1 and n2 are numbers
    if(isNaN(num1) === false && isNaN(num2) === false){
        //Check which operation is selected
        if(operation === "Add"){
            document.getElementById("result").innerHTML = num1+num2;
        }else if(operation === "Subtract"){
            document.getElementById("result").innerHTML = num1-num2;
        }else if(operation === "Multiply"){
            document.getElementById("result").innerHTML = num1*num2;
        }else {
            document.getElementById("result").innerHTML = num1/num2;
        }
    }

}



/*****************************************************************
//Create a function openDetails() which opens the details element.
//Inforce this function when the details summary is moused over.
//The details should be hidden when the mouse is removed from the summary
*****************************************************************/

document.getElementsByTagName("details")[0].addEventListener("mouseover",openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseleave",openDetails);


function openDetails(event){
    if(event.target.tagName === "SUMMARY" )
    {
        document.getElementsByTagName("details")[0].open = true;
    }else{
        document.getElementsByTagName("details")[0].open = false;
    }
}



/*****************************************************************
//Create a function that concatenates the inner HTML of all of the span elements
//Print the results to console
*****************************************************************/

let spans = document.getElementsByTagName("span");

let concatstring = "";

for(i of spans){
    concatstring = concatstring + i.innerHTML;
}

console.log(concatstring);



/*****************************************************************
//Create a function that displays the current time on earth in the span with id "earth_time"
//Invoke this function when "Earth time" button is clicked
*****************************************************************/

document.getElementById("earth_time_check").addEventListener("click",displayTime);

function displayTime(){
    let current = new Date();
    let time = current.getHours() + ":" + current.getMinutes() + ":" + current.getSeconds();

    document.getElementById("earth_time").innerHTML = time;
}







/*
****************************************
**********CHELLENGE QUESTIONS***********
****************************************
*/

/*****************************************************************
Create two other functions which calculates and displays the 
time passed on Mars and Alpha Centauri Bb if the onset of 
January 1st, 1970 occured at the same time. Invoke the 
respective functions when their time buttons are clicked. An 
orbital period for Mars is 687 Earth days. Using an external 
api to get the orbital period for Alpha Centauri Bb. 
(try http://www.astropical.space/astrodb/apiref.php) Provide 
an implementation for getting this value using both AJAX and 
the fetch API.
*****************************************************************/






/*****************************************************************
Three seconds after a user clicks on the “Intergalactic Directory” 
heading, the 	background color should change to a random color. 
Make sure this color is never black so we can still read our black text!
 (there are other dark colors it could change to where we also couldn’t 
    see the text but it’s enough to just accommodate for a black 
    background)
*****************************************************************/






/*****************************************************************
When the submit button is pressed, get the values from all of the input 
into a new row in the table below.  Make sure no input is empty, check 
that first and last name are at least two letters each. Validate for 
valid phone number and email structure. This should continue to work 
for multiple entries and rows.
*****************************************************************/






/*****************************************************************
Define function walkTheDom(node, func)
This function should traverse every node in the DOM. 
Use recursion. On each node, calle func(node).
*****************************************************************/