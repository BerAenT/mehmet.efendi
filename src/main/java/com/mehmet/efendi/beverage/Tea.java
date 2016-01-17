package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tea extends Beverage {
	private static Logger LOGGER = LoggerFactory.getLogger(Tea.class);

	public Tea() {
		ingredients ="Tea";
		LOGGER.debug("Beverage {} ordered",ingredients);
	}
	
	@Override
	public float cost() {
		return 3.0f;
	}

}
