package com.mehmet.efendi.dto;

import java.io.Serializable;

public class ReceiptDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3408490721279449598L;

	private String detail="";
	private float cost=0f;

	public String getDetail() {
		return detail;
	}

	public float getCost() {
		return cost;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("[");
		stringBuffer.append(getDetail());
		stringBuffer.append(" = ");
		stringBuffer.append(getCost());
		stringBuffer.append(" TL ]");
		return stringBuffer.toString();
	}

}
