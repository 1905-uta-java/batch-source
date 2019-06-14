console.log("hello from js")

// getting our img element
let picElement = document.getElementById("main-pic");
// console.log(picElement);
let catImgUrl = "https://devblogs.nvidia.com/wp-content/uploads/2016/07/cute.jpg";
let paintingImgUrl = "https://images.fineartamerica.com/images-medium-large-5/autumns-glow-c-steele.jpg";
picElement.src = catImgUrl;

// accessing our "figcaption"s
let capts = document.getElementsByTagName("figcaption");
capts[0].innerHTML = "look how cute this cat is";


// create a new node
let newNode = document.createElement("h3");
newNode.innerHTML = "Check out my new node!!";

let bodyNode = document.getElementsByTagName("body")[0];
bodyNode.appendChild(newNode);

// accessing our link and clicking on it 
let link = document.getElementsByTagName("a")[0];
// console.log(link);
// link.click();


picElement.addEventListener("mouseover", changePic);

function changePic(event){
    // console.log(event.clientX+", "+event.clientY);
    let currentUrl = event.target.src;
    // event.target would be picElement in this case
    if(currentUrl === catImgUrl){
        event.target.src = paintingImgUrl;
        capts[0].innerHTML = "look how nice this painting is";
    } else {
        event.target.src = catImgUrl;
        capts[0].innerHTML = "look how cute this cat is";
    }
}



