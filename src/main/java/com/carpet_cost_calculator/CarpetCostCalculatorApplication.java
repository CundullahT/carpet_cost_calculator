package com.carpet_cost_calculator;

import com.carpet_cost_calculator.calculator.Calculator;
import com.carpet_cost_calculator.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarpetCostCalculatorApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext container = SpringApplication.run(CarpetCostCalculatorApplication.class, args);

        Calculator calculator = container.getBean("calculator",Calculator.class);

        System.out.println(calculator.getTotalCarpetCost(City.DALLAS));

    }

}
