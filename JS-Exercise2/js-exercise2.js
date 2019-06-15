


// 2. Disable Pluto Option
function disablePluto() {
    document.getElementById("planet").options[2].disabled = true;
}
disablePluto();

// 3. Show hidden text
function show() {
    x = document.getElementsByTagName('p');
    if(document.getElementById("planet").options[1].selected == true) {
        for (i = 0; i < x.length; i++) {
            if (x[i].hidden == true) {
                x[i].hidden = false;
            }
        }
    }
}
show();