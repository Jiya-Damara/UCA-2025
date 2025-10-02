// Simple Promise
var promise1 = new Promise (() => {
    setTimeout(() => {
        console.log("Promise 1 executed");
    }, 5000);
})


function promiseExecutor() {
    setTimeout(() => {
        console.log("Promise 1 executed");
    }, 5000);
}
// just pass reference of promise1, not calling it
var promise1 = new promise1(promiseExecutor); 
// Api data fetch - promise based we dont know when data will come


// Simple Promise with resolve and reject

// eg - API callback - ask kara ecommerce pr, return hoga product, if no category so it gives 404 not found wo bhi executed hai - fulfilled data return karna (product dikahana ya no category dikhana) - resolved
// agar error - servor down - not able to fulfil promise - rejected - error return karna

// Resolve & Reject method (callback fnc)- Depending on the situation the browser will call resolve or reject

function promiseExecutor(resolve, reject) {
    setTimeout(() => {
        console.log("Promise 1 executed");
        resolve("Promise 1 resolved successfully");
        // reject("Promise 1 rejected with some error");
    }, 5000);
}

var promise1 = new promise1(promiseExecutor); 


// Simple Promise with additional then and catch methods

function promiseExecutor(resolve, reject) {
    setTimeout(() => {
        console.log("Promise 1 executed");
        resolve("Promise 1 resolved successfully");
        // reject("Promise 1 rejected with some error");
    }, 5000);
}

var promise1 = new promise1(promiseExecutor); 

promise1.then((resolvedReturnValue) => {
    alert("Promise resolved with value: " + resolvedReturnValue);
}) // then method takes callback fnc as argument - executed when promise is resolved (internally state change hota hai fulfilled mai)
promise1.catch((rejectedReturnValue) => {
    alert("Promise rejected with value: " + rejectedReturnValue);
}) // catch method takes callback fnc as argument - executed when promise is rejected
