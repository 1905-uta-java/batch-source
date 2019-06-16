// Finding the longest string.

function findLongestWord(array) {
    var longestWord = "";

    array.forEach(function(word) {
        if (word.length > longestWord.length) {
            longestWord = word;
        }
    });

    return longestWord;
}

// / / / / / / / / / / /  /            2              // // // // // // // / /
var arr = ["darshan", "Patel"]

function reverseArray(arr) {
    var newArray = [];
    for (var i = arr.length - 1; i >= 0; i--) {
        newArray.push(arr[i]);
    }
    return newArray;
}

// / / / / / / / / / / /  /            3             // // // // // // // / /


function getVowel(str) {

    var stringCount = 0;

    var string = str.toString();
    for (let i in string) {
        if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') {
            stringCount += 1;
        } else {
            if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U') {
                stringCount += 1;

            }
        }
    }

    return stringCount;
}



///////////////////////////////////////     4        /////////////////////////////////////////////////


function leapyear(year) {
    return (year % 100 === 0) ? (year % 400 === 0) : (year % 4 === 0);
}


//////////////////////////////////////       5        ///////////////////////////////////////////////

function ValidatEmail(email) {
    var re = /\S+@\S+/;
    return re.test(email);
}


//////////////////////////////////////       6        ///////////////////////////////////////////////

function removeByIndex(str, index) {
    if (index == 0) {
        return str.slice(1)
    } else {
        return str.slice(0, index - 1) + str.slice(index);
    }
}

//////////////////////////////////////       7       ///////////////////////////////////////////////
var a = [33, 103, 3, 726, 200, 984, 198, 764, 9];

function bubbleSort(a) {
    var swapped;
    do {
        swapped = false;
        for (var i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                var temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}
//////////////////////////////////////       8      ///////////////////////////////////////////////

function even(n) {
    var number = parseInt(n);
    if (number % 2 == 0) {
        console.log('Number is even : ' + n);
    } else {
        console.log('Number is odd : ' + n)
    }
}

//////////////////////////////////////       9     ///////////////////////////////////////////////

function checkPalindrom(palindrom) {

    for (var i = palindrom.length; i > 0; i--) {
        if (palindrom[i] = palindrom.charAt(palindrom.length) - 1) {
            return true;
        } else {
            return false;
        }
    }
}