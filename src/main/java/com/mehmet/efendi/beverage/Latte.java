package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Latte extends Beverage {

	private static Logger LOGGER = LoggerFactory.getLogger(Latte.class);
	public Latte() {
		ingredients ="Latte";
		LOGGER.debug("Beverage {} ordered",ingredients);
	}
	@Override
	public float cost() {
		return 5f; 
	}

}
