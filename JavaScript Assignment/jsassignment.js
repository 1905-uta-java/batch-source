function run(){
    //does stuff
    //Q1
    console.log("Question 1");
    console.log("Running...");
    let q1Arr = ["longest", 'long', 'on', "great", "shucks"];
    console.log(maxLength(q1Arr));
    
    //Q2
    console.log("\n\nQuestion 2");
    let q2Arr = ["j", "e", "s", "s", "e"];
    console.log("J,e,s,s,e: " + reverseArray(q2Arr));
    q2Arr = [1, 2, 3, 4, 5, 6, 7, 8];
    console.log("1,2,3,4,5,6,7,8: " + reverseArray(q2Arr));
    q2Arr = [987654321];
    console.log("987654321: " + reverseArray(q2Arr));
    q2Arr = ["dog"];
    console.log("dog" + reverseArray(q2Arr));
    q2Arr = ["j","a","m","e","s"," ","w","a","s"," ","h","e","r","e"];
    console.log('j,a,m,e,s, ,w,a,s, ,h,e,r,e: ' + reverseArray(q2Arr));
    q2Arr = [1, "e", 2, "f", 3, 'food'];
    console.log("1, 'e', 2, 'f', 3, 'food': " + reverseArray(q2Arr));
    
    //Q3
    console.log("\n\nQuestion 3");
    console.log("vowels: " + vowelCount("vowels"));
    console.log("n vwls: " + vowelCount("n vwls"));
    console.log("yo: " + vowelCount("yo"));
    console.log("wdswdwdwdwdwdwdwdwdwdwdwdwdwdw: " + vowelCount("wdswdwdwdwdwdwdwdwdwdwdwdwdwdw"));
    console.log("1234567: " + vowelCount("1234567"));
    console.log("123 four five six: " + vowelCount("123 four five six"));
    
    //Q4
    console.log("\n\nQuestion 4");
    console.log("1984: " + isLeapYear(1984));
    console.log("2000: " + isLeapYear(2000));
    console.log("2014: " + isLeapYear(2014));
    console.log("2016: " + isLeapYear(2016));
    
    //Q5
    console.log("\n\nQuestion 5");
    console.log("@: " + isValidEmail("@."));
    console.log(" : " + isValidEmail(" "));
    console.log(": " + isValidEmail(""));
    console.log("lololololol@gmail.com: " + isValidEmail("lololololol@gmail.com"));
    console.log("lololololol@gmail.com: " + isValidEmail("lololololol@gmail.com"));
    console.log("cscscscscscscscscahciujdizvbyudijz@hd.cjidknoc: " + isValidEmail("cscscscscscscscscahciujdizvbyudijz@hd.cjidknoc"));
    
    //Q6
    console.log("\n\nQuestion 6");
    console.log("removing char from 'cheese' at  5: " + removeChar("cheese", 5));
    console.log("removing char from 'cheese' at  0: " + removeChar("cheese", 0));
    console.log("removing char from 'abcdefghijklmnopqrstuvwxyz' at  14: " + removeChar("abcdefghijklmnopqrstuvwxyz", 14));
    console.log("removing char from 'abcdefghijklmnopqrstuvwxyz' at  41: " + removeChar("abcdefghijklmnopqrstuvwxyz", 41));
    

    //Q7
    console.log("\n\nQuestion 7");
    let bubSortArr = [7,8,12,9,2,1,54,3];
    console.log("7,8,12,9,2,1,54,3: \t" + bubbleSort(bubSortArr))
    bubSortArr = [1234567890];
    console.log("1234567890: \t" + bubbleSort(bubSortArr))
    bubSortArr = [54,3];
    console.log("54,3: \t" + bubbleSort(bubSortArr))
    bubSortArr = [7,6,2,5,89,24,1,67];
    console.log("7,6,2,5,89,24,1,67: \t" + bubbleSort(bubSortArr))
    bubSortArr = [7,7, 7, 7, 7, 7];
    console.log("7,7, 7, 7, 7, 7: \t" + bubbleSort(bubSortArr))
    bubSortArr = [9,8,7,6,5,4,3,2,1];
    console.log("9,8,7,6,5,4,3,2,1: \t" + bubbleSort(bubSortArr))

    //Q8
    console.log("\n\nQuestion 8");
    console.log("14: " + isEven(14));
    console.log("15: " + isEven(15));
    console.log("41: " + isEven(41));
    console.log("10.0000000000000000000001: " + isEven(10.0000000000000000000001));
    console.log("2.2: " + isEven(2.2));
    console.log("90: " + isEven(90));
    console.log("0: " + isEven(0));
    
    //Q9
    console.log("\n\nQuestion 9");
    console.log("racecar: " + isPalindrome("racecar"));
    console.log("go hang a salami, i'm a lasagna hog: " + isPalindrome("go hang a salami, i'm a lasagna hog"));
    console.log("thi sis not a p a l i n d ro m e: " + isPalindrome("thi sis not a p a l i n d ro m e"));
    
	
	//Q10
    console.log("\n\nQuestion 10");
	console.log("Square, 6, *: \n" + printShape("Square", 6, "*") + "\n");
	console.log("Triangle, 2, %: \n" + printShape("Triangle", 2, "%") + "\n");
	console.log("Diamond, 1, k: \n" + printShape("Diamond", 1, "k") + "\n");
	console.log("Square, 19, *: \n" + printShape("Square", 19, "*") + "\n");
	console.log("Square, 2, *: \n" + printShape("Square", 2, "*") + "\n");
	
	
	//Q11
    console.log("\n\nQuestion 11");
	console.log("Rotating arr [1,2,3,4,5,6,7,8] by  4: " + rotate([1,2,3,4,5,6,7,8], 4));
	console.log("Rotating arr [1,2] by  4: " + rotate([1,2], 4));
	console.log("Rotating arr [8,1,65,2,6] by  19: " + rotate([8,1,65,2,6], 19));
	console.log("Rotating arr [1,2,3,4,5,6,7,8] by  0: " + rotate([1,2,3,4,5,6,7,8], 0));
	
	
	//Q12
    console.log("\n\nQuestion 12");
	console.log("[][][][][][][]: " + balanced("[][][][][][][]"));
	console.log("[[[[[]]]]]]: " + balanced("[[[[[]]]]]]"));
	console.log("({[]}): " + balanced("({[]})"));
	console.log("[[[[[[[[[[[[[: " + balanced("[[[[[[[[[[[[["));
	console.log("[[{{[[[{(999(((000))))))))): " + balanced("[[{{[[[{(999(((000)))))))))"));
	console.log("99999999999: " + balanced("99999999999"));
	
}




