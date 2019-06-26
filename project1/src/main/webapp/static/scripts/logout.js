/**
 * 
 */

document.getElementById("logout_btn").addEventListener("click", logout);


function logout(){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/logout';
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("Logging out...");
			sessionStorage.removeItem("token");
			window.location.href='http://localhost:8080/'; 
		}
	}
	xhr.send();
}