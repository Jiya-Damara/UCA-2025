function foo() {
  console.log("Hello, World!");
  if (document.getElementById("tag1")) {
    document.getElementById("tag1").innerHTML =
      "Content Updated - Hello From JavaScript!!";
  }
}

// React - component is a small peice of UI that can be reused - like this js file is for product rendering

var productList = [];
var productListFromServer = [];
function loadProducts(renderProductListTableWithData) {
  // with server - api call - render etc
  setTimeout(() => {
    productList = productListFromServer;
    renderProductListTableWithData();
  }, 2000);
}
// import, export will work jab code is in browser, so right now we are managing all on our own

// const foo2 = (arguments) => {
//   // arrow functions - annonymous functions dont have to name just pass what to do
//   console.log(arguments);
// };

// function foo3(arguments) {
//   console.log(arguments);
// }

var arr1 = [1, 2, 3, 4, 5]; // Js mai kisi bhi array ko render karne ki koshish karenge toh runtime pr wo string mai convert ho jayega
function renderProducts() {
  // debugger - start debugging, can also add end check point
  document.getElementById("tag2").innerHTML = arr1;
  // render the data from server
  // covert the data into HTML and render it on the page

  loadProducts();
  // templete literal `` - add template
  function renderProductListTableWithData() {
    if (productList.length === 0) {
      document.getElementById("data").innerHTML =
        "Loading data from server......";
      return;
    }
    document.getElementById("data").innerHTML = `
    <table>
            <thead>
                <tr>
                    <th> Sr. No. </th>
                    <th> Product Name </th>
                    <th> Price </th>
                    <th> Description </th>
                </tr>
            </thead>
            <tbody>
            ${productList
              .map((product, index) => {
                // jitne products utne baar execute hoga
                return `
                <tr>
                    <td> ${index + 1} </td>
                    <td> ${product.name} </td> 
                    <td> ${product.price} </td> 
                    <td> ${product.description} </td> 
                </tr>
                `;
              })
              .join("")}
            
            </tbody>
        </table>
    `;
  }

  // 2 events - load event, data download event
  loadProducts(renderProductListTableWithData); // this menthod is called back from loadProducts
  renderProductListTableWithData(); // initial render
}

// setTimeout(loadProducts, 2000); // fetch products from backend
// setTimeout(foo, 0);
// setTimeout(loadData, 2000);

renderProducts(); // React mai useEffect hota hai, apne aap dekhta hai

// setTimeout(renderProducts, 2000);

// map function (array. map) accepts an argument which is a fuction definition itself, map returns array.

// callback function is a function that is used as an argument in another function, dekhkr nhi pata nhi chalta, when a fnc is passed as an argument in another fnc in that case it acts like callback fnc
// a fnc is a fnc can't see and tell if its callback, its not a type a fnc, just execution context
// Types of Functions in Js - 2 - normal fnc with function keyword, and arrow fnc also called anonymous fnc

// Browser array ko render karne ke like String mai convert karta hai - thats why we see , in output
// Cumulative Layout Shift (Relatible to Stability in Sorting Algo)
// Blocking Time
// No throttling



// React - jsx - javascript xml
// var app = document.getElementById("reactapp");
// var root = ReactDOM.createRoot(app);
// root.render(<h1> Hello, world </h1>);

// now that we created script.js as module so for this jsx we move it back to index.html