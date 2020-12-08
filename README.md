# Prime numbers
This is an example project, utilizing Java, Spring Boot and gRPC. 

The project consists of two services that interact, using gRPC. The client application
exposes an endpoint ``/prime/{max}`` which then calls the server to find all prime numbers
that are lower than the ```max``` provided by the user.


# Quick start
1. Clone the project
2. Run ``mvn spring-boot:run`` for both grpc-client and grpc-server
3. Call endpoint ``http://localhost:8081/prime/10`` to see results

