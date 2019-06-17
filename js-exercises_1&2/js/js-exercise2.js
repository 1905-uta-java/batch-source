//Problem 1
let linkGoogle = document.getElementsByName("google");
let linkTwitter = document.getElementsByName("twitter");
let linkSlack = document.getElementsByName("slack");
let linkJavadocs = document.getElementsByName("javadocs");

linkGoogle[0].href = "https://www.google.com";
linkTwitter[0].href = "https://www.twitter.com";
linkSlack[0].href = "https://www.slack.com";
linkJavadocs[0].href = "https://www.oracle.com/index.html";

//Problem 2
let optionResidency = document.getElementById("planet");
optionResidency.remove(2);

//Problem 3
function alienText(){
    document.querySelector(`p[hidden]`).hidden = false;
}

optionResidency.onchange = () => {
    if(optionResidency.value != "Earth"){
        alienText();
    }
}

//Problem 4
let mathOps = document.querySelector(`#operation`);
let n1 = document.querySelector(`#n1`);
let n2 = document.querySelector(`#n2`);
let result = document.querySelector(`#result`);

function performMathOps(num1, num2) {
    let ops = 0;
    console.log(ops);
    if(mathOps.value == "Add"){
        ops = (Number(num1) + Number(num2));
    }

    if(mathOps.value == "Subtract"){
        ops = (num1 - num2);
    }

    if(mathOps.value == "Divide"){
        ops = (num1 / num2);
    }

    if(mathOps.value == "Multiply"){
        ops = (num1 * num2);
    }

    result.innerHTML = ops;
    console.log(ops);
}

n1.oninput = () => {
    if(!isNaN(n1.value) && !isNaN(n2.value)){
        performMathOps(n1.value, n2.value);
    }
}

n2.oninput = () => {
    if(!isNaN(n2.value) && !isNaN(n1.value)){
        performMathOps(n1.value, n2.value);
    }
}

//Problem 5
let details = document.querySelector(`div details`);
function openDetails() {
    details.open = true;
}

details.addEventListener("mouseover", openDetails());

details.addEventListener('mouseout', () =>{
    details.open = false;
    }
);

//Problem 6
let bobRoss = document.querySelectorAll(`span`);

function showBobRoss () {
    let str = "";
    bobRoss.forEach(element => {
        str += element.innerHTML;
    });
    console.log(str);
}
showBobRoss();

//Problem 7
let earthTime = document.querySelector(`#earth_time`);
let earthTimeBtn = document.querySelector(`#earth_time_check`);

earthTimeBtn.addEventListener(`click`, () => {
    let d = new Date();
    earthTime.innerHTML = (
        "Current Time: " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds()
    );
});



