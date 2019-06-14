// Upload a file named “js-exercise1.js” to your branch by Monday with the following function declarations:

// /////////////////// required 
// 1.      Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.
let myArray = ["pigeons", "squirrels", "mice"] ;
function maxLength(anArray){
// get length of chars from each string
  let lengthOfLongestWord = 0;
  let longestWord = ""; 
  for (i=0;i<anArray.length;i++){
    if(anArray[i].length > lengthOfLongestWord) {
      lengthOfLongestWord = anArray[i].length;
      longest = anArray[i];
    }
  }
  return lengthOfLongestWord;
}

// maxLength(myArray);
  
// 2.      Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.
let myArray = ["pigeons", "squirrels", "mice"] ;
function reverseArray(anArray){
  let arrayReversed = [];
    for (i=(anArray.length-1);i!=-1;i--){
      arrayReversed.push(anArray[i]);
    }
    return arrayReversed;
}

// reverseArray(myArray);

// 3.     Count Vowels 
// 	Define function: vowelCount(string)
// 	 Write a JavaScript function to count the number of vowels in a given string.
let myArray = "Alligators";
function vowelCount(aString){
  let vowelsFound = aString.match(/[aeiou]/g);
  vowelsFound === null ? 0 : vowelsFound.length;
  return vowelsFound;
}

// vowelCount(myArray);

// 4.      Find Leap Year
// Define function: isLeapYear(date)
// Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
function isLeapYear(year){
  return year % 100 === 0 ? year % 400 === 0 : year % 4 === 0;
}

// isLeapYear(2016);
// isLeapYear(2000);
// isLeapYear(2032);
// isLeapYear(2048);

// 5.      Email Validation 
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.
function isValidEmail(emailToCheck){
  let validEmailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  return emailToCheck.match(validEmailFormat) ? true : false; 
}

// isValidEmail("tinyTina@gmail.com");
// isValidEmail("tinyTim@aol.com");

// 6.     Remove Character
// 	Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
function removeChar(aString, anIndex) {
  let firstChunkMinusALetter = aString.substring(0, anIndex);
  let lastChunk = aString.substring(anIndex + 1, aString.length);
  return (firstChunkMinusALetter + lastChunk);
}
// removeChar("Arlington",5)

// 7.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. You may need to look up the algorithm if you’re not familiar with it
// Return the sorted array.
function bubble_Sort(anArrayOfNumbers){
  let flip;
  let amountOfNumbersToCheck = anArrayOfNumbers.length-1;
  let eventualSortedArray = anArrayOfNumbers;
  do {
      flip = false;
      for (let i = 0; i < amountOfNumbersToCheck; i++){
          if (eventualSortedArray[i] < eventualSortedArray[i+1]){
             let tempToFlipOn = eventualSortedArray[i];
             eventualSortedArray[i] = eventualSortedArray[i+1];
             eventualSortedArray[i+1] = tempToFlipOn;
             flip = true;
          }
      }
      // decrement
      amountOfNumbersToCheck--;
  } while (flip);
  return eventualSortedArray; 
}

// bubble_Sort([121, 90, 777, 1010, 2022]);


// 8.    Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum){ 
  return !(someNum & 1); 
};

// isEven(7);
// isEven(6);
// isEven(728);
  
// 9.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.
function isPalindrome(someStr){
  var cleanedString = someStr.toLowerCase().replace(/[^a-zA-Z0-9]+/g,'');
	var letterCount = 0;
	if(cleanedString === ""){
		return false;
	}
	if((cleanedString.length) % 2 === 0) {
		letterCount = (cleanedString.length) / 2;
	}else{
		if(cleanedString.length === 1){
			return true;
		}else{
			letterCount = (cleanedString.length - 1) / 2;
		}
	}
	for(var x = 0; x < letterCount; x++){
    // lose the unmatching characters
		if(cleanedString[x] != cleanedString.slice(-1-x)[0]){
			return false;
		}
	}
	return true;
}

// isPalindrome("raceCars");
//isPalindrome("raceCar");
// isPalindrome("Arlington")

// ////////////// challenge questions
  
// 10.   Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape.
// Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$

// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *																
// 11.   Rotate Left
// Define function: rotate(array, n)
// Given array, rotate left n times and return array
// Examples
// f([1,2,3,4,5], 1) = [2,3,4,5,1]
// f([1,2,3,4,5], 6) = [2,3,4,5,1]
// f([1,2,3,4,5], 3) = [4,5,1,2,3]

// 12.   Balanced Brackets
//  	Define function: balanced(string)

// A bracket is any one of the following: (, ), {, }, [, or ]
  
// The following are balanced brackets:
// ()
// ()()
// (())
// ({[]})
  
// The following are NOT balanced brackets
// (
// )
// (()i
// ([)]
  
// Create a function which takes a string of brackets and returns true if balanced and false if not balanced
function balanced(string){
  let stack = [];
  let map = {
      '(': ')',
      '[': ']',
      '{': '}'
  }
  for (let i = 0; i < string.length; i++) {
      if (string[i] === '(' || string[i] === '{' || string[i] === '[' ) {
          stack.push(string[i]);
      }
      else {
          let last = stack.pop();
          if (string[i] !== map[last]) {return false};
      }
  }
      if (stack.length !== 0) {return false};
  return true;
}
// balanced("({[]})");
// balanced("(())");
// balanced("()()");
// balanced("()");
// balanced("(");
// balanced(")");
// balanced("(()i");
// balanced("([)]");