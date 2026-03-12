# Multithreaded Java Web Server

![Java](https://img.shields.io/badge/Language-Java-blue)
![HTTP](https://img.shields.io/badge/Protocol-HTTP-green)
![Backend](https://img.shields.io/badge/Type-Backend%20Project-orange)
![Concurrency](https://img.shields.io/badge/Architecture-Multithreaded-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A lightweight **HTTP web server built from scratch using Java sockets and multithreading**.

This project demonstrates how web servers handle **client requests, parse HTTP messages, serve static content, and process API routes concurrently using a thread pool**.

The server also supports **basic REST-style API endpoints, request logging, and benchmarking for concurrent performance testing**.

---

## 🚀 Features

* Custom HTTP server implementation using **Java sockets**
* **Multithreaded request handling** using a thread pool
* HTTP request parsing (method, path, headers)
* Static file serving (HTML, CSS)
* REST-style API endpoints
* Request logging system (`server.log`)
* Error handling for **404 Not Found**
* Performance benchmarking support
* Modular project architecture

---

## 🏗 Architecture

```id="5oqlcb"
Client (Browser)
        ↓
    ServerSocket
        ↓
   Thread Pool
        ↓
   ClientHandler
        ↓
     HttpParser
        ↓
 Route Handler / Static Files
        ↓
    HTTP Response
```

Each client request is handled by a **separate worker thread** from the thread pool.

---

## 📂 Project Structure

```id="lwn0ea"
multithreaded-java-web-server
│
├── benchmark
│   └── benchmark-test.txt
│
├── public
│   ├── index.html
│   └── style.css
│
├── src
│   ├── server
│   │   ├── HttpServer.java
│   │   ├── ClientHandler.java
│   │   └── HttpParser.java
│   │
│   └── utils
│       └── Logger.java
│
├── assets
│   ├── server-homepage.png
│   ├── api-time-response.png
│   ├── api-status-response.png
│   ├── terminal-server-running.png
│   └── benchmark-test.png
│
├── server.log
├── README.md
└── .gitignore
```

---

## 🌐 Supported Routes

| Route         | Description                 |
| ------------- | --------------------------- |
| `/`           | Homepage                    |
| `/style.css`  | Static CSS file             |
| `/api/time`   | Returns current server time |
| `/api/status` | Returns server status       |

Example response:

```id="s0mtrv"
GET /api/time

{
  "time": "2026-03-12T20:10:11"
}
```

---

## 🖥 Screenshots

### Homepage

![Homepage](assets/server-homepage.png)

### API Time Endpoint

![API Time](assets/api-time-response.png)

### API Status Endpoint

![API Status](assets/api-status-response.png)

### Server Running in Terminal

![Terminal](assets/terminal-server-running.png)

### Benchmark Test

![Benchmark](assets/benchmark-test.png)

---

## ⚙️ Running the Server

### Compile the project

```id="g1qg1d"
javac -d out src/server/*.java src/utils/*.java
```

### Run the server

```id="8qmqf3"
java -cp out server.HttpServer
```

### Open in browser

```id="10nddu"
http://localhost:8080
```

---

## 📊 Performance Benchmark

The server was tested using **Apache Benchmark**.

Command used:

```id="u25b2r"
ab -n 1000 -c 50 http://localhost:8080/
```

Example results:

```id="ie8nsq"
Concurrency Level:      50
Time taken for tests:   2.34 seconds
Complete requests:      1000
Failed requests:        0
Requests per second:    426.3 [#/sec]
```

This demonstrates the server’s ability to **handle multiple concurrent requests efficiently using a thread pool architecture**.

---

## 🧠 Concepts Demonstrated

* Socket programming
* HTTP protocol basics
* Multithreading
* Thread pool management
* Backend request routing
* Static file serving
* Logging systems
* Performance benchmarking

---

## 🔮 Future Improvements

* Support for **HTTP POST requests**
* JSON request parsing
* Middleware support
* File caching
* HTTPS support
* Dynamic routing

---

## 👨‍💻 Author

**Sahil Singh**

B.Tech Information Technology
Galgotias College of Engineering and Technology

GitHub
https://github.com/sahilsingh78
