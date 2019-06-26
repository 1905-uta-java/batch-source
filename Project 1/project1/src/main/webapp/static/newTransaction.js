document.getElementById("addTransaction").addEventListener("click", callaback);

function callaback(){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/addTransaction");
	let amount = document.getElementById("amount").value;
	let log = document.getElementById("reason").value;
	let body = "empty";
	let id = JSON.parse(sessionStorage.getItem("token"));

	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			console.log("4");
			document.getElementById("amount").style.border = " 3px solid green"; 
			document.getElementById("reason").style.border = " 3px solid green"; 
		}
		else{
			document.getElementById("amount").style.border = " 5px solid green"; 
			document.getElementById("value").style.border = " 5px solid green"; 
		}
	}
	body = "amount="+amount+"&log="+log+"&id="+id.id;
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	console.log(body);
	xhr.send(body);
}