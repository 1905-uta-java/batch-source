// Problem 1
document.getElementsByName("google").item(0).href="https://www.google.com/";
document.getElementsByName("twitter").item(0).href="https://www.twitter.com/";
document.getElementsByName("slack").item(0).href="https://slack.com/";
document.getElementsByName("javadocs").item(0).href="https://www.oracle.com/technetwork/java/javase/javadoc-137458.html";

// Problem 2
document.getElementById("planet").remove(2);

// Problem 3
function alienText(){
    if(document.getElementById("planet").value != "Earth")
        document.getElementsByTagName("p").item(5).hidden = false;
}
document.getElementById("planet").onchange = alienText;

// Problem 4
function tryCompute(){
    var a = Number.parseInt(document.getElementById("n1").value);
    var b = Number.parseInt(document.getElementById("n2").value);
    if(!Number.isNaN(a) && !Number.isNaN(b)){
        console.log("Computing.");
        var res = document.getElementById("result");
        switch(document.getElementById("operation").value){
            case "Add":
                res.innerHTML = a+b;
                break;
            case "Subtract":
                res.innerHTML = a-b;
                break;
            case "Multiply":
                res.innerHTML = a*b;
                break;
            case "Divide":
                res.innerHTML = a/b;
                break;
            default:
                console.log("Unknown operation.");
        }
    }
}
document.getElementById("n1").onchange = tryCompute;
document.getElementById("n2").onchange = tryCompute;
document.getElementById("operation").onchange = tryCompute;

// Problem 5
function openDetails(){
    var x = document.getElementsByTagName("details").item(0);
    x.open = true;   
}
function closeDetails(){
    var x = document.getElementsByTagName("details").item(0);
    x.open = false;
}
document.getElementsByTagName("details").item(0).onmouseenter = openDetails;
document.getElementsByTagName("details").item(0).onmouseleave = closeDetails;

// Problem 6
var con = "";
var es = document.getElementsByTagName("span");
for(var i = 0;i<es.length;i++){
    con = con + es.item(i).innerHTML;
}
console.log(con);

// Problem 7
function displayTime(){
    document.getElementById("earth_time").innerHTML = "Local time: " + new Date();
}
document.getElementById("earth_time_check").onclick = displayTime;

//CHALLENGE PROBLEMS
// Problem 9
function changeColor(){
    var col = Math.floor(Math.random * 0x888888 + 0x777777).toString(16);
    document.body.style.backgroundColor = "#"+col;
}
function startColorChange(){
    setTimeout(changeColor, 3000);
}
document.getElementsByTagName("h1").item(0).addEventListener("click", startColorChange);

console.log("Changed.");