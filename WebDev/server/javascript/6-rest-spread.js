// 🚀 1. The Spread Operator (...)
// ✨ Definition:
// The Spread Operator takes an iterable (like an array, string, or object) and spreads its elements/properties into another array, function call, or object.

// 🧠 Think of it like:
// “Unpacking” or “Expanding” values out of an array or object.

// 📚 Examples: 
// 1) Combining Arrays
var arr1 = [1, 2, 3];
var arr2 = [4, 5, 6];
var combined = [...arr1, ...arr2];

// 2) Copying Arrays
var original = ['a', 'b', 'c'];
var copy = [...original];

// Both are same
var arr1 = new Array(...[1,2,3]);
var arr2 = new Array(1,2,3);

// Differentiate between
var arr3 = new Array(3); // Creates an array with 3 empty slots
var arr4 = new Array(...[3]); // Creates an array with a single element: [3]

// 3) Using Spread in Function Calls
function sum(x, y, z) {
  return x + y + z;
}
const nums = [1, 2, 3];
console.log(sum(...nums)); // Outputs: 6

// 4) Merging Objects
var studentObjDetail1 = { name: "name1", age: 20 };
var studentObjDetail2 = { rollno: 10000025, marks: 900 };

var studentObjDetails = { ...studentObjDetail1, ...studentObjDetail2 };

// 5) Spreading Strings
const str = "Hello";
const letters = [...str]; // ['H', 'e', 'l', 'l', 'o']


// 🌪 2. The Rest Operator (...)
// ✨ Definition:
// The Rest Operator collects multiple elements and packs them into a single array or object.

// 🧠 Think of it like:
// “Gathering” leftover elements into a single variable.

// 📚 Examples: 
// 1) Rest in Function Parameters
function sumAll(...numbers) {
    let sum = 0;
    for (let num of numbers) {
        sum += num;
    }
    return sum;
}
console.log(sumAll(1, 2)); // Outputs: 3
console.log(sumAll(1, 2, 3, 4)); // Outputs: 10 (works dynamically with any number of arguments)

// 2) Rest with Fixed Parameters
function introduce(name, age, ...hobbies) {
    console.log(`Name: ${name}`);
    console.log(`Age: ${age}`);
    console.log(`Hobbies: ${hobbies}`);
}
introduce("Jiya", 20, "Reading", "Traveling", "Swimming");

// 3) Rest in Array Destructuring
const arr = [1, 2, 3, 4, 5];
const [first, second, ...rest] = arr;
console.log(first);  // Outputs: 1
console.log(second); // Outputs: 2
console.log(rest);   // Outputs: [3, 4, 5]

// 4) Rest in Object Destructuring
const student = { name1: "name1", age: 20, rollno: 10000025, marks: 900 };
const { name1, age, ...otherDetails } = student;
console.log(name1);         // Outputs: name1
console.log(age);          // Outputs: 20
console.log(otherDetails); // Outputs: { rollno: 10000025, marks: 900 }
