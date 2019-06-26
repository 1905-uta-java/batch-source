//verify the token
if(!sessionStorage.getItem(`token`)){
    window.location.href = "http://localhost:8080/ERS_System/login";
}