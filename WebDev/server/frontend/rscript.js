var app = document.getElementById("reactapp");
var root = ReactDOM.createRoot(app);


// root.render(<h1> Hello, world </h1>);  // not html tags, jsx tags (kaam same) (ultimately converted to html by react using babel)


// root.render(DescriptionComponent("Jiya")); // calling a fnc which returns jsx
// react components when used as a fnc it accept only object as argument

root.render(<DescriptionComponent name = "Jiya" />); // calling a fnc which returns jsx - should look like html tag - but yeah custom hai so attributes predefined nhi, it would be passed as props object(the argument)
// Also object ek hi pass kar sakte hai
// function DescriptionComponent(props) {
//     return (
//         <div>
//             <h1> Description for {props.name} </h1> 
//             {/* React element - so fnc should be a react ele - pascal convention methods are only considered as react elements */}
//         </div>
//     );
// }

// {} inside jsx is used to write normal js expressions
// in js we used `` for string interpolation

// function DescriptionComponent({name}) { // Normal js fnc, what is returned is jsx - destructure karsakte hai props ko hatake {} use karke -> Means ya props use karo ya {name} 
// These props are read only - so we cannot modify them. They are identical to function arguments or attributes of HTML tags. (React ne restruction lagadi yeah, js mai nhi hoti)
// // this adds description ke props object me name key hogi jisme "Jiya" value hogi
//     return (
//         <div>
//             {/* <h1> Description for {name} </h1>  */}
//             <h1> Description for {name.toUpperCase() ?? "Guest User"} </h1>
//         </div>
//     );
// }

// To combine multiple ele we use <> </> to wrap it (called React Fragment/ Empty tag) as we can return only one ele from a fnc

// Agar js mai modify kare ya destructured {name} ko karen toh its possible, but not encouraged
// React mai props read only hote hai, so we must not modify them (restriction lagadi hai react ne) - so we can use them like function arguments or html attributes - therefore props objects is immutable (state of the object cannot be changed after it is created) - so we can use them but not modify them
function DescriptionComponent({name}) {
    return (
        <>
            <h1> Description for {name.toUpperCase() ?? "Guest User"} </h1>
            <p> This is a paragraph </p>
        </>
    );
}

function foo(arg1) { // arg1 is parameter so modify karne ke kya zarurat - can be called read only property strictly nhi hai
    console.log(arg1);
}
foo("Test");