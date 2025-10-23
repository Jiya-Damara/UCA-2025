// Everything in Js is an object.
var no = 34;
// Inherits its data type from Number object
console.log(typeof no); // "number"
// therefore . operators and methods of Number object can be used on no
console.log(no.toString()); // "34"


// Multiple ways to declare functions in JavaScript
// 1. Function Declaration - traditional approach
function foo1(param1) {
  console.log("Inside foo1 function with params as: ", param1);
}

// 2. Function Expression
var foo2 = function (param1) {
  console.log("Inside foo2 function with params as: ", param1);
};

// Function declaration & function expression -> zyada difference nhi hai, just hoisting ka farak hai
// Function Expression should be const or let to avoid reassignment

// 3. Function Expression - Arrow Function (ES6)
var foo3 = param1 => {
    console.log("Inside foo3 function with params as: ", param1);
};

// 4. Anonymous Function - function without a name, js will call automatically when required (like map function)
(param1) => {
    console.log("Inside foo4 function with params as: ", param1);
};

// 5. Self Invoking Function - function which calls itself immediately after its declaration
((param1) => {
    console.log("Inside foo5 function with params as: ", param1);
})();

// 6. Generator Function - function which can be exited and later re-entered, maintaining its context
// Instead of return, it uses yield to return multiple values over time in successive calls
// It saves current execution state, not returned values.
// Value calculated/executed during runtime.

function* scoreGenerator(initalScore = 0) {
    let currentScore = initalScore;
    while (currentScore < 2) {
        // Yielding the currentScore & incrementing it
        yield currentScore;
        currentScore++;
    }
    return currentScore; // This will return when generator is done
}

// Using the generator function
const scoreGen = scoreGenerator();

scoreGen.next(); // { value: 0, done: false }
scoreGen.next(); // { value: 1, done: false }
scoreGen.next(); // { value: 2, done: true }      
scoreGen.next(); // { value: undefined, done: true }

// Client control of generation of values
// execute & pause
// jab chahiye tab next() call karke agla value le skte hai


// Arguments vs Parameters
// Define/ declare - parameters
// Pass - arguments when function is called
function foo1(param1) {
  console.log("Inside foo1 functionwith params as: ", param1);
}
// When calling any function - Arguments are passed (and not parameters)
foo2(arg1);