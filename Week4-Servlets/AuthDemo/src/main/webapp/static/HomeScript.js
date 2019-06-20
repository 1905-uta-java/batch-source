/**
 * 
 */

console.log("home script")

let token = sessionStorage.getItem("token");
if(!token){
	window.location.href = "http://localhost:8080/AuthDemo/login";
}