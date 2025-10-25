// Object Literals
// Literal -> obvious way ke wo ek object hai 
// String literal - "", object literal - {}
var objUsingLiteral = { 
    name : "Jiya",
    age : 21,
    isStudent : true,
    skills : ["HTML", "CSS", "JS"],
    address : {
        street : "123 Main St",
        city : "Chandigarh",
        country : "India"
    },
    greet : function() {
        console.log("Hello, " + this.name);
    }
};
// inside object there will be key-value pairs(properties)
// value can be of any data type - string, number, boolean, array, object, function

// new Object()
var objUsingNewObject1 = new Object(); // empty object
var objUsingNewObject2 = new Object({name : "Dollar"});

// Object.assign - using existing objects to create new objects
// 1st argument - target, 2nd, 3rd, ... - source objects
var objUsingAssign1 = Object.assign({}, objUsingNewObject2); // source se target me copy

var objUsingAssign2 = Object.assign({college : "Chitkara"}, objUsingNewObject2);
var objUsingAssign3 = Object.assign(objUsingNewObject2, {college : "Chitkara"}); // modifies objUsingNewObject2

// Objects in Js are pass by reference
var obj1 = {name : "Hello"};
var obj2 = obj1; // Just a pointer/reference copy, modifying obj2 will modify obj1

var obj3 = new Object(obj1); // only reference copied
// obj1 === obj3 -> true

// Object.create - prototype based object creation
var objUsingCreate = Object.create(obj3); // obj4 is the prototype of objUsingCreate
// obj3 === objUsingCreate -> false

var obj4 = {name : "Test"};
Object.prototype === obj4.__proto__; // true

// Actual new objects are created when -
// {} is used
// ... Spread operator is used

// Prototypical inheritance
objUsingCreate.__proto__ === obj3; // true as this points to parent prototype's properties
objUsingCreate.__proto__.__proto__ === Object.prototype; // true as Object.prototype is the top level prototype (same as obj3.__proto__)

// kissi bhi existing data type me hum properties and methods add kar sakte hain
String.prototype.customMethod = function() {
    return "This is a custom method for string: " + this;
}

// it would be same as
str1.__proto__.customMethod = function() {
    return "This is a custom method for string: " + this;
}
// str1 ke __proto__ mai add karne se bhi sabhi string ke liye ye method available ho jayega

// Prototype chaining
var parentObj = {
    parentProp : "I am parent property",
    parentMethod : function() {
        return "I am parent method";
    }
};
var childObj = Object.create(parentObj); // parentObj is prototype of childObj

// Prototype Definition - defined set of rules for creating objects of similar type (structure/ behavior/ functionality)
// // -> behavior ko generalise karne ke liye (behavior sharing) layout/ interface/ data format formalise karne ke liye wohi value dalen jo chahiye, nahi kuch bhi

var arr1 = new Array();
Array.prototype === arr1.__proto__; // true
arr1.length; // pehle kudh ke __proto__ mai dekhta hai, fir uske baad parent ke prototype mai dekhta hai
// arr1 ke __proto__ mai length property nahi hai, toh Array.prototype mai dekhega jaha ye property defined hai
// keep on checking on the top level (Prototype Inheritance)