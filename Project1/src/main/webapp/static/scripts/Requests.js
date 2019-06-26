/**
 * 
 */
let token = sessionStorage.getItem("token");
if(!token){
	window.location.href = "http://localhost:8080/Project1/login";
}