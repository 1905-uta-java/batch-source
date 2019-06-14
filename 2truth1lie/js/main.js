document.getElementById("lonLabel").addEventListener("click", ohDang);


function ohDang(event){
    console.log(event.clientX + " " + event.clientY)
    console.log(event);
}

//document.getElementById('lonLabel').addEventListener("mouseover", ohDang);