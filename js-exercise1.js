/*
 Longest String
Define function: maxLength(array)
Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.

*/


function maxLength(array)
{
    var maxLength = 0;
    let maxLengthIndex = 0;

    for (i in array)
    {
        var currentLen = array[i].length;
        //console.log(currentLen);
        if (currentLen > maxLength)
        {
            maxLength = currentLen;
            maxLengthIndex = i;
            console.log(maxLengthIndex + "is the index with the longest value!");
        }
      //  console.log("Max length so far: " + maxLength);
    }

    return maxLengthIndex;
}

//maxLength(array)


/*
2.      Reverse Array
Define function: reverseArray(array)
Write a JavaScript function to reverse the elements of a given array.
*/

function reverseArray(array)
{
    let reversedArray = array.reverse();
    return reverseArray;
}



/*
3.     Count Vowels 
	Define function: vowelCount(string)
	 Write a JavaScript function to count the number of vowels in a given string.
*/


function vowelCount(string)
{
    const vowels = ['a', 'e', 'i', 'o', 'u'];
    numVowels = 0;

    // for each letter in the string
    for (letter in string)
    {
        // print the current letter of the string
        let currentLetter = string[letter]
        console.log(currentLetter + " is the current letter!");

        // for every possible vowel,
        for (vowel in vowels)
        {
            // if the current letter of the string equals that vowel, iterate the count and move on
            if (currentLetter == vowels[vowel])
            {
                console.log(currentLetter + " is " + vowels[vowel] + " which is a vowel!");
                numVowels++
                console.log("Vowel count is up to: " + numVowels);
                break;
            }
        }
            
    }

    return numVowels;
}

/*
4.      Find Leap Year
Define function: isLeapYear(date)
Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
*/

let date = "1997";
function isLeapYear(date)
{
    let leapYear = false;
    let divisibleBy4 = false;
    let divisibleBy100 = false;

    if (date % 4 == 0)
    {
        console.log(`${date} is divisible by 4!`);
        divisibleBy4 = true;
        if (date % 100 == 0)
        {
            if (date % 400 == 0)
            {
                console.log(`${date} is divisible by 4 and 100, but also 400! It is a leap year`);
                return true;
            }
            else
            {
                console.log(`${date} is divisible by 4 and 400, but not 100! It is not a leap year`);
                return false;
            }
        }
        
        else
        {
            console.log(`${date} is divisible by 4, but not 100! It is a leap year!`)
            return true;
        }
    }
    else
    {
        console.log(`${date} is not even divisible by 4!`);
        return false;
    }
}


// 5. Email Validation 	
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.

function isValidEmail(string)
{
    let atSymbolPresent = false;
    let atSymbolPosition = -1;
    let dotPresent = false;
    let validEmail = false;

    // test for @ symbol
    for (letter in string)
    {
        let currentLetter = string[letter];
        console.log(currentLetter);
        console.log("letter is " + letter)

        if (currentLetter === '@')
        {
            atSymbolPosition = letter;
            console.log(`Found an @ symbol at ${atSymbolPosition}`);
            atSymbolPresent = true;
            var indexBefore = atSymbolPosition - '1';
            console.log(`Index before @ is: ${indexBefore}`);
        }

        if (currentLetter === '.')
        {
            console.log(`Found a period!`)
            {
                dotPresent = true;
            }
        }
    }

    if (dotPresent && atSymbolPresent)
    {
        validEmail = true;
        console.log("Valid email!")
    }
    else
    {
        validEmail = false;
        console.log("InvalidEmail!")
    }
}


/*
6.     Remove Character
	Define function: removeChar(string, index)
Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

*/

function removeChar(string, index)
{
    const stringBeforeIndex = string.slice(0, index);
    //console.log(`Slice should end before character ${string[index]}`);
    //console.log(`${stringBeforeIndex} will be the slice.`);
    const indexAfterRemoval = index + 1;
    const endingIndex = string.length;
    //console.log(`index after removal should be ${indexAfterRemoval} and last index should be ${endingIndex}`);
    const stringAfterIndex = string.slice(indexAfterRemoval, endingIndex);
    let  finalString = stringBeforeIndex + stringAfterIndex;
    console.log(finalString);
    return finalString;
}


/*
7.       Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array. You may need to look up the algorithm if you’re not familiar with it
Return the sorted array.
*/


function bubbleSort(numArray)
{
    // passes = arraylength - 1;
   for (let i = numArray.length - 2; i >= 0; --i)
   {
       // go through as many values as you havent sorted
       for (let j = 0; j <= i; ++j)
       {
           if (numArray[j] > numArray[j + 1])
           {
                var t = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = t;
           }
       }
   }
   console.log(numArray);
   return numArray;
}


/*

8.    Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum)
{
    let intDividedNum = Math.floor(someNum / 2);
    console.log(intDividedNum);

    let result = intDividedNum * 2;
    console.log(result);

    if (result < someNum)
    {
        //console.log(`${result} is less than ${someNum}, so it must be odd `);
        return false;
    }
    else if (result == someNum)
    {
        //console.log(`${result} is equal to ${someNum}, so it must be even `);
        return true;
    }
}

    /*
    9.   Palindrome
Define function: isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false.
*/

function isPalindrome(someStr)
    {
        let someStrLen = someStr.length;
        let backwardsString = "";
        for  (i = someStrLen - 1; i >= 0; --i)
        {
            console.log(someStr[i]);
            backwardsString += someStr[i];
        }

        console.log(backwardsString);
        
        if (backwardsString == someStr)
        {
            //console.log(`${backwardsString} is equal to ${someStr}`);
            return true;
        }
        else
        {
            //console.log(`${backwardsString} is not equal to ${someStr}`);
            return false;
        }
    }   

