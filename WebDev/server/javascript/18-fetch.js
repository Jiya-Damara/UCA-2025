//fetch is a built-in function in JavaScript that is used to make network requests. It is based on Promises and provides a more powerful and flexible way to make asynchronous requests compared to the older XMLHttpRequest object.
//it is used for making API calls to get or send data to a server.
//fetch returns a Promise that resolves to the Response object representing the response to the request.

var x = fetch("http://localhost:8080/data");

x.then((response) => {
    console.log("Response is "+response)
})

//XMLHTTPRequest
//We want to see Promise use cases
//The primary use case of Promise is to handle asynchronous operations
//One of the most common asynchronous operation in web development is making network requests
//the network requests are basically made to fetch some data from servers
//we will see how XMLHttpRequest constructor function is used to make network requests and "fetch" custom implementation using this XMLHttpRequest

var xmlHTTPRequest1 = new XMLHttpRequest(); //XMLHttpRequest is a built-in constructor function in JavaScript
xmlHTTPRequest1.open('GET', 'http://localhost:8080/data'); //open method is used to initialize a request. It takes two arguments, the first is the HTTP method and the second is the URL of the resource to be fetched.
xmlHTTPRequest1.send(); //send method is used to send the request to the server. It takes no arguments.

xmlHTTPRequest1.onreadystatechange = function() { //onreadystatechange is an event handler that is called whenever the readyState property of the XMLHttpRequest object changes.
    if (xmlHTTPRequest1.readyState === 4) { //readyState property holds the status of the XMLHttpRequest. It takes values from 0 to 4. 4 means the request is complete.
        console.log(xmlHTTPRequest1.responseText); //responseText property holds the response data as a string.

    }
}  


function customFetch(url) {
    return new Promise((resolve, reject) => {
       var xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.send();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                console.log("Response received from server is: ", xhr.responseText);
                resolve(xhr.responseText); //resolve the promise with the response data
            }
        };
    }
    );
}

var data = customFetch('http://localhost:8080/data');