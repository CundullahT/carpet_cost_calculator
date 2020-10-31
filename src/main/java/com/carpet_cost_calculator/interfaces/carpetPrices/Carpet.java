package com.carpet_cost_calculator.interfaces.carpetPrices;

import com.carpet_cost_calculator.enums.City;

import java.math.BigDecimal;

public interface Carpet {

    BigDecimal getSqFtPrice(City city);

}
