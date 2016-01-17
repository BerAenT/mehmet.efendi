package com.mehmet.efendi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "blend")
public class Blend extends BaseEntity implements Receiptable {

	private static final long serialVersionUID = -3702908504146341749L;

	public Blend() {
	}

	public Blend(String name, float price) {
		super(name, price);
	}
}
