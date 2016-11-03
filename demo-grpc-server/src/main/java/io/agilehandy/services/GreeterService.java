package io.agilehandy.services;

import io.agilehandy.grpc.gen.GreeterGrpc;
import io.agilehandy.grpc.gen.HelloReply;
import io.agilehandy.grpc.gen.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * Created by hxm3459 on 11/2/16.
 */
@GRpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request
            , StreamObserver<HelloReply> responseObserver)
    {
        final HelloReply.Builder replyBuilder =
                HelloReply.newBuilder().setMessage("Hello " + request.getName());
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
