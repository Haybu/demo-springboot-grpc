package io.agilehandy.client;

import io.agilehandy.grpc.gen.GreeterGrpc;
import io.agilehandy.grpc.gen.HelloReply;
import io.agilehandy.grpc.gen.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by hxm3459 on 11/2/16.
 */
@Service
public class GreeterClient implements InitializingBean {

    @Value("${grpc.host}")
    String host;

    @Value("${grpc.port}")
    int port;


    private ManagedChannel channel = null;
    private GreeterGrpc.GreeterBlockingStub blockingStub = null;
    private GreeterGrpc.GreeterStub asyncStub = null;


    public GreeterClient() {}

    @Override
    public void afterPropertiesSet() throws Exception {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
        asyncStub = GreeterGrpc.newStub(channel);
    }

    public void greeting() {
        HelloReply reply = blockingStub.sayHello(HelloRequest.newBuilder().setName("Haytham Mohamed").build());
        System.out.println(reply);
    }
}
