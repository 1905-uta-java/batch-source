document.getElementById('google').href = "https://www.google.com/?client=safari"; // Question number 1.1.

document.getElementById('twitter').href = "https://twitter.com"; // Question number 1.2.

document.getElementById('slack').href = "https://slack.com"; // Question number 1.3.

document.getElementById('javadocs').href = "https://docs.oracle.com/javase/8/docs/"; // Question number 1.4.


// Question 2
document.getElementById('planet').options[2].disabled = true; //



// Question 3
document.getElementById('planet').addEventListener('change', function() {
    let value = document.getElementById('planet').value;
    let check = document.getElementById('planet').options[0].value;
    if (value != check) {
        document.getElementsByTagName('P')[5].removeAttribute('hidden');
    }
});


// Question 4

var operation = document.getElementById("operation");
document.getElementById("n1").type = "number";
document.getElementById("n2").type = "number";
var n1 = document.getElementById("n1");
var n2 = document.getElementById("n2");
var result = 0;

function calculate(operation, n1, n2) {
    switch (operation) {
        case "Add":
            result = n1 + n2;
            document.getElementById("result").innerHTML = result;
            break;
        case "Subtract":
            result = n1 - n2;
            document.getElementById("result").innerHTML = result;
            break;
        case "Divide":
            result = n1 / n2;
            document.getElementById("result").innerHTML = result;
            break;
        case "Multiply":
            result = n1 * n2;
            document.getElementById("result").innerHTML = result;
            break;
        default:
            console.log("Invalid Input");
            break;
    }
}

function readyToCalculate() {

    let x = Number(n1.value);
    let y = Number(n2.value);
    if (x && y && operation.value) {
        calculate(operation.value, x, y);
    }
}
operation.addEventListener("change", readyToCalculate);
n1.addEventListener("change", readyToCalculate);
n2.addEventListener("change", readyToCalculate);

// Question 5.

document.getElementsByTagName("details")[0].addEventListener("mouseover", function() {
    let details = document.getElementsByTagName("details")[0];
    return details.open ? details.open = false : details.open = true;
});

// Question 6.


function printElement(elements) {
    for (let i = 0; i < elements.length; i++) {
        console.log(elements[i].innerHTML);
    }
}
let spans = document.getElementsByTagName("span");
printElement(spans);


// Question 7.

function displayTime() {
    let time = "";
    let today = new Date();
    let hour = today.getHours();
    let min = today.getMinutes();
    let sec = today.getSeconds();
    // stores military time with seconds
    time = hour + ':' + min + ':' + sec;
    console.log("Time :" + time);
}

document.getElementById("earth_time_check").addEventListener("click", displayTime);