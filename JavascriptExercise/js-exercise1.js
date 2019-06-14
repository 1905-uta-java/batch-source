/*****************************************************************
//Function to find longest string in an array and returns the strings array index
*****************************************************************/

function maxLength(array){
    let maxL = 0;
    let maxI = null;
    let count = 0;

    for(i of array){
        //Make sure the variable is a string
        if(typeof i === "string" || i instanceof String){
            
            //Check if the length of the string is gretter than current max length
            if(i.length > maxL){
                maxL = i.length;
                maxI = count;
            }
        }

        count += 1;
    }

    return maxI;

}



/*****************************************************************
//Fuction that reverses the elements of an array
*****************************************************************/

function reverseArray(array){
    let revArray = [];
    revArray.length = 0;
    let count = array.length - 1;
    //Loop that puts the elements in a new array in reverse order
    for(var i = array.length; i>-1;i--){
        revArray.push(array[i]);
    }
    revArray.shift();
    return revArray;

}



/*****************************************************************
//Function that counts the number of vowels in a given string
*****************************************************************/

function vowelCount(string){

    let vowelCounter = 0;

    //Check if its a string if not return null;
    if(typeof string === "string" || string instanceof String){
        for(var i =0; i<string.length; i++){
            let char = string.charAt(i).toLowerCase();
            if((char === 'a'||char === 'e'||char === 'i'|| char === 'o'||char ==='u'||false) !== false){
                vowelCounter += 1;
            }
        }
    }else{
        return null;
    }

    return vowelCounter;
}



/*****************************************************************
//Function that takes a date and returns if the year is a leap wear in gregorian calendar
*****************************************************************/

function isLeapYear(date){
    let year;
    let month;
    let day;

    //Check that date is a string and length isnt greater than 10
    if(typeof string !== "string" || date.length > 10){
        return false;
    }

    //Get the year from the date of format "mm/dd/yyyy"
    year = date.substring(6,9);

    //Get the month from the date format
    month = date.substring(0,1);

    //Get the day from the date format
    day = date.substring(3,4);

    //Check that valid date
    if(isNaN(month) === true || isNaN(day) === true || isNaN(year) === true){
        return false;
    }

    //Convert all strings into numbers
    year = Number(year);
    month = Number(month);
    day = Number(day);

    //Check if months between 1 and 12
    if(month < 12 && month > 1){
        //Check if day is possible for month
        if(day < 31 && day > 0){
            //Now computes if the year is a leap year
            if(year%4 === 0){
                //Check if divided by 100 and 400 is evenly
                if(year%100 === 0 && year%400 ===0){
                    return true;
                }
            }

        }
    }
    return false;

}



/*****************************************************************
//Function that checks to make sure an email is valid format
*****************************************************************/

function isValidEmail(string){
    //Use a regular expression to check if email format correctly
    if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string)){
        return true;
    }else{
        return false;
    }
}



/*****************************************************************
//Function that remove a cahracter at the specified position of a givine string and returns new string
*****************************************************************/

function removeChar(string, index){
    let firstHalf = string.substring(0,index);
    let secondHalf = string.substring(index+1,string.length);
    return firstHalf+secondHalf;
}



/*****************************************************************
//Function that uses bubble sort algorithm to sort an array and returns sorted array
*****************************************************************/

function bubbleSort(numArray){
    //Store array
    let numArraySort = numArray;

    //Loop through the array
    for(let i = 0; i < numArraySort.length; i++){
        for(let j = 0; j < numArraySort.length - i - 1; j++){
            
            //If index j is larger then index j+1, swap
            if(numArraySort[j]>numArraySort[j+1]){
                let temp = numArraySort[j];
                numArraySort[j] = numArraySort[j+1];
                numArraySort[j+1] = temp;
            }
        }
    }

    return numArraySort;

}



/*****************************************************************
//Function that returns true if even and false if odd, dont use % operator
*****************************************************************/

function isEven(someNum){
    if(!(someNum & 1)){
        return true;
    }else{
        return false;
    }
}



/*****************************************************************
//Function that returns true if someStr is a palindrome, otherwise return false.
*****************************************************************/

function isPalindrome(someStr){
    let lower = someStr.toLocaleLowerCase();
    let len = Math.floor(someStr.length/2);

    for(let i = 0; i < len; i++){
        if(lower[i] !== lower[len - i - 1]){
            return false;
        }
    }

    return true;
}





/*
****************************************
**********CHELLENGE QUESTIONS***********
****************************************
*/

/*
Define function: printShape(shape,height,character)
shape is a string and is either Square, Triangle, Diamond
height is a number and is the height of the shape. Assume its odd
character is a Strign that represents the contents of the shape
Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$

Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/
















/*
Define function: rotate(array, n)
Given array, rotate left n times and return array
Examples
f([1,2,3,4,5], 1) = [2,3,4,5,1]
f([1,2,3,4,5], 6) = [2,3,4,5,1]
f([1,2,3,4,5], 3) = [4,5,1,2,3]
*/














/*
Define function: balanced(string)
A bracket is any one of the following: (, ), {, }, [, or ]
The following are balanced brackets:
()
()()
(())
({[]})
The following are NOT balanced brackets
(
)
(()i
([)]
Create a function which takes a string of brackets and returns true if balanced and false if not balanced
*/
















