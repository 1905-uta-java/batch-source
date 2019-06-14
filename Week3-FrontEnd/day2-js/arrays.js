let myObj = {
    0: null,
    1: "hello",
    2: true,
    3: 25
}

let myArr = [null, "hello", true, 25];

// for( i=0; i<myArr.length; i++){
//     console.log(i+": "+myArr[i]);
// }

// // for/in loop
// for(i in myArr){
//     console.log(i+": "+myArr[i]);
// }


// // for/of loop * this can only be used with arrays
// for(i of myArr){
//     console.log(i);
// }

// // for/in loop works just fine with objects
// for(i in myObj){
//     console.log(i+": "+myArr[i]);
// }


// // this is not supported bc myObj is not iterable 
// for(i of myObj){
//     console.log(i);
// }


// either way to declare a function 
// let printAll = function(){
// }

// function printAll(){  
// }


// any function called with less than the variables declared will have undefined variables
// function printAll(a, b, c){
//     console.log(a);
//     console.log(b);
//     console.log(c);
//     return "function completed";
// }

// any function called with more than the arguments defined can access additional variables with "arguments"
function printAll(){
    for(i of arguments){
        console.log(i);
    }
    return "function completed";
}

