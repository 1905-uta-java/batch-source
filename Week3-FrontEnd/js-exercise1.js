// Upload a file named “js-exercise1.js” to your branch by Monday with the following function declarations:

// /////////////////// required 
// 1.      Longest String
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.

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
  let myArray = ["Squirrel","Wasp","Bee", "Elephant", "Alligators"];
  function vowelCount(anArray){
    let vowels = ["a","e","i","o","u"];
    for (i=0; i < myArray.length; i++){
      // store current word
      let currentWord = ;
    }
  }
  
  // returns an array of string
   function myFunction() {
      var str = "The rain in SPAIN stays mainly in the plain"; 
      var res = str.match(/in/g);
      return res;
    } 
  myFunction();
  
  // 4.      Find Leap Year
  // Define function: isLeapYear(date)
  // Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
   
  // 5.      Email Validation 
  // Define function: isValidEmail(string)
  // Create a function that checks for a valid email format.
   
  // 6.     Remove Character
  // 	Define function: removeChar(string, index)
  // Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
  
  // 7.       Bubble Sort
  // Define function: bubbleSort(numArray)
  // Use the bubble sort algorithm to sort the array. You may need to look up the algorithm if you’re not familiar with it
  // Return the sorted array.
  
  // 8.    Even Number
  // Define function: isEven(someNum)
  // Return true if even, false if odd.
  // Do not use % operator.
   
  // 9.   Palindrome
  // Define function: isPalindrome(someStr)
  // Return true if someStr is a palindrome, otherwise return false.
  
  
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
   
  
  
  