// var promise = new CustomPromise(promiseExecutor);

// Simple Promise with constructor function
// Simple Promise with resolve and reject
// Simple Promise with additional then and catch methods

// STEP 1 
function customPromiseExecutor() {
    setTimeout(() => {
        console.log("Promise 1 executed");
    }, 5000);
}

function PromiseCustom(executor) {
    this.state = "pending"; // start state is pending
    executor();
}

var customPromise1 = new PromiseCustom(customPromiseExecutor);


// STEP 2
function customPromiseExecutor(resolve, reject) {
    // Asynchronous operation
    setTimeout(() => {
        console.log("Promise 1 executed");
        resolve("Promise 1 resolved successfully"); // .then and .catch se jo aaega usko override karega
        // reject("Promise 1 rejected with some error");
    }, 5000);
}

function PromiseCustom(executorFncArg) {
    this.state = "pending";
    executorFncArg((responseArg) => { // callback fnc
        this.state = "fulfilled";
    }, (errorArg) => {
        this.state = "rejected";
    });
}

var customPromise1 = new PromiseCustom(customPromiseExecutor);


// STEP 3
function customPromiseExecutorFnc(resolve, reject) {
    setTimeout(() => {
        console.log("Promise 1 executed");
        resolve("Promise 1 resolved successfully");
        // reject("Promise 1 rejected with some error");
    }, 5000);
}

function PromiseCustom(executorFncArg) {
    this.state = "pending";
    let successCallback;
    let failureCallback;
    this.then = function(callback) { // this.then is a fnc that accepts callback function
        successCallback = callback; // saving ref of this callback function in variable
    };
    this.catch = function(callback) {
        failureCallback = callback;
    };

    executorFncArg((responseArg) => { // defined in resolve part of fnc; usually resolve and reject ki definition .then and catch mai hoti hai, this is slight override
        this.state = "fulfilled";
        successCallback(responseArg); // calling the callback function
    }, (errorArg) => {
        this.state = "rejected";
        failureCallback(errorArg); // failureCallback is method defined in catch
    });
}

// NOTE : .then and .catch are basically used to fetch values from resolve and reject which cant be fetched otherwise


var customPromise1 = new PromiseCustom(customPromiseExecutorFnc);

customPromise1.then((resolvedValue) => {
    alert("Promise resolved with value: " + resolvedValue);
});
customPromise1.catch((rejectedValue) => {
    alert("Promise rejected with value: " + rejectedValue);
});

