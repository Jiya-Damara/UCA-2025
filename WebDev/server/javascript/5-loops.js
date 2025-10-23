var numArray1 = [9, 8, 7, 6, 5];

// 1. for loop
for (let i = 0; i < numArray1.length; i++) {
    console.log(`The value is : ${numArray1[i]}`);
}

// 2. for loop with break
for (let i = 0; i < numArray1.length; i++) {
  if (i === 3) break;
  console.log(`The value is : ${numArray1[i]}`);
}

// 3. for loop with continue
for (let i = 0; i < numArray1.length; i++) {
  if (i === 3) continue;
  console.log(`The value is : ${numArray1[i]}`);
}

// 4. for...in loop
// for in loop with continue
for (let i in numArray1) {
  if (numArray1[i] === 7) continue;
  console.log(`The value is : ${numArray1[i]}`);
}

var studentObject1 = { // obj -> key-value pairs
  firstName: "fName",
  lastName: "lname",
  rollno: 1236544,
  collegeName: "Chitkara University",
};

// for in loop for objects
for (let i in studentObject1) {
  console.log(`The value is : ${studentObject1[i]}`);
}

// in for...in loop, i represents the index (for arrays) or key (for objects)

// 5. for...of loop for Arrays
// Directly access the values
for (let numArrayItem of numArray1) {
  if (numArrayItem === 7) continue;
  console.log(`The value is : ${numArrayItem}`);
}

// 6. forEach loop
// u pass a callback function to forEach method
var actualFunction = function(value) {
    console.log(`The value is : ${value}`);
}

// numArray1.forEach(callbackFunction(value));
// way 1 - named function
numArray1.forEach(actualFunction);
// numArray1.forEach(actualFunction(value)); -> incorrect (Calls the function immediately instead of passing it as a callback)

// way 2 - anonymous function
numArray1.forEach(function(value, index, numArray1) {
    console.log(`The value is : ${value}`);
    console.log(`The index is : ${index}`);
    console.log(`The array is : ${numArray1}`);
});

// way 3 - arrow function
numArray1.forEach((value) => {
    console.log(`The value is : ${value}`);
});

// 7. map
numArray1.map((value) => {
    if (value === 8) {

    } else return value * 2;
});

// The difference b/w forEach & map
// forEach does not return a new array, it just executes the provided function once for each array element
// map returns a new array with the results of calling a provided function on every element in the calling array

// ✅ Core Difference Between forEach() and map()

// Purpose	      
// forEach() - To iterate over each element and perform some operation (like logging, updating UI, pushing to another array, etc.)	
// To transform each element and create a new array with the transformed results

// Return Value	
// forEach() - ❌ Returns undefined	
// map() - ✅ Returns a new array

// Mutates Original Array?	
// forEach() - Only if you modify elements manually inside it	
// map() - ❌ Never — it returns a new array instead

// Callback Function	
// forEach() - Executes for each element	
// map() - Executes for each element

// Typical Use Case	
// forEach() - Performing side effects like printing, updating DOM, saving to DB	
// map() - When you need a new array of processed results


// 🧩 Think of it like this:
// forEach = “Do something for every item.” (like a helper)
// map = “Create a new version of this array.” (like a transformer)

// 🔁 Common in both:
// Both take a callback function with (value, index, array) parameters.
// Both execute the callback once for every element.
// Neither changes the array length.