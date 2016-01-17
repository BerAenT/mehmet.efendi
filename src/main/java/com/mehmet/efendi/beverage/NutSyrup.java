package com.mehmet.efendi.beverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NutSyrup extends BlendDecorator {

	private static Logger LOGGER = LoggerFactory.getLogger(NutSyrup.class);

	public NutSyrup(Beverage beveraga) {
		this.beverage = beveraga;
		LOGGER.debug("Nut Syrup added for {} ", this.beverage.ingredients);
	}

	Beverage beverage;

	@Override
	public String getIngredients() {
		return beverage.getIngredients() + " + Nut Syrup ";
	}

	@Override
	public float cost() {
		return beverage.cost() + 3.0f;
	}

}
