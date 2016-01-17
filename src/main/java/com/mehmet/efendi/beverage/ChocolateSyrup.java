package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChocolateSyrup extends BlendDecorator {

	private static Logger LOGGER = LoggerFactory.getLogger(ChocolateSyrup.class);

	public ChocolateSyrup(Beverage beverage) {
		this.beverage = beverage;
		LOGGER.debug("Chocolate Syrup added for {} ", this.beverage.ingredients);
	}

	Beverage beverage;

	@Override
	public String getIngredients() {
		return beverage.getIngredients() + " + Chocolate Syrup ";
	}

	@Override
	public float cost() {
		return beverage.cost() + 5.0f;
	}

}
