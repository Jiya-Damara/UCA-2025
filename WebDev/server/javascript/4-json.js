// JSON - JavaScript Object Notation
var studentObject = {
  firstName: "fName",
  lastName: "lname",
  rollno: 1236544,
  collegeName: "Chitkara University",
};

// Converting JavaScript Object to JSON String
JSON.stringify(studentObject);

// Converting JSON String back to JavaScript Object
var studentJSONString = JSON.stringify(studentObject);
JSON.parse(studentJSONString); 

// Incorrect way - storing object directly in localStorage
localStorage.setItem("studentData", studentObject);
localStorage.getItem("studentData"); // [object Object] - not useful

// localStorage can only store data in string format

// Correct way - using JSON methods
localStorage.setItem("studentData", JSON.stringify(studentObject));
localStorage.getItem("studentData"); // JSON String
// {"firstName":"fName","lastName":"lname","rollno":1236544,"collegeName":"Chitkara University"}


// Data is usually in form of Object -> transmit from C->S ans S->C in form of JSON String -> dubara convert to Object

// Think of JSON.stringify() as packing your data into a box (string form 📦)
// and JSON.parse() as unpacking it (object form 🧩).
// The localStorage is like a locker — it only stores boxes (strings).