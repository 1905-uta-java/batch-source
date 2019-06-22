console.log("hello")

///////////////// truthy/falsy ////////////////////

// console.log(Boolean(0));
// console.log(Boolean());
// console.log(Boolean(""));
// console.log(Boolean("seven"*7));
// console.log(Boolean(false));
// console.log(Boolean(null));
// console.log(Boolean(9));

///////////////// working with objects ///////////////

// let painter = {
//     name: "Bob",
//     hasAfro: true,
//     skill: 10,
//     mediums: ['oil','watercolor'],
//     paint: function(){
//         console.log("what pretty little trees");
//     }
// }

////////////// variable declaration /////////////////

var x = 5;
var x = 10;

let y = 6;
// let y = 12; SyntaxError
y = 12;

const z = 7;
// z = 14; cannot reassign

// can reassign values of a constant object
const painter = {
        name: "Bob",
        hasAfro: true,
        skill: 10,
        mediums: ['oil','watercolor'],
        paint: function(){
            console.log("what pretty little trees");
        }
    }


// var pass = false;
// var score = 80;
// if(score>75){
//     var pass = true;
// }

// console.log(pass);


// let pass = false;
// console.log("before score eval: " + pass);
// let score = 80;
// if(score>75){
//     let pass = true;
//     console.log("after score eval: " + pass);
// }

// console.log("final eval: "+pass);
// myVar = 15;

console.log(myVar);

var myVar = 25; // this variable is hoisted so its visible before it in its current scope


console.log(myVar2);

let myVar2 = 25; // this will not be hoisted; ReferenceError