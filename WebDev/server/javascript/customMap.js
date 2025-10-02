var arr1 = new Array(...[1,2,3,4]);  //spread operator
var arr1X2 = arr1.map((item, index) => { // calback fnc as passed to argument of another fnc 
    return item*2;
})


// var arr1 = new Array(1,2,3,4);
// var arr1X2 = arr1.map((item, index) => {
//     return item*2;
// })

var arr1 = arr1.map(callbackMultiply); // not callback function, normal fnc

function callbackMultiply(item, index) {
    return item * 2;
}

// map har ele pr callback fnc implement karega and naya array return karega