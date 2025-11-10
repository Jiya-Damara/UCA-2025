// Conditional (Ternary) Operator

const isLoggedIn = false;
const message = isLoggedIn ? "Welcome back!" : "Please log in.";
console.log(message); // Output: Please log in.


// Optional Chaining Operator - to access nested object properties safely

const user = {
    name: "Alice",
    address: {
        city: "Wonderland"
    }
};
user.address.country; // This will throw an error if address is undefined
// Using optional chaining to avoid error
user.address?.country;
console.log(country); // Output: undefined


// Nullish Coalescing Operator - to provide default values for null or undefined

var firstName; // undefined
var lastName = null;
var username;
var displayName = firstName ?? lastName;
var displayName = username ?? "Guest";

var displayName = firstName ?? lastName ?? username ?? "Guest";
console.log(displayName); // Output: Guest

// left hand side if valid value (not null or undefined) then it will be assigned otherwise right hand side value will be assigned