//QUESTION 1
/* 
    Write a JavaScript to find the longest string from a given array of strings and returns the string’s array index.
*/
function maxLength(arr){
    let longestLen = 0;
    
    for(let i = 0; i < arr.length; i++){
        if(arr[i].length > longestLen){
            longestLen = arr[i].length;
        }
    }
    return longestLen;
}




//QUESTION 2
/*
    Write a JavaScript function to reverse the elements of a given array.
*/
function reverseArray(arr){
    let revArr = new Array();
    let k = 0;
    for (let i = arr.length; i > 0; i--){
        revArr[k] = arr[i-1];
        k++;
    }
    return revArr;
}



//QUESTION 3
/*
    Write a JavaScript function to count the number of vowels in a given string.
*/
function vowelCount(str){
    let vowCnt = 0;
    let chr = '';
    
    for(let i = 0; i<str.length; i++){
        chr = str.charAt(i).toLowerCase();
        if(chr == 'a' || chr == 'e' || chr == 'i' || 
            chr == 'o' || chr == 'u' ) {//a,e,i,o,u
            vowCnt++;
        }
    }
    return vowCnt;
}



//QUESTION 4
/*
Define function: isLeapYear(date)
Create a JavaScript function that takes a date parameter
and returns true if the year is a leap year in the Gregorian calendar.
*/
function isLeapYear(date){
    // do some quick checking, date can be converted into an int, and is 4 chars long 

    if(date % 4 == 0 || date % 400 == 0){
        return true
    } 
    return false;
}



//QUESTION 5
/*
Define function: isValidEmail(string)
Create a function that checks for a valid email format.
*/
function isValidEmail(email){
    let foundAt, foundDot = false;
    let index = 0;
    let newStr = "";

    //first, check for  @, make sure there is also stuff before it 
    for(let i = 0; i < email.length; i++){
        if(email.charAt(i) == '@' && i > 0){
            foundAt = true;
            index = i;
            //console.log("Found @ at index " + index + " char is: " + email.charAt(i));
            //console.log("Next char is: " + email.charAt(i+1));
            break;
        }
    }
    
    newStr = email.substring(index);
    
    //next, check for . and things after it
    if(foundAt){
        for(let j = 0; j < newStr.length; j++){
            if(newStr.charAt(j) == '.' && j > 0 &&  (j+1) < newStr.length){
                foundDot = true;
                index = j;
                //console.log("Found . at index " + index + " char is: " + newStr.charAt(i));
                //console.log("\nNext char is: " + newStr.charAt(i+1));
                break;
            }
        }
    }

    if(foundAt && foundDot)
        return true;
    return false;
}


