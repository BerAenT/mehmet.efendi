package com.mehmet.efendi.dto;

import com.mehmet.efendi.entity.Beverage;

public class BeverageDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8771340197239445634L;
	
	public BeverageDto() {
	}
	
	public BeverageDto(String name) {
		setName(name);
	}
	
	public BeverageDto(Beverage beverage) {
		super(beverage.getId(),beverage.getName(),beverage.getPrice());
	}
	
	public BeverageDto(long id, String name, float price) {
		super(id,name,price);
	}
	
	

}
