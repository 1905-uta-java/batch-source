function doSomething(){
    for(let i=0;i<5;i++){
        console.log(i);
    }
}

doSomething();


let x: number = 5;
let y = 5;

//y = "hello";


let boo: boolean;
let str: string;
let obj: object;

function myVoidFunction(): void{
    //return 5;
    console.log("this function doesn't return anything");
}

let anotherFunction = function(value){
    if(typeof value === "string" && typeof value === "number"){
        return value;
    }
}

let foreverFunc = function(){
    while(true){
        console.log("hello");
    }
}

let myArr = [true, 4, "hello"];
let myStrArr: string[];
// myStrArr = ["hello",5];
let anotherArr: any[];
anotherArr = ["hello",5];


let drawPoint = (x: number,y: number) => {
    console.log(x+", "+y);
}

drawPoint(4,5);

let drawPoint2 = (point) =>{
    console.log(point.x+", "+point.y);
}

drawPoint2({x:5,y:12});
drawPoint2({name:"Holly",email:"hollyy@gmail.com"});

let drawPoint3 = (point: {x:number, y:number}) =>{
    console.log(point.x+", "+point.y);
}

drawPoint3({x:5,y:12});
// drawPoint3({name:"Holly",email:"hollyy@gmail.com"});

interface Point{
    x: number;
    y: number;
}

let drawPoint4 = (point: Point) =>{
    console.log(point.x+", "+point.y);
}

drawPoint3({x:5,y:12});
//drawPoint3({name:"Holly",email:"hollyy@gmail.com"});

class MyPoint{
    x: number;
    y: number;
}


class AlsoPoint{
    x: number;
    y: number;

    constructor(_x?:number, _y?:number){
        this.x = _x;
        this.y = _y;
    }

    drawPoint = ()=>{
        console.log(this.x+", "+this.y);
    }

}

let p: AlsoPoint = new AlsoPoint(10,20);
p.drawPoint();