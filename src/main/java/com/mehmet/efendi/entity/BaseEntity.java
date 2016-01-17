package com.mehmet.efendi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 5680352750533673774L;

	public BaseEntity() {
	}

	public BaseEntity(String name, float price) {
		this.name = name;
		this.price = price;
	}

	private String name;
	private float price;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	public String getName() {
		return name;
	}

	@Column(name = "name", length = 50, nullable = false)
	public float getPrice() {
		return price;
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
		stringBuffer.append(" = ");
		stringBuffer.append(getPrice());
		stringBuffer.append(" TL ]");
		return stringBuffer.toString();
	}

	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object.getClass() == this.getClass()) {
			BaseEntity baseEntity = (BaseEntity) object;
			return baseEntity.getId().compareTo(getId()) == 0 && baseEntity.getName().equals(getName());
		}
		return false;
	}

	public int hashCode() {
		return getId().intValue();
	}

}
