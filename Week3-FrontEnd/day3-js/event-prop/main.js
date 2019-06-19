const capturing = true;
const bubbling = false;

const innerDiv = document.getElementById("inner");
const middleDiv = document.getElementById("middle");
const outerDiv = document.getElementById("outer");


innerDiv.addEventListener("click", function(){
    alert("INNER - capturing");
}, capturing);

middleDiv.addEventListener("click", function(){
    alert("MIDDLE - capturing");
}, capturing);

outerDiv.addEventListener("click", function(){
    alert("OUTER - capturing");
}, capturing);

innerDiv.addEventListener("click", function(event){
    alert("INNER - bubbling");
    // event.stopImmediatePropagation();
    event.stopPropagation();
}, bubbling);

innerDiv.addEventListener("click", function(event){
    alert("INNER - bubbling also");
}, bubbling);

middleDiv.addEventListener("click", function(){
    alert("MIDDLE - bubbling");
}, bubbling);

outerDiv.addEventListener("click", function(){
    alert("OUTER - bubbling")
}, bubbling);