/*
    JavaScript Function Exercise
*/

// Problem 1
//      returns the index of the longest string in the array
//      or -1 if arr is not an array or doesn't contain a string
function maxLength(arr) {
    
    let index = -1;
    let length = 0;

    if(!Array.isArray(arr))
        return -1;
    
    for(i in arr) {

        if(typeof(arr[i]) === 'string') {

            if(arr[i].length > length) {

                index = i;
                length = arr[i].length;
            }
        }
    }

    return index;
}

// Problem 2
//      if the passed in variable is an array, this method reverses the elements in the array
function reverseArray(arr) {

    if(!Array.isArray(arr))
        return;
    
    if(arr.length < 2)
        return;

    let placeholder;

    for(i = 0; i < (arr.length / 2); i++) {
        placeholder = arr[i];
        arr[i] = arr[(arr.length - 1) - i];
        arr[(arr.length - 1) - i] = placeholder;
    }
}

// Problem 3
//      counts the number of vowels in the input string
//      returns -1 for invalid input types
function vowelCount(inputString) {

    if(typeof(inputString) !== 'string')
        return -1;
    
    let count = 0;
    
    for(i = 0; i < inputString.length; i++) {
        if(isVowel(inputString.charAt(i)))
            count++;
    }
    
    return count;
}

function isVowel(char) {
    return char.toLowerCase() === 'a'
        || char.toLowerCase() === 'e'
        || char.toLowerCase() === 'i'
        || char.toLowerCase() === 'o'
        || char.toLowerCase() === 'u';
}

// Problem 4
    // returns true if the input value is a Date and it's year is a leap year and false otherwise   
function isLeapYear(date) {

    if(!(date instanceof Date))
        return false;
    
    let year = date.getFullYear();

    if(!(year % 4)) {

        if(!(year % 100)) {

            if(!(year % 400))
                return true;
            else
                return false

        } else {

            return true;
        }
    }
    
    return false;
}

// Problem 5
function isValidEmail(email) {

    if(typeof(email) !== 'string')
        return false;
    
    email = email.toLowerCase();

    result = email.match(`^[a-z0-9]+((\\-|\\.|_)?([a-z0-9]|\\d))*@[a-z0-9]+\\.[a-z0-9]+$`)

    return Boolean(result && result.indexOf(email) > -1);
}

// Problem 6
function removeChar(inputString, index) {
    
    if(typeof(inputString) !== 'string' || typeof(index) !== 'number')
        return inputString;
    
    return inputString.slice(0, index) + inputString.slice(index + 1);
}

// Problem 7
function bubbleSort(numArr) {
    if(!numArr || !Array.isArray(numArr))
        return numArr;
    
    copyArr = numArr.slice(0);
    for(e of copyArr) {
        if(typeof(e) !== 'number')
            return numArr;
    }
    
    let loopAgain = true;
    let tempVar;
    while(loopAgain) {

        loopAgain = false;

        for(i = 0; i < copyArr.length - 1; i++) {

            if(copyArr[i] > copyArr[i + 1]) {

                tempVar = copyArr[i];
                copyArr[i] = copyArr[i + 1];
                copyArr[i + 1] = tempVar;
                loopAgain = true;
            }
        }
    }

    return copyArr;
}

// Problem 8
function isEven(num) {
    if(typeof(num) !== 'number')
        return false;

    num = num / 2;
    return num === Math.round(num);
}

// Problem 9
function isPalindrome(input) {
    if(typeof(input) !== 'string')
        return false;
    
    input = input.replace(/\W/g, "");
    
    input = input.toLowerCase();

    for(i = 0; i < input.length / 2; i++) {
        if(input[i] !== input[input.length - 1 - i])
            return false;
    }

    return true;
}

