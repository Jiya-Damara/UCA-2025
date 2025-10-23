// function foo() {
//     console.log("Hello, World!");
// }
// foo(); // function call ke bina nhi chalega

// Self invoking function is available in JavaScript - > Haevily used in making of frameworks and libraries
// (function() {
//     console.log("Hello, World!");
// })();

function foo() {
    console.log("Hello, World!");
    // 1 document.getElementById("tag1").innerHTML = "Content Updated - Hello From JavaScript!!"; // head mai hai toh tab tak ele mila hi nhi toh change nhi kara. as js pehle load hota hai = returns NULL (used to denote nothing)
        // document.getElementById - returns obj. Now its properties(methods of objs) (null.innerHTML) can't be set - runtime error

    // 2 document.getElementById("tag1")?.innerHTML = "Content Updated - Hello From JavaScript!!"; // should add ? taki exception ki wajah se aage execution na ruk jaye - compile time error toh iski parsing mai fail, js ko execute hi nhi krne dera as browser ko pata chala ke yeah part kabhi nakabhi NULL ho sakta hai
    // Browser mai pehle parse karte js and then execute 

    document.getElementById("tag1").innerHTML = "Content Updated - Hello From JavaScript!!";
//     console.log(document.getElementById("tag2").innerHTML); // error dega
//     console.log(document.getElementById("tag2").innerHTML); // undefinedx dikhaega
}

//foo();

setTimeout(() => { // defining a func
    console.log("Delayed Message");
}, 2000); // call the func itself after 2sec

setTimeout(foo, 5000); // 1st parameter is function definition, 2nd id time