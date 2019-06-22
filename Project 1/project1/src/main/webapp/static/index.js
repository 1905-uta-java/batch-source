function test(callback){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "localhost:8080/access");

    xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			callback(this);
		}
	}
xhr.send();
}

test();