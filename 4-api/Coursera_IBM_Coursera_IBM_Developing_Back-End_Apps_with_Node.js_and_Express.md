#### Table of Contents
*   [Introduction](#introduction)
*   [Require vs Import Usages](#require-vs-import-usages)


## Introduction
Node.js is a runtime environment that can run server-side JavaScript applications, 
while Express is a server-side JavaScript web framework that runs on top of Node.js 
in which to write your applications.

- learn about server-side development using JavaScript, 
- code your first web server, and 
- use Node Package Manager to manage your application modules and dependencies. 
- explore how to make applications run in a non-blocking manner by using asynchronous callbacks and promises, 
- learn how REST APIs are used in conjunction with HTTP requests and responses with the Express.js framework, and then, 
- practice using Express by building a web server and creating dynamic content with middleware, routing, and templating.

These are the types of servers:
```mermaid
architecture-beta
    group api(cloud)[API]

    service app(internet)[Applications] in api
    service server(server)[Server] in api
    service db(database)[Database] in api

    app:R --> L:db
    db:R --> L:server
```

Event-Driven, Asynchronous, Non-Blocking, Single-Threaded:

Server processes can be categorized as either "single-threaded" or "multi-threaded". 
In a single-threaded environment, only one command is processed at any given time, 
while in a multi-threaded environment, multiple commands can be processed simultaneously. 
Despite being single-threaded, Node.js excels in performance due to its asynchronous and non-blocking nature. 
This means that while a process is being executed, the program does not need to wait until it finishes. 
Node.js is event-driven, meaning that when it performs an input/output (I/O) operation, 
such as reading from the network or accessing a database or file system, an event is triggered. 
Instead of blocking the thread and consuming processor time while waiting, 
Node.js resumes operations when the response is received, or when the corresponding event occurs. 
This non-blocking behavior enables the server to remain responsive and handle multiple tasks concurrently, 
akin to a multi-threaded environment.

Node.js in the same components of the architecture where they use Java, Perl, C++, Python, and Ruby. 

Express.js is a highly configurable framework for building applications on Node.js. It abstracts lower-level APIs in Node.js by using HTTP utility methods and middleware. 

With server-side JavaScript, node applications process and route web service requests from the client. 
In Step 1, the user selects an option in the user interface written in HTML and CSS. 
In Step 2, this action by the user triggers JavaScript code that implements the business logic on the client-side, for example, input validation. 
In Step 3, the JavaScript application makes a web service call over HTTP with a JSON data payload. The REST web service, which is part of a Node.js application running on the Node server, receives the HTTP request. 
In Step 4, the REST web service processes the request and returns the result to the client as a JSON payload over HTTP.

```mermaid
sequenceDiagram
    autonumber
    Web_Browser ->> Node_Server: User selects
    Web_Browser ->> Web_Browser: Javascript code business logic
    Web_Browser ->> Node_Server: Node app route API call
    Node_Server ->> Web_Browser: Response to the client as JSON payload
```

Node and Express in the IDE:

```
\ NodeExpressApp
  |___\ github
  |___\ launchConfiguration
  |___\ public - (2) html/js/css/img/templates/views/public assets
  |___\ scripts
  |___\ server
  |    |___\ config
  |    |___\ controllers
  |    |___\ routes - (3) defines endpoints that accept and process client requests.
  |    |___. server.js - (1) express.js application code:`const app = express()` (2) server.js - a file which contains the main application code.
  |___\ test
  |___. package.json (4) contains metadata information about the project including dependencies
```

Express.js is a framework that helps you build Node.js applications. 


---

## Require vs Import Usages

explain what a module is, 
explain what a module specification is, 
explain the purpose of import and require statements, and 
differentiate between import and require statements. 

In Node.js, modules are files containing related, encapsulated JavaScript code that serve a specific purpose. 

**Modules** can be a single file or a collection of multiple files and folders. Developers rely heavily on modules because of their reusability as well as their ability to break down complex code into manageable chunks. 

When an external application needs to use the code contained in a module the application needs to call that module. When the external application calls a module, the module is called using an `import()` or a `require()` statement. 
Which statement is needed depends on the module specification. 

about module specifications:
A directory with one or more modules bundled together is called a package. Module specifications are the conventions and standards used to create packages in JavaScript code for Node.js applications.
The most commonly used module specifications for Node.js applications are:
1. CommonJS and
2. ES modules.

differences between CommonJS and ES modules. 
By default, Node.js treats JavaScript code as a CommonJS module. 
Library authors can easily enable ES modules in a Node.js package by simply changing the package file extension from dot j-s to dot m-j-s. 
```mermaid
block-beta
  columns 3
  
  CommonJS space:1 ES 
  packagename.js right<[" "]>(right) packagename.mjs

```

CommonJS modules use the require() statement to import modules whereas ES modules use the import() function. When a module is needed outside of its own file it must be exported first. The module.exports statement should be used with CommonJS. Modules can be exported to an ES specification using the “export” keyword. 

|  | CommonJS | ES |
|:--------:|:--------:|:--------:|
| import a module | required() | import() |
| export from a module | module.exports | export |


Differences between require and import within the application code:
The require statement can be called anywhere in the file whereas 
the import statement must be called at the beginning of the file. Since the require statement can be called from anywhere, this means that it can be called within conditional statements and functions, but import cannot. This may sound like an advantage of require but note that the require statement is bound dynamically whereas import is bound statically. This means errors that occur when linking the function definition to the function call will not be identified until run-time. For Import, binding errors are identified at Compile time. Require modules are synchronous in nature and modules imported with import are asynchronous. Synchronous means the modules will be loaded and processed in a linear fashion, one at a time. 
Asynchronous means the modules can be processed simultaneously. Import runs faster compared to require functions in large-scale applications which involve loading hundreds of modules. 

| CommonJS | ES |
|:--------:|:--------:|
| can be called anywhere in the code | can be called at th beginning of the file |
| can be called within conditionals and functions | cannot be called within conditionals or functions |
| Dynamic | Static |
| Binding errors not identified until run-time | Binding errors identified at compile-time
| Synchronous | Asynchronous |


Sample code that shows how to export and import using require and import. Recall that the require statement is used with CommonJS applications. 

This code snippet will show how to export from a file named message dot j-s. We use module dot exports to export the string “Hello programmers” from the message dot j-s module. 
```javascript
//export from a file name message.js
module.exports = 'Hello Programmers';
```
Next, to import the message dot j-s module into the main application, we use the require statement. In this code the result of require is assigned to the let m-s-g, then the variable is logged in the console. 
```javascript
//import from the message.js file
let msg = require('./message.js');
console.log(msg);
```


Now, let’s look at code that exports an ES module from a file named module dot m-j-s. This code names a constant ‘a’ and sets the constant equal to 1. Next, the export statement is used. Note the use of the curly brackets. A is renamed to my value. 
```javascript
//import from file named module.mjs
const a = 1;
export { a as "myalue" };
```

Finally, we look at code to import an ES module using import. 
Simply use the import keyword. We are importing my value from the module.mjs file. 
```javascript
//import from  module.mjs
import { myvalue } from module.mjs;
```

In this video, you learned that a module is a file containing related JavaScript functions that serves a specific purpose. Module specifications are conventions and standards used to create packages in JavaScript code. import and require statements are used to call a module or a package into an external application. The require statement can be called from anywhere in the app code, is bound dynamically, and is synchronous, and the import statement can only be called at the beginning of a file, is bound statically, and is asynchronous. 


