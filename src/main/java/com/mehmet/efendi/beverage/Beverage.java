package com.mehmet.efendi.beverage;

public abstract class Beverage {

	String ingredients = "Unknown Ingredients";

	String getIngredients() {
		return ingredients;
	}

	public abstract float cost();

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("[ ");
		stringBuffer.append(getIngredients());
		stringBuffer.append(" = ");
		stringBuffer.append(cost());
		stringBuffer.append(" TL ]");
		return stringBuffer.toString();
	}
}
