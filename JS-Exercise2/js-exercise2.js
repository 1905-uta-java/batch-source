// 1. Make each link direct the user to its respective website (see id)
function redirect() {
    document.getElementsByName("google")[0].href = "http://www.google.com";
    document.getElementsByName("twitter")[0].href = "http://www.twitter.com";
    document.getElementsByName("slack")[0].href = "http://www.slack.com";
    document.getElementsByName("javadocs")[0].href = "http://www.javadocs.com";
}
redirect();

// 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
function disablePluto() {
    document.getElementById("planet").options[2].disabled = true;
}
disablePluto();

// 3. Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.
function showHidden() {
    document.getElementById("planet").options[1].onclick = function fun() {
        x = document.getElementsByTagName('p');
        for (i = 0; i < x.length; i++) {
            if (x[i].hidden == true) {
                x[i].hidden = false;
            } else {
                x[i].hidden = true;
            }
        }
    }
}
showHidden();

// 4. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.
function calculate() {
    let x = document.getElementById("n1");
    let y = document.getElementById("n2");
    let z = document.getElementById("operation");
    let regex = /^[0-9]+$/;

    x.addEventListener("input", function () {
        if (x.value.match(regex) && y.value.match(regex)) {
            switchOperation(z.value);
        }
    });

    y.addEventListener("input", function () {
        if (x.value.match(regex) && y.value.match(regex)) {
            switchOperation(z.value);
        }
    });
      
    z.addEventListener("click", function() {
        if (x.value.match(regex) && y.value.match(regex)) {
            let choice = z[z.selectedIndex].value;
            switchOperation(choice);
        }
    });

    function switchOperation(value) {
        switch (value) {
            case "Add":
                document.getElementById("result").innerHTML = x.value + y.value;
                break;
            case "Subtract":
                document.getElementById("result").innerHTML = x.value - y.value;
                break;
            case "Divide":
                document.getElementById("result").innerHTML = x.value / y.value;
                break;
            case "Multiply":
                document.getElementById("result").innerHTML = x.value * y.value;
                break;
        }
    }
}
calculate();

// 5. Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.
function openDetails() {
    let details = document.getElementsByTagName("details")[0];
    details.onmouseover = function() {
        details.open = true;
    }
    details.onmouseleave = function() {
        details.open = false;
    }
}
openDetails();

// 6. Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
function concateInnerHTML() {
    let x = document.getElementsByTagName("span");
    let text = "";
    for(i = 1; i < x.length; i++) {
        text += x[i].innerHTML;
    }
    console.log(text);
}
concateInnerHTML();


// 7. Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked. 
function showTime() {
    let x = document.getElementById("earth_time");
    let y = document.createElement("span");
    var d = new Date();
    var n = d.toLocaleTimeString();
    y.appendChild(document.createTextNode(n));
    document.getElementById("earth_time_check").onclick = function() {
        x.append(y);
    }
}
showTime();