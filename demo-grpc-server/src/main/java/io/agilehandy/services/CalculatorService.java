package io.agilehandy.services;


import io.agilehandy.grpc.gen.CalculatorGrpc;
import io.agilehandy.grpc.gen.CalculatorRequest;
import io.agilehandy.grpc.gen.CalculatorResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * Created by hxm3459 on 11/2/16.
 */
@GRpcService
public class CalculatorService extends CalculatorGrpc.CalculatorImplBase {

    @Override
    public void calculate(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {
        CalculatorResponse.Builder resultBuilder = CalculatorResponse.newBuilder();
        switch (request.getOperation()){
            case ADD:
                resultBuilder.setResult(request.getNumber1()+request.getNumber2());
                break;
            case SUBTRACT:
                resultBuilder.setResult(request.getNumber1()-request.getNumber2());
                break;
            case MULTIPLY:
                resultBuilder.setResult(request.getNumber1()*request.getNumber2());
                break;
            case DIVIDE:
                resultBuilder.setResult(request.getNumber1()/request.getNumber2());
                break;
            case UNRECOGNIZED:
                break;
        }
        responseObserver.onNext(resultBuilder.build());
        responseObserver.onCompleted();


    }



}
