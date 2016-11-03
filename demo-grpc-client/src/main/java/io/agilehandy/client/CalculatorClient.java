package io.agilehandy.client;

import io.agilehandy.grpc.gen.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by hxm3459 on 11/2/16.
 */
@Service
public class CalculatorClient implements InitializingBean {

    @Value("${grpc.host}")
    String host;

    @Value("${grpc.port}")
    int port;

    private ManagedChannel channel = null;
    private CalculatorGrpc.CalculatorBlockingStub blockingStub = null;
    private CalculatorGrpc.CalculatorStub asyncStub = null;


    public CalculatorClient() {}

    @Override
    public void afterPropertiesSet() throws Exception {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        blockingStub = CalculatorGrpc.newBlockingStub(channel);
        asyncStub = CalculatorGrpc.newStub(channel);
    }

    public void add() {
        CalculatorResponse response = blockingStub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(12)
                .setNumber2(10)
                .setOperation(CalculatorRequest.OperationType.ADD)
                .build());
        System.out.println("12 + 10 = " + response);
    }

    public void subtract() {
        CalculatorResponse response = blockingStub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(80)
                .setNumber2(20)
                .setOperation(CalculatorRequest.OperationType.SUBTRACT)
                .build());
        System.out.println("80 - 20 = " + response);
    }

    public void multiply() {
        CalculatorResponse response = blockingStub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(12)
                .setNumber2(3)
                .setOperation(CalculatorRequest.OperationType.MULTIPLY)
                .build());
        System.out.println("12 * 3 = " + response);
    }

    public void divide() {
        CalculatorResponse response = blockingStub.calculate(CalculatorRequest.newBuilder()
                .setNumber1(12)
                .setNumber2(3)
                .setOperation(CalculatorRequest.OperationType.DIVIDE)
                .build());
        System.out.println("12 / 3 = " + response);
    }

}
