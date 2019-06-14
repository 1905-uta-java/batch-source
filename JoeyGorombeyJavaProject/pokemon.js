// add event listener
document.getElementById("submitButton").addEventListener("click", searchPokemon);
let baseURL = "https://pokeapi.co/api/v2/pokemon/";


//
function searchPokemon()
{
    // GET INPUT
    let PokemonInput = document.getElementById("PokemonInput").value;
    // GET REQUEST
    sendGetRequest(baseURL + PokemonInput, display);
    console.log(baseURL + PokemonInput);
}

function sendGetRequest(URL, display)
{
    let XHR = new XMLHttpRequest();

    // Open request for creation
    XHR.open("GET", URL);

    XHR.onreadystatechange = function()
    {
        if (this.readyState == 4 && this.status == 200)
        {
            let returnedObject = JSON.parse(this.response);
            display(returnedObject);
        }
        else if (this.readyState == 4)
        {
            document.getElementById("Name").innerHTML = "ERROR HAS OCCURRED " + this.response;
            document.getElementById("Height").innerHTML = "";
            document.getElementById("Base Experience").innerHTML = "";
        }
        
    }

    XHR.send();
}

function display(returnedObject)
{
    document.getElementById("Name").innerHTML = "Pokemon name: " + returnedObject.name;
    document.getElementById("Height").innerHTML = "Approximate height: " + returnedObject.height;
    document.getElementById("Base Experience").innerHTML = "Base experience level: " + returnedObject.base_experience;
}




