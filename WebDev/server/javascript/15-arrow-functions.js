// Arrow Functions
// Can only be defined using function expressions

// this keyword behaves differently in arrow functions compared to regular functions
// In Normal functions, this refers to the object that called the function; unreliable as scope change ke sath this bhi change hota hai

// In Arrow functions, this points to object where it is defined; reliable as scope change hone par bhi this change nahi hota
// Arrow functions have nothing of their own, inherit everything from their parent scope

function studentFunction(name, marks) {
    console.log(this);
    this.name = name;
    this.marks = marks;

    // Normal function
    this.checkResultNormal = function() {
        console.log(this);
        function InnerFunction() {
            console.log("Normal Inner function: ", this);
        }
        InnerFunction();
    };

    // Arrow function
    this.checkResultArrow = () => {
        console.log(this);
        innerFunction = () => {
            console.log("Arrow Inner function: ", this);
        };
        innerFunction();
    };
}

var student1 = new studentFunction("Alice", 85);
student1.checkResultNormal(); // 'this' inside InnerFunction refers to global object (or undefined in strict mode)
student1.checkResultArrow(); // 'this' inside innerFunction refers to student1 object   


// 🔹 1️⃣ this in normal functions

// In a normal function, this depends on how the function is called, not where it is defined.
// If called as a method of an object, this points to that object.
// If called as a plain function (not as a method), this points to:
// global object in non-strict mode (window in browser, global in Node)
// undefined in strict mode

// 🔹 2️⃣ this in arrow functions

// Arrow functions do not have their own this.
// They inherit this from their parent scope (lexical this), i.e., where they are defined.
// No matter how you call an arrow function later, its this always points to the outer scope’s this.