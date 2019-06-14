 document.getElementById("bntSubmit").addEventListener("click", getFilmInfo);
 
 let swapiUrl = "https://swapi.co/api/films/";

 let ch;

 function getFilmInfo(){
    //Clear the list of information
    let node = document.getElementById("charList");
    while(node.firstChild){
        node.removeChild(node.firstChild);
    }

    let film = document.getElementById("filmName").value;
    let id = getFilmID(film).toString();

    ajaxGet(swapiUrl+id+"/",displayCharacters);

 }

 function getFilmID(name){
    let filmTitle = ["A New Hope","Attack of the Clones", "The Phantom Menace", "Revenge of the Sith", "Return of the Jedi", "The Empire Strikes Back", "The Force Awakens"]
    return filmTitle.indexOf(name) + 1;
 }


 function ajaxGet(url, callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET",url);

    xhr.onreadystatechange = function(){

        if(this.readyState===4 && this.status===200){

            let returnedObject = JSON.parse(this.response);
            callback(returnedObject);

        } 
    }

    xhr.send();

 }

 function displayCharacters(movie){
    let chars = movie.characters;
    for(let i of chars){
        ajaxGet(i, getCharacterName)
    }

 }


 function getCharacterName(character){
    let entry = document.createElement("li");
    entry.innerHTML = character.name;
    document.getElementById("charList").appendChild(entry);
 }