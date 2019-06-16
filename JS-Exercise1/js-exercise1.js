// 1. maxLength(array)
function maxLength(array) {
    let max = 0;
    let index;
    for (i in array) {
        if (array[i].length > max) {
            max = array[i].length;
            index = i;
        }
    }
    return index;
}
console.log("1. maxLength(array)");
console.log(maxLength(["a", "ab", "abc"]));
console.log(maxLength(["a", "abcdef", "abc", "abcd"]));

// 2. Reverse Array
function reverse(array) {
    return array.reverse();
}
console.log("2. Reverse Array");
console.log(reverse([1, 2, 3]));

// 3. Count Vowel
function vowelCount(str) {
    let count = str.match(/[aeiou+]/gi);
    return count === null ? 0 : count.length;
}
console.log("3. Count Vowel");
console.log(vowelCount("Hello World"));
console.log(vowelCount("A eo u i"));
console.log(vowelCount(" "));

// 4. isLeapYear(date)
function isLeapYear(date) {
    return (date % 100 === 0) ? (date % 400 === 0) : (date % 4 === 0);
}
console.log("4. isLeapYear(date)");
console.log(isLeapYear(2016));
console.log(isLeapYear(1989));

// 5. isValidEmail(string)
function isValidEmail(str) {
    let regex = "/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/";
    if(str.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/))
        return true;
    return false;
}
console.log("5. isValidEmail");
console.log(isValidEmail("abc@gmail.com"));
console.log(isValidEmail(".abc@gmail.com"));
console.log(isValidEmail("a..bc@gmail.com"));
console.log(isValidEmail("a.bc@gmail.com."));
console.log(isValidEmail("abc@@gmail.com"));
console.log(isValidEmail("@abc@gmail.com"));
console.log(isValidEmail("abc@gmail.com@"));

// 6. removeChar(string, index)
function removeChar(str, index) {
    if(index == 0)
        return str.substring(1,str.length);
    else if(index == str.length-1)
        return str.substring(0, str.length-1);
    return str.slice(0,index) + str.slice(index+1, str.length);
}
console.log("6. removeChar(string, index)");
console.log(removeChar("0123456789", 0));
console.log(removeChar("0123456789", 9));
console.log(removeChar("0123456789", 4));

// 7. bubbleSort(numArray)
function bubbleSort(numArray) {
    let tmp = 0;
    let flag;
    do {
        flag = false;
        for(let i = 0; i < numArray.length - 1; i++) {
            if(numArray[i] > numArray[i+1]) {
                tmp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = tmp;
                flag = true;
            }
        }
    } while(flag)
    return numArray;
}
console.log("7. bubbleSort(numArray)");
console.log(bubbleSort([3,2,5,6,4,1]));
console.log(bubbleSort([9,8,7,6,5,4,3,2,1]));
console.log(bubbleSort([1,2,3,4,5,6,7,8,9]));

// 8. Even Number
function isEven(num) {
    let n = num / 2;
    return parseInt(n) == n;
}
console.log("8. Even Number");
console.log(isEven(8));
console.log(isEven(10));
console.log(isEven(3.5));
console.log(isEven(19))
console.log(isEven(20));

// 9.   Palindrome
function isPalindrome(str) {
    let revertStr = "";
    for(let i = str.length -1; i>=0; i--) {
        revertStr += str[i];
    }
    return str == revertStr;
}
console.log("9. isPalindrome");
console.log(isPalindrome("abba"));
console.log(isPalindrome("haah"));
console.log(isPalindrome("haha"));

// 10.   Shapes
console.log("10. Shapes")

function printShape(shape, height, character) {
    let c = character;
    let h = height;
    // function newLine(c) {
    //     return console.log(c);
    // }

    if (height == 1)
        console.log(character);

    switch (shape) {
        case "Square":
            for (i = 1; i <= height; i++) {
                console.log(printSquare_Triangle(height, character, c));
            }
            break;

        case "Triangle":
            for (i = 1; i <= height; i++) {
                console.log(printSquare_Triangle(i, character, c));
            }
            break;

        // case "Diamond":
        //     for (i = 1; i <= height; i++) {
        //         console.log(printDiamond(i, character, c, h))
        //     }


    }
}
printShape("Square", 3, "$");
printShape("Triangle", 5, "$");

function printSquare_Triangle(height, character, c) {
    if(height == 1)
        return character;
    return printSquare_Triangle(height - 1, character += c, c);
}

// function printDiamond(height, character, c, h) {
//     if(height == 1)
//         return character;
    
//     return printDiamond(height - 1, character += )
// }

// 11.   Rotate Left
function rotate(array, n) {
    
}

// 12.   Balanced Brackets
function balanced(str) {
    let arr = str.split("");
    //console.log(arr);
    if(arr.length % 2 != 0)
        return false;
}
//balanced("{[]}");
