//1
function maxLength(arr){
    if(Array.isArray(arr)==true){
        let longest=0;
        let max=0;
        for(let i = 0; i < arr.length ;i++){ 
            if(arr[i].length > longest){
                longest = arr[i].length;
                max=i;
            }
       
        }
        return max;
    }else 
    return "Not an array";
   
}

//2
function reverseArray(arr){
    if(Array.isArray(arr)==true){
        let newArr=[];
        for(let i = arr.length-1 ; i>=0 ; i--){
            newArr.push(arr[i]);
        }
        return newArr;
    }else 
    return "Not an array";
}

//3
function vowelCount(str){
    if(typeof str === 'string'){
        let res = str.match(/[aeiou]/gi)
        if(res== null){
            return 0;
        }else
        return res.length;
    }else
    return "Not an string";
}

//4
function isLeapYear(year){
    
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
        return true;
    }else
    return false;
}

//5
function isValidEmail(email){

   if(/\S+@\S+\.\S+/.test(email)){
       return true;
   }else 
        return false;
}

//6
function removeChar(string, index){
    if(typeof string === 'string'){

        if(index<string.length){
        return string.slice(0, index) + string.slice(index+1);
        }else 
        return "Invaild Index";
    }else 
        return "Not a String";

}

//7
function bubbleSort(numArray){
    let len = numArray.length;
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len; j++) {
            if (numArray[j] > numArray[j + 1]) {
                let tmp = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = tmp;
            }
        }
    }
    return numArray;
}

//8
function isEven(num){
    if(isNaN(num)){
        return "Not a Number"
    }else
        return /^-?\d*[02468]$/.test(num)
}

//9
function isPalindrome(string){
    if(typeof string === 'string'){
        string = string.toLowerCase();
        if(string == string.split('').reverse().join('')){
            return true;
        }else
            return false;
    }else "Not a String"

}
