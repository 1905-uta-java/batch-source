//1-7////

document.getElementsByName("google").item(0).setAttribute("href", "http://www.google.com");
document.getElementsByName("twitter").item(0).setAttribute("href", "http://www.twitter.com");
document.getElementsByName("slack").item(0).setAttribute("href", "http://www.slack.com");
document.getElementsByName("javadocs").item(0).setAttribute("href", "https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html");

var planets = document.getElementById("planet");
planets.remove(2);

function ayyMsg()
{
    window.alert("ayylmao");
}
planets.addEventListener("change", ayyMsg);

function numChange()
{
    let numRegex = /\d*[.]{0,1}\d+/
    let result;
    if(numRegex.exec(document.getElementById("n1").value) && numRegex.exec(document.getElementById("n2").value))
    {
        if(document.getElementById("operation").value == "Add")
        {
            result = Number(document.getElementById("n1").value) + Number(document.getElementById("n2").value);
            document.getElementById("result").innerHTML = result.toString();
        }
        else if(document.getElementById("operation").value == "Subtract")
        {
            result = document.getElementById("n1").value - document.getElementById("n2").value;
            document.getElementById("result").innerHTML = result.toString();
        }
        else if(document.getElementById("operation").value == "Divide")
        {
            result = document.getElementById("n1").value / document.getElementById("n2").value;
            document.getElementById("result").innerHTML = result.toString();
        }
        else if(document.getElementById("operation").value == "Multiply")
        {
            result = document.getElementById("n1").value * document.getElementById("n2").value;
            document.getElementById("result").innerHTML = result.toString();
        }
    }
}
document.getElementById("n1").addEventListener("change", numChange);
document.getElementById("n2").addEventListener("change", numChange);
document.getElementById("operation").addEventListener("change", numChange);

function openDetails()
{
    document.getElementsByTagName("details").item(0).open = true;
}
function closeDetails()
{
    document.getElementsByTagName("details").item(0).open = false;
}
document.getElementsByTagName("summary").item(0).addEventListener("mouseout", closeDetails);
document.getElementsByTagName("summary").item(0).addEventListener("mouseover", openDetails)

function combineSpan()
{
    let spanset = document.getElementsByTagName("span");
    let total = "";
    for (iter = 0; iter < spanset.length; iter++)
    {
        total = total + spanset.item(iter).innerHTML;
    }
    console.log(total);
}
combineSpan();

function earthTime()
{
    document.getElementById("earth_time").innerHTML = new Date().toUTCString();
}
document.getElementById("earth_time_check").addEventListener("click", earthTime);

//8///////

//9///////
function changeColor()
{
    let rng = "#" + Math.floor((Math.random()* 0x888888 + 0x777777)).toString(16);
    function clrChngSect()
    {
        document.body.style.backgroundColor = rng;
    }
    setTimeout(clrChngSect, 3000);
}
document.getElementsByTagName("h1").item(0).addEventListener("click", changeColor);

//10//////
function isValidEmail(string)
{
    emailRE = /[.\w]@[\w]+[.][\w]+/;
    return emailRE.test(string) ;
}
function isValidPhone(string)
{
    var clean = (""+string).replace(/\D/g,'');
    var phoneRE = /\d{10}$/;
    return phoneRE.test(clean);
}

function addTableData()
{
    let fname = document.getElementById("firstname").value;
    let lname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;
    let planet = document.getElementById("planet").value;
    let genderVals = document.getElementsByName("gender");
    let gender = null;
    for (iter = 0; iter < genderVals.length; iter++)
    {
        if (genderVals.item(iter).checked == true) gender = genderVals.item(iter).value;
    }
    let color = document.getElementById("color").value;
    let activities = document.getElementsByClassName("activity");

    if (fname.length >= 2 && lname.length >= 2 && email && isValidEmail(email) && phone && isValidPhone(phone) && bday && planet && gender && color)
    {
        let row = document.createElement("tr");
        let cell0 = document.createElement("td"); //fname+lname
        let cell1 = document.createElement("td"); //email
        let cell2 = document.createElement("td"); //phone
        let cell3 = document.createElement("td"); //bday
        let cell4 = document.createElement("td"); //color
        let cell5 = document.createElement("td"); //gender
        let cell6 = document.createElement("td"); //activities

        cell0.innerHTML = fname;
        if (lname) cell0.innerHTML += " " + lname;
        cell1.innerHTML = email;
        cell2.innerHTML = (phone).replace(/\D/g,'');
        cell3.innerHTML = bday;
        cell4.innerHTML = color.toString();
        cell5.innerHTML = gender;
        ulc6 = document.createElement("ul");
        
        let li_ulc6;
        for (iter = 0; iter < activities.length; iter ++)
        {
            if (activities.item(iter).checked == true) 
            {
                li_ulc6 = document.createElement("li");
                val = activities.item(iter).value;
                
                if (val == "stamp") li_ulc6.innerHTML = "stamp collecting";
                else if (val == "basket") li_ulc6.innerHTML = "underwater basket weaving";
                else li_ulc6.innerHTML = val;
                console.log(activities.item(iter).textContent);
                ulc6.appendChild(li_ulc6);
            }
        }

        cell6.appendChild(ulc6);
        row.appendChild(cell0);
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        row.appendChild(cell5);
        row.appendChild(cell6);

        
        document.getElementsByClassName("table").item(0).appendChild(row);
    }
}
document.getElementById("form-sub").addEventListener("click", addTableData);
