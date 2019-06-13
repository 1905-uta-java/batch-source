//FUNCTION DEFS
function maxLength(array)
{
    let ret = "";
    for (s in array)
    {
        if (ret.length < array[s].length) ret = array[s];
    }
    return ret;
}

function reverseArray(array)
{
    let swap = 0;
    for (s = 0; s < (array.length-1)/2; s++)
    {
        swap = array[array.length-s-1];
        array[array.length-s-1] = array[s];
        array[s] = swap; 
    }
}

function vowelCount(string)
{
    let ret = 0;
    let slower = string.toLowerCase();
    for (iter = 0; iter < string.length; iter++)
    {
        if (slower[iter] == 'a' || slower[iter] == 'e' || slower[iter] == 'i' || slower[iter] == 'o' || slower[iter] =='u')
        {
            ret++;
        }
    }
    return ret;
}

function isLeapYear(date)
{
    if (date.getFullYear() % 4 == 0)
    {
        if(date.getFullYear() % 100 != 0 || date.getFullYear() % 400 == 0) return true;
        return false;
    } 
    return false;
}

function isValidEmail(string)
{
    emailRE = /[.\w]@[\w]+[.][\w]+/;
    return emailRE.test(string) ;
}

function removeChar(string,index)
{
    ret = "";
    for (iter = 0; iter < string.length; iter ++)
    {
        if (iter != index) ret = ret + string[iter];
    }
    return ret;
}

function bubbleSort(numArray)
{
    for(iter = 1; iter < numArray.length; iter++)
    {
        for(metaiter = iter; metaiter > 0; metaiter--)
        {
            if(numArray[metaiter-1] > numArray[metaiter]) 
            {
                swap = numArray[metaiter-1];
                numArray[metaiter-1] = numArray[metaiter];
                numArray[metaiter] = swap;
            }
        }
    }
}

function isEven(someNum)
{
    if(someNum & 0x01 == 0x01) return false;
    return true;
}

function isPalindrome(someStr)
{
    for(iter = 0; iter < (someStr.length-1)/2; iter++)
    {
        if(someStr[iter] != someStr[someStr.length-1-iter]) return false;
    }
    return true;
}

function printShape(shape, height, character)
{
    if (shape.toLowerCase() == "square")
    {
        ln = "";
        for (iter = 0; iter < height; iter++)
        {
            for(metaiter = 0; metaiter < height; metaiter ++)
            {
                ln = ln + character;
            }
            console.log(ln);
            ln = "";
        }
        return;
    }
    if (shape.toLowerCase() == "triangle")
    {
        ln = "";
        for (iter = 0; iter < height; iter++)
        {
            for(metaiter = 0; metaiter < iter+1; metaiter ++)
            {
                ln = ln + character;
            }
            console.log(ln);
            ln = "";
        }
        return;
    }
    if (shape.toLowerCase() == "diamond")
    {
        ln = "";
        cumu = [];
        for (iter = 0; iter < height; iter++)
        {
            for(metaiter = 0; metaiter < height; metaiter ++)
            {
                if(isEven(height))
                {
                    val = Math.abs(metaiter - (height-1)/2) + Math.abs(iter - (height-1)/2);
                    if(val < (height+1)/2)
                    {
                        ln = ln+character;
                    }
                    else
                    {
                        ln = ln+" ";
                    }
                }
                else
                {
                    val = Math.abs(metaiter -Math.floor(height/2)) + Math.abs(iter -Math.floor(height/2));
                    if(val < Math.floor((height+1)/2))
                    {
                        ln = ln + character;
                    }
                    else
                    {
                        ln = ln + " ";
                    }
                }
            }
            console.log(ln);
            ln = "";
        }
        return;
    }

    return;
}

function rotate(array, n)
{
    let out = []
    for (iter = 0; iter < array.length; iter++)
    {
        out = out + array[(n+iter)%array.length];
    }
    return out;
}

function balanced(string)
{
    stck = [];
    val;
    for (iter = 0; iter < string.length; iter++)
    {
        if(string[iter] == '(' || string[iter] == '{' || string[iter] == '[')
        {
            stck.push(string[iter]);
        }
        if(string[iter] == ')')
        {
            if(stck.length == 0) return false;
            val = stck.pop();
            if(val != '(') 
            {
                return false;
            }
        }
        if(string[iter] == '}')
        {
            if(stck.length == 0) return false;
            val = stck.pop();
            if(val != '{') 
            {
                return false;
            }
        }
        if(string[iter] == ']')
        {
            if(stck.length == 0) return false;
            val = stck.pop();
            if(val != '[') 
            {
                return false;
            }
        }
    }
    if(stck.length != 0) return false;
    return true;
}

//CODE TESTS

console.log("maxLength test: ");
maxLengthTestArray = ["words", "words words", "words words words", "word", "this one is the longest one here", "more words"];
console.log(maxLengthTestArray);
console.log(maxLength(maxLengthTestArray));

console.log("reverseArray test: ");
reverseArrayTestArray = [0,1,2,3,4];
console.log(reverseArrayTestArray);
reverseArray(reverseArrayTestArray);
console.log(reverseArrayTestArray);

console.log("vowelCount test: ");
vowelCountIn = "abcdef ghi";
console.log(vowelCountIn);
console.log(vowelCount(vowelCountIn));

console.log("isLeapYear test:")
dateIn = new Date('2000-12-25T00:00:00');
console.log(dateIn);
console.log(isLeapYear(dateIn));

console.log("isValidEmail test: ")
email = "wsm@efoe.com";
nonemail = "wsm@fff";
console.log(isValidEmail(email));
console.log(isValidEmail(nonemail));

console.log("removeChar test: ")
removeCharStr = "words";
console.log(removeChar(removeCharStr, 1));

console.log("bubbleSort test: ");
preSort = [0,4,6,1,2,5]
console.log(preSort);
bubbleSort(preSort);
console.log(preSort);

console.log("isEven test: ");
even = 2;
odd = 1;
console.log(isEven(odd));
console.log(isEven(even));

console.log("isPalindrome test: ");
palindrome = "aanmnaa";
nonpalindrome = "aabb";
console.log(isPalindrome(palindrome));
console.log(isPalindrome(nonpalindrome));

console.log("shapes test:")
printShape("square", 3, "%");
printShape("triangle",3,"$");
printShape("diamond", 5, "*");

console.log("rotate left test: ");
rotTest = [0,1,2,3,4];
console.log(rotate(rotTest, 1));
console.log(rotate(rotTest, 3));
console.log(rotate(rotTest,6));

console.log("balanced test: ")
console.log(balanced("()\n()()\n(())\n({[]})"));
console.log(balanced("(\n)\n(()i\n([)]\n"));