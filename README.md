# GRpc + Protobuf SpringBoot-Based App Sample

## Server

1 Add the following Maven dependencies

        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-netty</artifactId>
            <version>1.0.1</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-protobuf</artifactId>
            <version>1.0.1</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-stub</artifactId>
            <version>1.0.1</version>
        </dependency>

        <dependency>
            <groupId>org.lognet</groupId>
            <artifactId>grpc-spring-boot-starter</artifactId>
            <version>0.0.7</version>
        </dependency>`
`
2. Maven repository needed

`
    <repositories>
        <repository>
            <id>jcenter</id>
            <url>https://jcenter.bintray.com/</url>
        </repository>
    </repositories>
`

3. Create .proto file for request, response and service(s) IDL. Keep the
generated files separate

4. Annotate your server implementation classes with @GRpcService. 
A server will be auto-configured and services will be auto-registered.

5. Run maven build to generate server and client stubs.


## Client
