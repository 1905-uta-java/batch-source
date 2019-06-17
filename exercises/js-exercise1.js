// #1
function maxLength(arr){
    let longestStr = -1;
    for(i in arr){
        if(typeof(arr[i]) === "string"){
            if(longestStr >= 0){
                if(arr[i].length > arr[longestStr].length){ 
                    longestStr = i;}
            } else { longestStr = i}
        }
    }
    return longestStr;
}
// #2
function reverseArray(arr){
    let reversed = []
    for(i = arr.length-1; i >= 0; i--){
        reversed.push(arr[i])
    }
    return reversed;
}
//#3
function vowelCount(str){
    let numOfVowels = 0;
    let vowels = ['a','e','i','o','u'];
    for(char in str){
        if(vowels.includes(str[char])) { numOfVowels +=1;}
    }
    return numOfVowels;
}
//#4
function isLeapYear(date){
    let year = date.getFullYear();
    let answer = "no"
    if(year % 4 === 0){
        if(year % 100 === 0){
            if(year % 400 === 0){
                answer = "yes"
            }
        }
    }
    return answer;
}
//#5
function isValidEmail(str){
    if(typeof(str)==="string"){
        let noAt = str.split('@');
        for(i=1; i<noAt.length;i++){
            if(noAt[i].split('.').length > 1){ return true;}
        }
    }
    return false;
}
//#6
function removeChar(str, ind){
    let newStr = "";
    if(typeof(str) === "string"){
        if(typeof(ind) === "number"){
            if(ind <= str.length && ind >=0){
                newStr = str.substring(0,ind) + str.substring(ind+1,str.length)
            }
        }
    }
    return newStr;
}
//#7
function bubbleSort(numArr){
    //extra for loop will always take O(n^2) because of number of iterations
    for(j=0; j< Math.pow(numArr.length,2); j++){
    for(i =0; i< numArr.length; i++){
        if(i+1 < numArr.length){
        if(numArr[i] > numArr[i+1]){
        var temp = numArr[i+1];
        numArr[i+1] = numArr[i];
        numArr[i] = temp;
            }
        }   
    }
}
    return numArr;
}
//#8
function isEven(num){
    return Number.isInteger(num/2);
}
//#9
function isPalindrom(str){
    var s = "";
   for(i = str.length-1;i>=0;i--){
       s = s+str[i]
   } 
   if(str === s) { return true;} else {return false;}
}