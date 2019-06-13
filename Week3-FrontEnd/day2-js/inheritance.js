

let animal = {
    eats: true,
    jumps: false
}

let rabbit = {
    jumps: true
}

rabbit.__proto__ = animal;

// prototypal inheritance is achieved through this __proto__ property
// it allows the object whose __proto__ we've set to have access to the properties 
// and methods associated with the value