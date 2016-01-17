package com.mehmet.efendi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="beverage")
public class Beverage extends BaseEntity implements Receiptable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2795488152699791873L;
	
	public Beverage() {
	}

	public Beverage(String name , float price) {
		super(name,price);
	}
}
