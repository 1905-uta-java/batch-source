/*

closures take advantage of scoping ot make variables 
inaccessible to other segments of code

functions have access to global
functions have access to the scope they've been declared in

*/


/*
let counter = 0;
function add(){
    counter += 1;
}
*/

/*
function add(){
    let counter = 0;
    counter += 1;
    return counter;
}
*/

/*
function add(){
    let counter = 0;
    function plus() {counter += 1;}
    plus();
    return counter;
}
*/

// let add = function(){
//     let counter = 0;
//     return function() {counter +=1; return counter;}
// }

let add = (function(){
    let counter = 0;
    return function() {counter +=1; return counter;}
})()