var sha256 = require('js-sha256');
const http = require('http');
const port = process.env.PORT || 3000;

const server = http.createServer((req, res) => {
  res.statusCode = 200;

  const start = Date.now();

  for(var i = 0; i < 1000000; i++){
    var hash = sha256.create();
    hash.update('aaaaaaaaaa');
    //console.log(hash.hex() + '\n')
  }

  const millis = Date.now() - start;
  res.end(`microseconds elapsed = ${millis*1000}`);
});

server.listen(port, () => {
  console.log(`Server running on http://localhost:${port}/`);
});
