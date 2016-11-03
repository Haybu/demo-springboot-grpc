package io.agilehandy;

import io.agilehandy.client.CalculatorClient;
import io.agilehandy.client.GreeterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoClientApp implements CommandLineRunner {


	GreeterClient greeterClient = null;
    CalculatorClient calculatorClient = null;

    public DemoClientApp (GreeterClient _greeterClient, CalculatorClient _calculatorClient) {
        greeterClient = _greeterClient;
        calculatorClient = _calculatorClient;

    }

	public static void main(String[] args) {
		SpringApplication.run(DemoClientApp.class, args);
	}

	@Override
	public void run(String... strings) throws Exception
    {
		greeterClient.greeting();

        calculatorClient.add();
        calculatorClient.subtract();
        calculatorClient.multiply();
        calculatorClient.divide();
	}
}
