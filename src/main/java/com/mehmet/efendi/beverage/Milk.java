package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Milk extends BlendDecorator {

	private static Logger LOGGER = LoggerFactory.getLogger(Milk.class);

	public Milk(Beverage beverage) {
		this.beverage = beverage;
		LOGGER.debug("Milk  added for {} ", this.beverage.ingredients);
	}

	Beverage beverage;

	@Override
	public String getIngredients() {
		return beverage.getIngredients() + " + Milk ";
	}

	@Override
	public float cost() {
		return beverage.cost() + 2.0f;
	}

}
