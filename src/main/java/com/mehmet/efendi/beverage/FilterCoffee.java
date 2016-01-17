package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterCoffee extends Beverage{

	private static Logger LOGGER = LoggerFactory.getLogger(FilterCoffee.class);
	public FilterCoffee() {
		ingredients = "Filter Coffee";
		LOGGER.debug("Beverage {} ordered",ingredients);
	}

	@Override
	public float cost() {
		return 5.0f;
	}

}
