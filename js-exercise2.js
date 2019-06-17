//function init() {
    // 1.
    let google = document.getElementById("google");
    let twitter = document.getElementById("twitter");
    let slack = document.getElementById("slack");
    let javadocs = document.getElementById("javadocs");
    
    google.addEventListener("click", function() {
        window.location.replace("https://www.google.com");
    });
    twitter.addEventListener("click", function() {
        window.location.replace("https://twitter.com/");
    });
    slack.addEventListener("click", function() {
        window.location.replace("https://slack.com/");
    });
    javadocs.addEventListener("click", function() {
        window.location.replace("https://docs.oracle.com/javase/7/docs/api/");
    });

    // 2.
    function removePluto() {
        let planets = document.getElementById("planet").childNodes;
        for(let i = 0; i < planets.length; i++) {
            if(planets.item(i).innerHTML === "Pluto") {
                document.getElementById("planet").removeChild(planets.item(i));
            }
        }
    };
    removePluto();

    // 3.
    function alienText() {
        let findMsg = document.getElementsByTagName("p");
        for(let i = 0; i < findMsg.length; i++) {
            if(findMsg.item(i).innerHTML === "Beep boop") {
                findMsg.item(i).style.visibility = "visible";
            }
        }
    };
    document.getElementById("planet").addEventListener("change", function() {
        let planet = document.getElementById("planet");
        if(planet.selectedIndex !== 0) {
            alienText();
        }
    });

    // 4.
    document.getElementById("n1").addEventListener("change", function() {
        let operator1 = document.getElementById("n1");
        if(!isNaN(operator1.value)) {
            document.getElementById("n2").addEventListener("change", function() {
                let operator2 = document.getElementById("n2");
                if(!isNaN(operator2.value)) {
                    let operation = document.getElementById("operation");
                    let result = document.getElementById("result");
                    let n1 = Number(operator1.value);
                    let n2 = Number(operator2.value);
                    if(operation.selectedIndex === 0) {
                        result.innerHTML = n1 + n2;
                    } else if(operation.selectedIndex === 1) {
                        result.innerHTML = n1 - n2;
                    } else if(operation.selectedIndex === 2 && n2 !== 0) {
                        result.innerHTML = n1 / n2;
                    } else if(operation.selectedIndex === 3) {
                        result.innerHTML = n1 * n2;
                    }
                }
            });
        }
    });

    // 5.
    let details = document.getElementsByTagName("details");
    function openDetails() {
        for(let i = 0; i < details.length; i++) {
            details.item(i).addEventListener("mouseover", function() {
                details.item(i).open = true;
            });
            details.item(i).addEventListener("mouseout", function() {
                details.item(i).open = false;
            });
        }
    }
    openDetails();

    // 6.
    function concatSpans() {
        let spans = document.getElementsByTagName("span");
        let result = "";
        for(let i = 0; i < spans.length; i++) {
            result += spans.item(i).innerHTML;
        }
        console.log(result);
    };
    concatSpans();

    // 7.
    function earthTime() {
        document.getElementById("earth_time").innerHTML = new Date().getTime();
    };
    document.getElementById("earth_time_check").addEventListener("click", earthTime());
//}

//window.onload = init;