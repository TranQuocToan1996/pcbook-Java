# pcbook-Java

# pcBookgRPC Java
- Special thanks to: [TECH SCHOOL](https://www.youtube.com/@TECHSCHOOLGURU)
- Summary: Server/client to manage and search laptop configurations. It provides 4 gRPC APIs included some unit tests:

1. Create a new laptop: unary gRPC
    Allows client to create a new laptop with some specific configurations.

2. Search laptops with some filtering conditions: server-streaming gRPC
    Allows client to search for laptops that satisfies some filtering conditions.

3. Upload a laptop image file in chunks: client-streaming gRPC
   Allows client to upload 1 laptop image file to the server. The file will be split into multiple chunks, and they will be sent to the server as a stream.

4. Rate multiple laptops and get back average rating for each of them: bidirectional-streaming gRPC
    Allows client to rate multiple laptops, each with a score, and get back the average rating score for each of them.

- [Go version](https://github.com/TranQuocToan1996/go-pcBookgRPC) (Server/client): https://github.com/TranQuocToan1996/go-pcBookgRPC

- First running:
1. Setup SSL/TLS. 
+ Generates certificate/key in cert folder.
+ Config nginx.conf

2. Install dependencies: 
+ Config build.gradle. At root dir, build gradle:
```
make build
```

3. Start gRPC server: run LaptopServer.java.

4. Client calling:
+ gRPC: Use [evans](https://github.com/ktr0731/evans) or clients in Go/Java to call. For the client Java, user may add code to call to gRPC.


- TODO tasks:
1. Connect to Database.
2. Translate gRPC to REST.
3. Add authentication/authorization.
4. Add more unit tests.