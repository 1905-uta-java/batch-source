
function maxLength(arr){
    let l = 0;
    let ind = -1;
    let cur_ind = 0;
    arr.forEach(element => {
        if(l < element.length){
            l = element.length;
            ind = cur_ind;
        }
        cur_ind += 1;
    });
    return ind;
}

function reverseArray(arr){
    let new_arr = [];
    let cur_index = arr.length-1;
    while(cur_index >= 0){
        new_arr.push(arr[cur_index]);
        cur_index -= 1;
    }
    return new_arr;
}

function vowelCount(str){
    let index = 0;
    let count = 0;
    for (index = 0; index < str.length; index++){
        var t = str.charAt(index);
        if(t == "a" || t == "e" || t == "i" || t == "o" || t == "u"){
            count++;
        }
    }
    return count;
}

function isLeapYear(d){
    if(typeof(d) != typeof(Date)){
        return false;
    }
    let year = d.getFullYear();
    if(year%4 == 0){
        if(year%100 == 0){
            if(year%400 == 0){
                return true;
            }
            return false;
        }
        return true;
    }
    return false;
}

function isValidEmail(str){
    let hasAt = false;
    let hasDot = false;
    let inde = 0;

    while(inde < str.length){
        if(str.charAt(inde) == "@"){
            hasAt = true;
        }
        if(hasAt && str.charAt(inde) == "."){
            hasDot = true;
        }
        inde++;
    }

    return hasDot;
}

function removeChar(str, rem_index){
    let new_str = "";
    let str_index = 0;

    while(str_index < str.length){
        if(str_index != rem_index){
            new_str = new_str + str.charAt(str_index);
        }
        str_index++;
    }
    return new_str;
}

function bubbleSort(numArr){
    for(var a=0;a<numArr.length; a++){
        for(var b=0;b<numArr.length-a-1;b++){
            if(numArr[b] > numArr[b+1]){
                let temp = numArr[b];
                numArr[b] = numArr[b+1];
                numArr[b+1] = temp;
            }
        }
    }
    return numArr;
}

function isEven(num){
    return !(num & 1);
}

function isPalindrome(str){
    let str_ind = 0;
    while(str_ind < str.length/2){
        if(str.charAt(str_ind) != str.charAt(str.length - str_ind - 1)){
            return false;
        }
        str_ind++;
    }
    return true;
}

// CHALLENGE

function printShape(shape, height, char){
    let cur_height = 0;
    let cur_width = 0;
    let cur_line = "";
    switch(shape){
        case("Square"):
            while(cur_width < height){
                cur_line = cur_line + char;
                cur_width++;
            }
            while(cur_height < height){
                console.log(cur_line);
                cur_height++;
            }
            break;
        case("Triangle"):
            while(cur_height < height){
                cur_line = cur_line + char;
                console.log(cur_line);
                cur_height++;
            }
        break;
        case("Diamond"):
            if(!isEven(height)){
                while(cur_height < height){
                    cur_line = "";
                    cur_width = 0;
                    while(cur_width <= Math.abs(cur_height-Math.floor(height/2))){
                        cur_line = cur_line + " ";
                        cur_width++;
                    }
                    cur_width = 0;
                    while(cur_width < height-(Math.abs(cur_height-Math.floor(height/2))*2)){
                        cur_line = cur_line + char;
                        cur_width++;
                    }
                    console.log(cur_line);
                    cur_height++;
                }
            }
            else{
                while(cur_height < height){
                    cur_line = "";
                    cur_width = 0;
                    while(cur_width <= Math.abs(cur_height-(height/2-0.5))){
                        cur_line = cur_line + " ";
                        cur_width++;
                    }
                    cur_width = 0;
                    while(cur_width <= height-(Math.abs(cur_height-(height/2 - 0.5))*2)){
                        cur_line = cur_line + char;
                        cur_width++;
                    }
                    console.log(cur_line);
                    cur_height++;
                }
            }
        break;
        default:
            break;
    }
}

function rotate(arr, n){
    for(let c=0;c<n;c++){
        let d=0;
        let tmp = arr[0];
        for(d=0;d<arr.length-1;d++){
            arr[d] = arr[d+1];
        }
        arr[d] = tmp;
    }
    return arr;
}

function balanced(str){
    let chr_arr = [];
    let chr_index = 0;
    while(chr_index < str.length){
        let next_char = str.charAt(chr_index);
        if(next_char == "(" || next_char == "[" || next_char == "{"){
            chr_arr.push(next_char);
        }
        else{
            if(next_char == ")"){
                if(chr_arr.pop() != "("){
                    return false;
                }
            }
            if(next_char == "]"){
                if(chr_arr.pop() != "["){
                    return false;
                }
            }
            if(next_char == "}"){
                if(chr_arr.pop() != "{"){
                    return false;
                }
            }
        }
        chr_index++;
    }
    if(chr_arr.length > 0){
        return false;
    }
    return true;
}