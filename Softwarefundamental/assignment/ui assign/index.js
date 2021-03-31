// installed uniq package using npm i uniq

let uniq = require('uniq');
let number=[11,22,3,3,4,1,4,5];
console.log(uniq(number));

// package express

let express = require('express');
let app = express();
var port = process.env.PORT || 3000 ; 
app.get('/', function (req, res) {
    res.send('Hello asss')
  })
app.listen(port , ()=> { console.log('Runing on port',port);});

// run using --> nodemon index.js 
// run using --> node index.js