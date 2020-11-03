package com.carpet_cost_calculator;

import com.carpet_cost_calculator.calculator.Calculator;
import com.carpet_cost_calculator.enums.City;
import com.carpet_cost_calculator.interfaces.floorTypes.Floor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CarpetCostCalculatorApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext container = SpringApplication.run(CarpetCostCalculatorApplication.class, args);

        Calculator calculator = container.getBean("calculator",Calculator.class);

        City city = getCity();

        String floor = getFloor();

        System.out.println(calculator.getTotalCarpetCost(city, floor));

    }

    public static City getCity(){

        String cityStr;

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("From which city you'll buy?");
            cityStr = scanner.nextLine();

            switch (cityStr.toLowerCase().replace(" ","").replace("_","")){

                case "mclean":
                    return City.MCLEAN;
                case "arlington":
                    return City.ARLINGTON;
                case "fairfax":
                    return City.FAIRFAX;
                case "dallas":
                    return City.DALLAS;
                case "austin":
                    return City.AUSTIN;
                case "sanantonio":
                    return City.SAN_ANTONIO;
                default:
                    System.out.println("Invalid city, please try again.");
                    break;
            }

        }

    }

    public static String getFloor(){

        String floorStr;

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("For which room you'll buy?");
            floorStr = scanner.nextLine();

            switch (floorStr.toLowerCase().replace(" ","")){

                case "bedroom":
                    return "bedroom";
                case "kitchen":
                    return "kitchen";
                case "livingroom":
                    return "livingroom";
                default:
                    System.out.println("Invalid room, please try again.");
                    break;
            }

        }

    }

}
