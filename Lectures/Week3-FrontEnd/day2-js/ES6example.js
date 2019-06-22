// let and const were additions to ES6
// symbols
// for/of loops


// function findSum(x,y){
//     return x*y;
// }

// let findSum = function(x,y){
//     return x*y;
// }

// in ES6 we also have the ability to use arrow notation 
    // (params) => {impl}
// let findSum = (x,y) => {return x*y};
let findSum = (x,y) => x*y;


let addFive = x => x+5;

// function addFive(x){
//     return x+5;
// }

// template literal allows for multiline strings 
    // into which we can directly inject variables

let y = `other variables`;

y = (function(){
    return 5;
})();

let x = `here is a 
multiline string
in the form of 
a template literal.
I can also put ${y} in here`;

console.log(x);


