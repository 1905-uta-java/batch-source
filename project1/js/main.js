document.getElementById("reburseNav").addEventListener("click", function(){
    document.getElementById('empInfo').hidden = true;
    document.getElementById('remInfo').hidden = false;
    document.getElementById('remInfoLi').classList.toggle("active");
    document.getElementById('empInfoLi').classList.toggle("active");
});

document.getElementById("empInfoNav").addEventListener("click", function(){
    document.getElementById('empInfo').hidden = false;
    document.getElementById('remInfo').hidden = true;
    document.getElementById('remInfoLi').classList.toggle("active");
    document.getElementById('empInfoLi').classList.toggle("active");
});
