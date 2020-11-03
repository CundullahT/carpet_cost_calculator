package com.carpet_cost_calculator.calculator;

import com.carpet_cost_calculator.enums.City;
import com.carpet_cost_calculator.interfaces.carpetPrices.Carpet;
import com.carpet_cost_calculator.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Qualifier("carpetTX")
    @Autowired
    private Carpet carpetTX;

    @Qualifier("carpetVA")
    @Autowired
    private Carpet carpetVA;

    @Qualifier("bedroom")
    @Autowired
    private Floor floorBedroom;

    @Qualifier("kitchen")
    @Autowired
    private Floor floorKitchen;

    @Qualifier("livingRoom")
    @Autowired
    private Floor floorLivingRoom;

    public String getTotalCarpetCost(City city, String floor) throws Exception {

        BigDecimal cost = getState(city).getSqFtPrice(city).multiply(getFloor(floor).getArea());

        if(cost.compareTo(BigDecimal.ZERO) == 0){
            throw new Exception("This city does not exist");
        }

        return "Total Cost for Carpet : " + cost;

    }

    public Carpet getState(City city){

        while(true){

            if(city == City.MCLEAN || city == City.ARLINGTON || city == City.FAIRFAX){
                return carpetVA;
            }else if(city == City.DALLAS || city == City.AUSTIN || city == City.SAN_ANTONIO){
                return carpetTX;
            }

        }

    }

    public Floor getFloor(String floorStr){

        while (true){

            switch (floorStr.toLowerCase().replace(" ","")){

                case "bedroom":
                    return floorBedroom;
                case "kitchen":
                    return floorKitchen;
                case "livingroom":
                    return floorLivingRoom;

            }

        }

    }

}
