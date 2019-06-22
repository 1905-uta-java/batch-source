/*
 aside: three ways we can create objects 
    - creating an object literal
    - use a maker function
    - using a constructor
*/


// function Person(name, age){
    // these variables are not protected
//     this.name = name;
//     this.age = age;
// }


function Person(nameInput, ageInput){
    let name = nameInput;
    let age = ageInput;

    this.getAge = function(){
        return age;
    }

    this.setAge = function(ageParam){
        age = ageParam;
    }

    this.getName = function(){
        return name;
    }

    this.setName = function(nameParam){
        name = nameParam;
    }
}

function Painter(){

    let isPainting;

    this.getIsPainting = function(){
        return isPainting;
    }

    this.setIsPainting = function(isPaintingParam){
        isPainting = isPaintingParam;
    }

    this.__proto__ = new Person();

}