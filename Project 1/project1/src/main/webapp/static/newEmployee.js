getElementById("form").addEventListener('click', addEmployee);

function addEmployee(){
	let fn = document.getElementById();
	let ln = document.getElementById();
	let un = document.getElementById();
	let pass = document.getElementById();
	let email = document.getElementById();
	let fn = document.getElementById();
	
    let requestBody = "firstname="+fn+"&lastname="+ln+"&username="+user+"&password="+pass;

	
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost/createEmployee");
	xhr.onreadystatechange = function(){
		if(this.readystate === 4 && this.status === 200){
			console.log("newEmployee readystate")
		}
		else {
			document.write("ERRORR ERRORR")
		}
	}
	xhr.send(requestBody);
	
	
	
	
}