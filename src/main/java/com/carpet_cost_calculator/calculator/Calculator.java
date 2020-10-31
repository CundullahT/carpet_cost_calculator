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
    private Carpet carpet;

    @Qualifier("bedroom")
    @Autowired
    private Floor floor;

    public String getTotalCarpetCost(City city) throws Exception {

        BigDecimal cost = carpet.getSqFtPrice(city).multiply(floor.getArea());

        if(cost.compareTo(BigDecimal.ZERO) == 0){
            throw new Exception("This city does not exist");
        }

        return "Total Cost for Carpet : " + cost;

    }

}
