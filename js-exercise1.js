// 1 Longest String
let maxLength = function(array) {
    let length = 0;
    let iHold;
    for(i in array) {
        if(array[i].length > length) {
            length = array[i].length;
            iHold = array[i];
        }
    }
    return iHold;
};

// 2 Reverse Array
let reverseArray = function(array) {
    let reverse = [];
    let j = 0;
    for(let i = array.length-1; i >= 0; i--) {
        reverse[j] = array[i];
        j++;
    }
    return reverse;
};

// 3 Count Vowels
let vowelCount = function(string) {
    let count = 0;
    for(i in string) {
        if(string[i] === "a" || string[i] === "e" || string[i] === "i" || string[i] === "o" || string[i] === "u" || string[i] === "A" || string[i] === "E" || string[i] === "I" || string[i] === "O" || string[i] === "U") {
            count++;
        }
    }
    return count;
};

// 4 Find Leap Year
let isLeapYear = function(date) {
    if (date.getYear() % 4 === 0) {
        return true;
    }
    return false;
};

// 5 Email Validation
let isValidEmail = function(string) {
    let hasAt = false;
    let hasDot = false;
    for(i in string) {
        if(string[i] === "@") {
            hasAt = true;
        }
        if(hasAt && string[i] === ".") {
            hasDot = true;
        }
    }
    if(hasAt && hasDot) {
        return true;
    }
    return false;
};

// 6 Remove Character
let removeChar = function(string, index) {
    let holdStr = "";
    for(i in string) {
        if(i != index) {
            holdStr = holdStr + string[i];
        }
    }
    return holdStr;
};

// 7 Bubble Sort
let bubbleSort = function(numArray) {
    let length = numArray.length;
    while(length > 0) {
        for(let i = 0; i < length; i++) {
            if(i + 1 !== length) {
                if(numArray[i] > numArray[i+1]) {
                    let hold = numArray[i];
                    numArray[i] = numArray[i+1];
                    numArray[i+1] = hold;
                }
            }
        }
        length--;
    }
    return numArray;
};

// 8 Even Number
let isEven = function(someNum) {
    //no modulus
    if(Number.isInteger(someNum/2)) {
        return true;
    }
    return false;
};

// 9 Palindrome
let isPalindrome = function(someStr) {
    let holdStr = "";
    for(let i = someStr.length-1; i >= 0; i--) {
        holdStr = holdStr + someStr[i];
    }
    if(holdStr === someStr) {
        return true;
    }
    return false;
};

// CHALENGE QUESTIONS
