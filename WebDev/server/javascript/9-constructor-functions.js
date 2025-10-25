// Js mai at core - there are no classes. Classes are created using functions only.
var maxMarks = 100;

// Approach 1 ---------------------------------
// Niche way to create obj -> haar obj ke liye alag se function banana padega, no reusability
var student1 = {
  name: "John",
  obtainedMarks: 95,
  checkResult: function () {
    let percentage = (student1.obtainedMarks / maxMarks) * 100;
    if (percentage >= 40) {
      return "Pass";
    } else {
      return "Fail";
    }
  },
};

student1.checkResult(); // "Pass"

// Approach 2 ---------------------------------
// Using Function
function createStudent(name, obtainedMarks) {
  return {
    name: name,
    obtainedMarks: obtainedMarks,
    checkResult: function () {
      let percentage = (this.obtainedMarks / maxMarks) * 100;
      if (percentage >= 40) {
        return "Pass";
      } else {
        return "Fail";
      }
    },
  };
}

var student2 = createStudent("Doe", 35);
student2.checkResult(); // "Fail"
var student3 = createStudent("Smith", 75);
student3.checkResult(); // "Pass"

// This solves blueprint problem but issue here is this is not a real blueprint
// student2 and student3 ke paas alag alag checkResult functions hain jo memory waste karta hai
// also student2 obj created, then as obj has no link to the method, so class mai koi change hota hai/ function modification in this case, toh obj mai reflect nhi hoga

// Approach 3 ---------------------------------
// Now Optimal Approach using Constructor Functions
var arr1 = new Array();
var thisInsideCreateStudent;
function createStudent(name, obtainedMarks) {
  thisInsideCreateStudent = this;
  this.name = name;
  this.obtainedMarks = obtainedMarks;
  this.checkResult = function () {
    let percentage = (this.obtainedMarks / maxMarks) * 100;
    if (percentage >= 40) {
      return "Pass";
    } else {
      return "Fail";
    }
  };
}

var student4 = new createStudent("Brown", 85);
student4.checkResult(); // "Pass"
var student5 = new createStudent("Davis", 25);
student5.checkResult(); // "Fail"

// A constructor function in Js is a special kinda function which is used to create & initialise objects.
// It acts as a blueprint for creating multiple objects of same type.

// How new Works Internally -When you call a constructor with new:
// 1. A new empty object is created.
// 2. The this keyword inside the constructor function is set to point to this new object. (Operand on left side)
// 3. Properties and methods are added to this new object (using this).
// 4. The new object is returned from the constructor function automatically.

// Constructor Function - Optimised Implementation
function student(name, obtainedMarks) {
  thisInsideCreateStudent = this;
  this.name = name;
  this.obtainedMarks = obtainedMarks;
}

student.prototype.checkResult = function () {
  let percentage = (this.obtainedMarks / maxMarks) * 100;
  if (percentage >= 40) {
    return "Pass";
  } else {
    return "Fail";
  }
};

var student6 = new student("Evans", 90);
student6.checkResult(); // "Pass"
var student7 = new student("Wilson", 30);
student7.checkResult(); // "Fail"
// student ke prototype mai change, toh obj mai reflect hoga (linkage)

// Whenevr JS encounters new keyword, it created a new object. Bind the this keyword to that new object
