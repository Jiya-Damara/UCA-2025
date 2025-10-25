// Class in js
// Classes are just the syntactical sugar over the existing prototype-based inheritance 
// and constructor functions in JavaScript.

// classes are not hoisted like function
// classes are just like functions and can be passed as parameters to other functions
// classes are just a function and can be returned from other functions

// transpiler - babel - convert the code that is not supported by browser to supported code like converting class to constructor function
// TypeScript is a superset of JavaScript and its compiler (tsc) works as a transpiler that turns TypeScript into plain JavaScript.


/**
 * ES6
 *  Class specifciation
 *   - constructor
 *   - inheritance
 */

// Problem
//   - Frameworks implemented class based approeach much earlier the popular frameworks like react, angular, vue
//  - Browser could not understand class

// Class based Approach
class Student {
    constructor(name, obtainedMarks) {
        this.name = name;
        this.obtainedMarks = obtainedMarks;
    }

    checkResult(){
        let percentage = (this.obtainedMarks / maxMarks) * 100;
        if (percentage >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
}

var student5 = new Student("White", 90);
student5.checkResult(); // "Pass"

// Constructor fnc ke andar walle fnc prototype mai add nhi hote
// ES6 puts restriction on class so that fnc are added to prototype
// As constructor fnc are wrapper on fnc, similarly class is wrapper on constructor fnc
