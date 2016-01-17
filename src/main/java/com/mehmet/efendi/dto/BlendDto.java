package com.mehmet.efendi.dto;

import com.mehmet.efendi.entity.Blend;

public class BlendDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087633437646159282L;

	public BlendDto() {
	}

	public BlendDto(String name) {
		setName(name);
	}
	public BlendDto(Blend blend) {
		super(blend.getId(), blend.getName(), blend.getPrice());
	}
	

	public BlendDto(long id, String name, float price) {
		super(id, name, price);
	}

	

}