//QUESTION 6
/*
    Define function: removeChar(string, index)
    Write a JavaScript function to remove a character at the 
    specified position of a given string and return the new string.
 */
 function removeChar(string, index){
    let newStr = "";
    
    newStr = string.substring(0, index) + string.substring(index+1);

    return newStr;
 }





 //QUESTION 7
 /*
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array. 
    You may need to look up the algorithm if you’re not familiar with it
    Return the sorted array.
 */
function bubbleSort(numArray){
    let num1 = 0;
    let num2 = 0;
    
    for(let i = 0; i < numArray.length; i++){
        num1 = numArray[i];
        
        for(let j = 0; j < numArray.length; j++){
        
            num2 = numArray[j];
        
            if(num1 < num2){
                numArray[j] = num1;
                numArray[i] = num2;
                num1 = num2;

            } 
            //console.log("current array: " + numArray);
        }
    }
    return numArray;
}



//QUESTION 8
/*
    Define function: isEven(someNum)
    Return true if even, false if odd.
    Do not use % operator.=
*/
function isEven(someNum){
    let num = someNum;
    if(num < 1) num *= -1;
    
    while (num > 1) num -= 2;

    if(num == 0) return true;
    
    return false;
}


//QUESTION 9
/* 
Define function: isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false.
*/
function isPalindrome(someStr){
    let newStr = "";
    let backStr = "";
    let str = "";
    let backArr = [];
    if(typeof(someStr) == 'string'){
        newStr = someStr.replace(/\W/g,'').toLowerCase();
        //newStr = someStr.replace(/\s/g,'');
        let forArr = newStr.split("");
        backArr = reverseArray(forArr);
    
        for(let i = 0; i < forArr.length; i++){
            str += forArr[i];
        }
        
        for(let j = 0; j < forArr.length; j++){
            backStr += backArr[j];
        }
        
        if(str === backStr)
            return true;
    }
    return false;
}



//QUESTION 10
/*Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape.
Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%*/
function printShape(shape, height, character){
	let str = "";
	let spaces, tempSpaces;
	
	switch(shape){
		case "Square":
			for(let i = 0; i < height; i++){
				for(let j = 0; j < height; j++){
					str += character  + " ";				
				}
				str += "\n";
			}
			break;
		case "Triangle":
			for(let i = 0; i < height+1; i++){
				for(let j = 0; j < i; j++){
					str	+= character + " ";
				}
				str += "\n";
			}
			break;
		case "Diamond":
			spaces = parseInt(height);
			tempSpaces = spaces			
			//print top
			for(let i = 0; i < height; i++){
				for(let j = 0; j < tempSpaces; j++){
					str += " ";
				}
				tempSpaces--;
				for(let k = 0; k <= i; k++){
					str += character + " ";
				}
				str += "\n";
			}
			
			//print bottom
			tempSpaces = 2;
			height--;
			for(let i = height; i > 0; i--){
				for(let j = 0; j < tempSpaces; j++){
					str += " ";
				}
				tempSpaces++;
				for(let k = i; k > 0; k--){
					str += character + " ";
				}
				str += "\n";
			}
			break;
	}
	//console.log(str);
	return str;
}




//QUESTION 11
function rotate(arr, n){
	let first;
	for (let i = 0; i < n; i++){
		first = arr[0];
		arr.shift();
		arr[arr.length] = first;
	}
	return arr;
}


//QUESTION 12
function balanced(string){
	let leftArr = ["(", "{", "["];
	let rightArr = [")", "}", "]"];
	let found = false;
	let left = 0;
	let right = 0;
	
	for(var i = 0; i < string.length; i++){
		for(var j = 0; j < leftArr.length; j++){
			if(leftArr[j] == string.charAt(i)){
				found = true;
				left++;
				break;
			}
		}
		if(!found){
			for(var k = 0; k < rightArr.length; k++){
				if(rightArr[k] == string.charAt(i)){
					found = true;
					right++;
					break;
				}
			}
		}
			
		if(!found) break;
		else found = false;
	}
	
	if(left == right)
		return true;
	else 
		return false;
}






