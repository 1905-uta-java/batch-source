//Ex. 1
function maxLength(...strArr){
   let curMax = strArr[0];
    for(x = 0; x < strArr.length; x++){
        if(curMax.toString.length < strArr[x].length){
            curMax = strArr[x];
        }
    }

    return curMax;
}

//Ex. 2
function reverseArray(...arr){
    let reversedArr = [];
    for(x = arr.length-1; x >= 0; x--){
        reversedArr.push(arr[x]);
    }
    return reversedArr;
}

//Ex. 3
function vowelCount(query = " "){
    let vowels = "";
    vowels = vowels.concat(query.replace(/[^aeiou]/ig, ""));
    return vowels.length;
}

//Ex. 4
function isALeapYear(year){

    if(year % 100 === 0 && year % 400 === 0){
        return true;
    } else {
        if(year % 100 !== 0 && year % 4 === 0)
            return true;
    }

    return false;
}

//Ex. 5
function isValidEmail(email = " "){
    if(email.match(/\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b/ig))
        return true;

    return false;
}

//Ex. 6
function removeChar(string = " ", index) {
    let remove = string.indexOf(index);
    return string.replace(remove, "");
    
}

//Ex. 7
function bubbleSort(...args){
    let newArray = args;
    
    for(x = 0; x < newArray.length; x++){
        for(y = 0; y < newArray.length; y++){
            if(newArray[x] < newArray[y]){
                let temp = newArray[x];
                newArray[x] = newArray[y];
                newArray[y] = temp;
            }
        }
    }
    return newArray;
}

//Ex. 8
function isEven(number){
    let num = parseFloat(number / 2);
    let intChecker = (number/2);

   if (parseInt(intChecker) == num)
        return true;

    return false;
}

//Ex. 9
function isPalindrome(string = " "){
    let original = string;
    let palindrome = "";

    for(x = original.length - 1; x >= 0; x--){
        palindrome += original.charAt(x);
        }

    
    console.log(palindrome);
    if(original == palindrome)
        return true;

    return false;
}

