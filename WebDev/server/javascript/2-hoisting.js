// Function vs block

// Function scope created by function
// Block scope created by {} (e.g., if, else, for, while, switch, do)

// Hoisting = moving declaration to the top of the scope (function or block)
// Only declarations are hoisted, not initializations
// Hoisting applies to var, function, let, const, class, import

// var hoisting - move the var declaration to the top of the innermost function scope
// let hoisting - move the let declaration to the top of the innermost block scope

function foo() {
    // var will be hoisted to the top of the function
    console.log("var x before is:", x); // undefined
    console.log("let y before is:", y); // ReferenceError: y is not defined

    if (true) {
        // let will be hoisted at the top of the block
        var x = 10;
        let y = 20;
    }
}

function foo() {
    if (true) {
        var x = 10;
        let y = 20;
    }
    console.log("var x after is:", x); // 10
    console.log("let y after is:", y); // ReferenceError: y is not defined
}

function foo() {
    if (true) {
        console.log("var x before is:", x); // undefined
        console.log("let y before is:", y); // ReferenceError: y is not defined
        var x = 10;
        let y = 20;
    }
    console.log("var x after is:", x); // 10
    console.log("let y after is:", y); // ReferenceError: y is not defined
}

function foo() {
    if (true) {
        var x = 10;
        let y = 20;
        console.log("var x after is:", x); // 10
        console.log("let y after is:", y); // 20
    }
    console.log("var x after is:", x); // 10
    console.log("let y after is:", y); // ReferenceError: y is not defined
}


// FUNCTION HOISTING

// Function declaration
function fooF() {
    console.log("Function fooF called");
}

fooF(); // Function Invocation

// Functional Expression
var fooE = function() {
    console.log("Function fooE called");
}


// Function Invocation before declaration works because function declarations are hoisted
fooF();
function fooF() {
    console.log("Function fooF called");
}

fooV(); // Uncaught TypeError: fooV is not a function at <anonymous>:1:1
var fooV = function() {
    console.log("Function fooV called");
}

fooL(); // Uncaught ReferenceError: Cannot access 'fooL' before initialization
let fooL = function() {
    console.log("Function fooL called");
}

function foo1() {
    fooL2(); // VM1360:2 Uncaught ReferenceError: Cannot access 'fooL2' before initialization
    let fooL2 = function() {
        console.log("Function fooL2 called");
    }
}
// In this last case, block scope and function scope are the same but they are not equal to global scope.
// Therefore, let & const can't be accessed before initialization even inside the function.

function foo1() {
    fooV2(); // VM1360:2Uncaught TypeError: fooV2 is not a function at <anonymous>:1:1
    let fooV2 = function() {
        console.log("Function fooV2 called");
    }
}
//  In this last case, var is hoisted to the top of the function scope, but its initialization is not hoisted.
// So initaialised to undefined.
// hence, calling undefined() gives TypeError

function foo1() {
    fooF2(); // Function fooF2 called
    function fooF2() {
        console.log("Function fooF2 called");
    }
}
// In this last case, function declarations are hoisted to the top of the function scope along with their definitions.
// Hence, it works fine.