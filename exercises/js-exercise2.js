window.onload = function(){
    document.getElementsByName("google")[0].href="https://www.google.com/";
    document.getElementsByName("google")[0].innerText = "Google";

    document.getElementsByName("twitter")[0].href="https://www.twitter.com/";
    document.getElementsByName("twitter")[0].innerText = "Twitter";

    document.getElementsByName("slack")[0].href="https://slack.com/";
    document.getElementsByName("slack")[0].innerText = "Slack";

    document.getElementsByName("javadocs")[0].href="https://javadocs.com/";
    document.getElementsByName("javadocs")[0].innerText = "JavaDocs";

    document.getElementsByTagName("option")[2].style.display="none";

    document.getElementsByTagName("select")[0].addEventListener("change", alienText);

    document.getElementById("operation").addEventListener("change", calculate);
    document.getElementById("n1").addEventListener("change", calculate);
    document.getElementById("n2").addEventListener("change", calculate);

    document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);

    document.getElementsByTagName("details")[0].addEventListener("mouseout", openDetails);

    concatInnerHTML();

    document.getElementById("earth_time_check").addEventListener("click", earthTime);
}

function alienText(){
    document.getElementsByTagName("p")[5].hidden = false;
}

function check1(){
    if(Number.isInteger(document.getElementById("n1").value)){
        return true;
    }
    return false;
}

function check2(){
    if(Number.isInteger(document.getElementById("n2").value)){
        return true;
    }
    return false;
}

function calculate(event){

    let operation = event.target.value;
    c1 = Number.parseInt(document.getElementById("n1").value, 10);
    c2 = Number.parseInt(document.getElementById("n2").value, 10);
    if(c1 && c2){
    //add
    if(document.getElementById("operation").value === "Add"){
        document.getElementById("result").innerHTML =c1 + c2;
    }
    //Subtract
    if(document.getElementById("operation").value === "Subtract"){
            document.getElementById("result").innerHTML =c1 - c2;
    }
    //Divide
    if(document.getElementById("operation").value === "Divide"){
            document.getElementById("result").innerHTML =c1 / c2;
    }
    //Multiply
    if(document.getElementById("operation").value === "Multiply"){
            document.getElementById("result").innerHTML = c1 * c2;
    }
    }
}
function openDetails(){
    if(document.getElementsByTagName("details")[0].open === true){
    document.getElementsByTagName("details")[0].open=false;
    } else { document.getElementsByTagName("details")[0].open=true; }
}

function concatInnerHTML(){
    s = "";
    var spans = document.getElementsByTagName("span");
    for(span of spans){
        s = s + span.innerHTML;
    }
    console.log(s);
}
function earthTime(){
    now = new Date();
    hour = now.getHours();
    min = now.getMinutes();
    if(min < 10){
        document.getElementById("earth_time").innerHTML = `${hour}:0${min}`;
    } else {document.getElementById("earth_time").innerHTML = `${hour}:${min}`;
}
}