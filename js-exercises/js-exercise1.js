
// 1. Longest String Function
let maxLength = function(array){
    let maxString;
    let maxStringIndex;
    let stringLengths = [];
        for (i of array){
            stringLengths.push(i.length);
            maxString = Math.max(...stringLengths);
            if (i.length == maxString){
            maxStringIndex = array.indexOf(i)
            }
        }
    return maxStringIndex;
}


// 2. Reverse Array Function
let reverseArray = function(array){
    let emptyArray = [];
    for (i = array.length - 1; i >= 0; i--){
        emptyArray.push(array[i]);
    }
    return emptyArray;
}

// 3. Count Vowels
let vowelCount = function(stringInput){
    let myVowels = "aeiou";
    let counter = 0;

    for (i = 0; i < stringInput.length; i++) {
        for (j = 0; j < stringInput.length; j++) {
            if (stringInput.charAt(i) == myVowels.charAt(j)){
                counter++;
            }
        }
    }
    return counter;
}

// 4. Find Leap Year
function isLeap(year) {
    return new Date(year, 1, 29).getDate() === 29;
}

// 5. Email Validation
function isValidEmail(emailString) {
    let isValid = false;
    for (i = 0; i < emailString.length; i++){
        if (emailString.charAt(i) == '@'){
            isValid = true;
        }
    }
    return isValid;
}

// 6. Remove Character
function removeChar(string, index){
    cutString = string.slice(0, index);
    cutString2 = string.slice(index+1, string.length);
    return cutString + cutString2;
}

// 7. Bubble Sort
function swap(array, i, j)
{
    temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function bubbleSort(numArray) {
    for (i = 0; i < numArray.length; i++){
        for (j = 1; j < numArray.length; j++){
            if (numArray[j-1] > numArray[j]) {
                swap(numArray, j-1, j);
            }
        }
    }
    return numArray;
}

// 8. Even Number
function isEven(someNum) {
    evenArray = [0,2,4,6,8];
    sNum = someNum.toString();
    numArray = [];
    iseven = false;
    for (i = 0; i < sNum.length; i++){
        numArray.push(sNum.charAt(i));
    }
    for (j = 0; j < evenArray.length; j++){
        if (numArray[sNum.length-1] == evenArray[j]){
            iseven = true;
        }
    }
    return iseven;
}

// 9. Palindrome
function isPalindrome(someString){
    isPal = false;
    result = "";
    for (i = someString.length - 1; i >= 0; i --) {
        result = result + someString.charAt(i);
    }

    if (someString == result) {
        isPal = true;
    }
    return isPal;
}