let maxLenght = function(array){
    let max = array[0].length;
    for(let i = 0; i < array.length; i+= 1){
        if(array[i].length > max){
            max = array[i].length;
        }
    }
    return max
    
}


let reverseArray = function(array){
    let reverseTheArray = [];
    for(let i = 0; i < array.length; i++){
        reverseTheArray[i] = array[array.length - i - 1];
    }
    return reverseTheArray;
}

let vowelCount = function(str){
    let counter = 0;
    for(let i = 0; i < str.length; i++){
        if(str.charAt(i) === 'a' || str.charAt(i) === 'A' || 
        str.charAt(i) === 'e' || str.charAt(i) === 'E' || 
        str.charAt(i) === 'i' || str.charAt(i) === 'I' || 
        str.charAt(i) === 'o' || str.charAt(i) === 'O' || 
        str.charAt(i) === 'u' || str.charAt(i) === 'U') {
            counter++;
        }
    }
    return counter;
}

let isLeapYear = function(date){
    let currDate = new Date(date);
    if(currDate % 4 == 0){
        return true;
    }
    return false;
}

let isEmailValid = function(email){
    let at = 0;
    let dot = 0;
    for(let i = 0; i < email.length; i++){
        if(email.charAt(i) == "@"){
            at++;
        }
        if(email.charAt(i) == "."){
            dot++;
        }
    }
    if(dot == 1 & at == 1){
        return true;
    }
    return false;
}


let removeChar = function(str, index){
    charRemove = str.charAt(index);
    str = str.replace(charRemove, "");
    return str;
}

let bubbleSort = function(array) {
    var swapped;
    do {
        swapped = false;
        for (var i=0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                var temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
    return array;
}



let isEven = function(num){
    let test = num / 2;
    if(Number.isInteger(test)){
        return true;
    }
    return false;
    
}

let isPalindrome = function(str){
    let revStr = "";
    for(let i = 0; i < str.length; i++){
        revStr = revStr + str[str.length - i - 1];
    }
    if(revStr === str){
        return true;
    }
    return false;
}

let balancedb = function(str){
    let left = ["{", "[", "("];
    let right = ["}", "]", ")"];

    for(let i = 0; i < str.length; i++){
        for(let j = 0; j < right.length; j++){
            if(str[i] == left[j]){
                if(str[str.length - i - 1] == right[j]){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(str[i] == right[j]){
                if(str[str.length - i - 1] == left[j]){
                    return true;
                }
                else{
                    return false;
                }
            }

        }
    }
    return false;

    
    

}