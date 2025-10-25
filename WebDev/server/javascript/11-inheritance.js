// Based on understanding of
// -- prototypical inheritance,
// -- constructor functions
// -- this keyword inside constructor functions

var arr1 = new Array(...[1, 2, 3, 4]);

// var arr1X2 = arr1.map((item => {
//     return item * 2;
// }));
// map har ele pr callback fnc implement karega and naya array return karega

var arr1X2 = arr1.map(callbackMultiplyBy2);
function callbackMultiplyBy2(item) {
    return item * 2;
}

var arr5 = [1, 2, 3, 4, 5];
var arr10 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
aar5.customMap(callbackMultiplyBy2); // [2,4,6,8,10]
arr10.customMap(callbackMultiplyBy2); // [2,4,6,8,10,12,14,16,18,20]

Array.prototype.customMap = function(callback) {
    console.log(this); // this refers to the array on which we called the method.
    var result = [];
    for (let i = 0; i < this.length; i++) {
        let callbackValue = callback(this[i]);
        result.push(callbackValue);
    }
    return result;
}

Array.prototype.forEachCustom = function(callback) {
    console.log(this);
    for (let i = 0; i < this.length; i++) {
        callback(this[i]);
    }
}

Array.prototype.customLength = function(callback) {
    return this.length;
}