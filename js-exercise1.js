// 1. Longest String

function maxLength(array) {
    
    let maxString = array[0].length
    
    let maxIndex = 0;
    for(let i = 1; i < array.length; i++) {

        if (array[i].length > maxString){
            maxString = array[i].length;
            maxIndex = i;
        }

    }
    return maxIndex;
}

// 2. Reverse Array

function  reverseArray(array) {

    let reverseArr = [];
    let index = 0;

    for(let i = array.length -1; i >= 0 ; i--){

        reverseArr[index] = array[i];
        index++;

    }
    return reverseArr;
}

// 3, Count Voewls

function vowelCount(string) {
    let str = string;
    let  count = 0;

    for(let i = 0;i < str.length; i++ ) {
        if (str[i].toLowerCase() == 'a' || str[i].toLowerCase() == 'i' || str[i].toLowerCase() == 'o' ||str[i].toLowerCase() == 'e' ||str[i].toLowerCase() == 'u')
            count+=1;
    }
    return count;
}

// 4. Find Leap Year

function isLeapYear(date) {

    let x = date.getYear();

    if (x % 4 == 0) {
        return true;
    }
    return false;

}

// 5.  Email Validation 

function isValidEmail(string) {

    let x = 0;
    if(string.length <= 3) {

        return false;
    }
    while(x<string.length) {

        if(string[x] === "@") {
            return true;
        }
        x++;
    }
    return false;

}

// 6. Remove Character

function removeChar(string, index) {

    if (index==0) {
        return  string.slice(1)
    } else {
        return string.slice(0,index) + string.slice(index+1);
    } 
}

// 7. Bubble Sort




// 8. Even Number

function isEven(someNum) {
    
    // Return true if n/2 doesnt return a decimal
    if(Math.floor(someNum/2)*2==someNum) {
        return true;
    }
    return false;
}


// 9. Palindrome

function isPalindrome(someStr) {

    var st='';    
    st=someStr.replace(/[^a-z0-9]/ig,"").toLowerCase();    
    var arr = [];    
    arr = st.split('');    
    arr = arr.reverse();    
    var strr='';    
    strr = arr.join('');
    if(strr==st) {
        return true;
    }
 return false;
    
}

// 11.  Rotate Left

function rotate(array, n) {
    
    
    for (let i = 0; i < n; i++) {
        let sub = array[0];         // Store first element 
        array.shift();              // Remove first element
        array.push(sub);            // Plcae first element at end
    }
    return array;
}