// Tests
function test() {
    console.log("Running Tests");
    console.log("");

    console.log("Problem 1");
    console.log(`   maxLength(null) = ${maxLength(null)} (expect -1)`);
    console.log(`   maxLength(["hi", "hello"]) = ${maxLength(["hi", "hello"])} (expect 1)`);
    console.log(`   maxLength([0, null]) = ${maxLength([0, null])} (expect -1)`);
    console.log(`   maxLength([-1, undefined, "h"]) = ${maxLength([-1, undefined, "h"])} (expect 2)`);
    console.log("");

    console.log("Problem 2");
    let arr = null;
    reverseArray(arr);
    console.log(`   arr = null;
                    reverseArray(null);
                    arr = ${arr} (expect null)
                    `);
    arr = ["hi", "hello"];
    reverseArray(arr);
    console.log(`   arr = ["hi", "hello"];
                    reverseArray(arr);
                    arr = ${arr} (expect hello,hi)
                    `);
    arr = [0, null];
    reverseArray(arr);
    console.log(`   arr = [0, null];
                    reverseArray(arr);
                    arr = ${arr} (expect null,0)
                    `);
    arr = [-1, undefined, "h"];
    reverseArray(arr);
    console.log(`   arr = [-1,undefined,h];
                    reverseArray(arr);
                    arr = ${arr} (expect h,undefined,-1)
                    `);
    console.log("");

    console.log("Problem 3");
    console.log(`   vowelCount(null) = ${vowelCount(null)} (expect -1)`);
    console.log(`   vowelCount(0) = ${vowelCount(0)} (expect -1)`);
    console.log(`   vowelCount("Hello There") = ${vowelCount("Hello There")} (expect 4)`);
    console.log(`   vowelCount("Blah Blah Blah") = ${vowelCount("Blah Blah Blah")} (expect 3)`);
    console.log("");

    console.log("Problem 4");
    console.log(`   isLeapYear(null) = ${isLeapYear(null)} (expect false)`);
    console.log(`   isLeapYear("Hello") = ${isLeapYear("Hello")} (expect false)`);
    console.log(`   isLeapYear(new Date('December 17, 1995 03:24:00')) = ${isLeapYear(new Date('December 17, 1995 03:24:00'))} (expect false)`);
    console.log(`   isLeapYear(new Date('January 1, 2004 03:24:00')) = ${isLeapYear(new Date('January 1, 2004 03:24:00'))} (expect true)`);
    console.log(`   isLeapYear(new Date('December 25, 1000 03:24:00')) = ${isLeapYear(new Date('December 25, 1000 03:24:00'))} (expect false)`);
    console.log(`   isLeapYear(new Date('July 4, 2000 03:24:00')) = ${isLeapYear(new Date('July 4, 2000 03:24:00'))} (expect true)`);
    console.log("");

    console.log("Problem 5");
    console.log(`   isValidEmail(null) = ${isValidEmail(null)} (expect false)`);
    console.log(`   isValidEmail("Hello") = ${isValidEmail("Hello")} (expect false)`);
    console.log(`   isValidEmail("javeit1995@gmail.com") = ${isValidEmail("javeit1995@gmail.com")} (expect true)`);
    console.log(`   isValidEmail("javeit.1995@gmail.com") = ${isValidEmail("javeit.1995@gmail.com")} (expect true)`);
    console.log(`   isValidEmail("javeit..1995@gmail.com") = ${isValidEmail("javeit..1995@gmail.com")} (expect false)`);
    console.log(`   isValidEmail("j.v@g.c") = ${isValidEmail("j.v@g.c")} (expect true)`);
    console.log(`   isValidEmail("ja_.veit@gmail.com") = ${isValidEmail("ja_.veit@gmail.com")} (expect false)`);
    console.log("");

    console.log("Problem 6");
    console.log(`   removeChar("testString1", 3) = ${removeChar("testString1", 3)} (expect "tesString1")`);
    console.log(`   removeChar("test2", 6) = ${removeChar("test2", 6)} (expect "test2")`);
    console.log(`   removeChar(null, 1) = ${removeChar(null, 1)} (expect null)`);
    console.log(`   removeChar("test4", "hello") = ${removeChar("test4", "hello")} (expect "test4")`);
    console.log(`   removeChar("test5test_test", 9) = ${removeChar("test5test_test", 9)} (expect "test5testtest")`);
    console.log("");

    console.log("Problem 7");
    console.log(`   bubbleSort(null) = ${bubbleSort(null)} (expect null)`);
    console.log(`   bubbleSort([1, 4, 5, 3, 2]) = ${bubbleSort([1, 4, 5, 3, 2])} (expect 1,2,3,4,5)`);
    console.log(`   bubbleSort([1, 3, 4, 3, 4]) = ${bubbleSort([1, 3, 4, 3, 4])} (expect 1,3,3,4,4)`);
    console.log(`   bubbleSort([1, 2, 4, 3, "break"]) = ${bubbleSort([1, 2, 4, 3, "break"])} (expect 1,2,4,3,break)`);
    console.log(`   bubbleSort([20, 1, 100, 2, 4, 2019, 3, 17]) = ${bubbleSort([20, 1, 100, 2, 4, 2019, 3, 17])} (expect 1,2,3,4,17,20,100,2019)`);
    console.log("");

    console.log("Problem 8");
    console.log(`   isEven(2) = ${isEven(2)} (expect true)`);
    console.log(`   isEven(1) = ${isEven(1)} (expect false)`);
    console.log(`   isEven(2.1) = ${isEven(2.1)} (expect false)`);
    console.log(`   isEven(null) = ${isEven(null)} (expect false)`);
    console.log(`   isEven(20) = ${isEven(20)} (expect true)`);
    console.log("");

    console.log("Problem 9");
    console.log(`   isPalindrome(null) = ${isPalindrome(null)} (expect false)`);
    console.log(`   isPalindrome("race car") = ${isPalindrome("race car")} (expect true)`);
    console.log(`   isPalindrome("") = ${isPalindrome("")} (expect true)`);
    console.log(`   isPalindrome("Hi") = ${isPalindrome("Hi")} (expect false)`);
    console.log(`   isPalindrome("A man, a plan, a canal – Panama") = ${isPalindrome("A man, a plan, a canal – Panama")} (expect true)`);
    console.log(`   isPalindrome("Able was I ere I saw Elba") = ${isPalindrome("Able was I ere I saw Elba")} (expect true)`);
}