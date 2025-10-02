// server setup karre hai - means hum services setup krre jo backend pr kaam karega, we dont have identifier for a service just can identify using port number ke we have to tell ke iss networking service ko iss port pr start karo
// node.js acting like a runtime environment for javascript, so we can run js code on server side

var express = require('express'); // imports express.js 
var app = express(); // 

var port = 8080;

app.use(express.static('frontend')); // koi bhi request aagi of type static, the server will look for the result in the 'frontend' directory

// agar listen is successful then callback fnc is executed
app.listen(port, function() {  // callback fnc andar wala 
    console.log('Server is running on http://localhost:' + port);
})

// Localhost - it is the current machine that is running the server, it is a loopback address that points to the same machine.