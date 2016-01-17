package com.mehmet.efendi.dto;

import java.io.Serializable;

public class BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5085206212312565885L;

	public BaseDto() {
	}


	public BaseDto(long id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}


	private long id;
	private String name;
	private float price;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("[ ");
		stringBuffer.append(getId());
		stringBuffer.append(" | ");
		stringBuffer.append(getName());
		stringBuffer.append(" | ");
		stringBuffer.append(getPrice());
		stringBuffer.append(" TL ]");
		return stringBuffer.toString();
	}


}
