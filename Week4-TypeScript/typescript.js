function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
}
doSomething();
var x = 5;
var y = 5;
//y = "hello";
var boo;
var str;
var obj;
function myVoidFunction() {
    //return 5;
    console.log("this function doesn't return anything");
}
var anotherFunction = function (value) {
    if (typeof value === "string" && typeof value === "number") {
        return value;
    }
};
var foreverFunc = function () {
    while (true) {
        console.log("hello");
    }
};
var myArr = [true, 4, "hello"];
var myStrArr;
// myStrArr = ["hello",5];
var anotherArr;
anotherArr = ["hello", 5];
var drawPoint = function (x, y) {
    console.log(x + ", " + y);
};
drawPoint(4, 5);
var drawPoint2 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint2({ x: 5, y: 12 });
drawPoint2({ name: "Holly", email: "hollyy@gmail.com" });
var drawPoint3 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint3({ x: 5, y: 12 });
var drawPoint4 = function (point) {
    console.log(point.x + ", " + point.y);
};
drawPoint3({ x: 5, y: 12 });
//drawPoint3({name:"Holly",email:"hollyy@gmail.com"});
var MyPoint = /** @class */ (function () {
    function MyPoint() {
    }
    return MyPoint;
}());
var AlsoPoint = /** @class */ (function () {
    function AlsoPoint(_x, _y) {
        var _this = this;
        this.drawPoint = function () {
            console.log(_this.x + ", " + _this.y);
        };
        this.x = _x;
        this.y = _y;
    }
    return AlsoPoint;
}());
var p = new AlsoPoint(10, 20);
p.drawPoint();
