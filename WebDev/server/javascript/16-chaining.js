// Method chaining is when a function returns an object,
// The returned object has at least one property that is a function,
//  allowing you to call another function on that object.

// Key idea: “return an object with methods so you can keep calling them in a chain.”
// This can continue for multiple calls, creating a chain of method calls.

// Chaining example - Implementation 1
function customString1(initialValue) {
    this.value = initialValue;

    this.infiniteConcat = function(stringToConcat) {
        return {
            value: this.value + " " + stringToConcat,
            infiniteConcat: this.infiniteConcat,
        };
    };
}
var result1 = new customString1("Hello")

// Chaining example - Implementation 2 - Modifies original string object
function customString2(initialValue) {
  this.value = initialValue;

  this.infiniteConcat =  function(stringToConcat) {
    this.value  = this.value + " " + stringToConcat;
    return this;
  }
}

// Chaining example - Implementation 3 - Doesn't modify original string object
function customString3(initialValue) {
  this.value = initialValue;

  this.infiniteConcat =  function(stringToConcat) {
    let newValue  = this.value + " " + stringToConcat;
    return new customString3(newValue);
  }
}

var x = new customString3("hello");
x.infiniteConcat("world");