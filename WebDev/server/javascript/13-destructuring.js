// Destructuring - Breaking down arrays and objects into smaller parts

var arr1 = [1, "Amit", "Garg", { name: "name1", age: 20 }];

// Instead of accessing each element individually
// let id = arr1[0];
// let firstName = arr1[1];
// let lastName = arr1[2];
// let details = arr1[3];
// We can use destructuring to extract values

var [count, firstName, lastName, details] = arr1;

var obj1 = {
  fName: "name1",
  lName: "",
  details: { age: 10, college: "college1" },
};

// Instead of accessing each property individually
// let fName = obj1.fName;
// let lName = obj1.lName;
// let details = obj1.details;
// We can use destructuring to extract values

var {fName, lName} = obj1;

//By default, YES — you must use the same name when destructuring an object, because destructuring works by matching property names, not order.
// If a property might not exist, you can assign a default value while destructuring.