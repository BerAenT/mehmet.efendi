package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mocha extends Beverage {

	private static Logger LOGGER = LoggerFactory.getLogger(Mocha.class);
	public Mocha() {
		ingredients ="Mocha";
		LOGGER.debug("Beverage {} ordered",ingredients);
	}
	@Override
	public float cost() {
		return 6.0f;
	}

}
