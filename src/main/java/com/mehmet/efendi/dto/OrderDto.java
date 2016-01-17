package com.mehmet.efendi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6248774316776362314L;
	
	private List<BeverageDto> beveragaDtoList = new ArrayList<BeverageDto>();
	private List<BlendDto> blendDtoList = new ArrayList<BlendDto>();
	
	public List<BeverageDto> getBeveragaDtoList() {
		return beveragaDtoList;
	}
	public List<BlendDto> getBlendDtoList() {
		return blendDtoList;
	}
	public void setBeveragaDtoList(List<BeverageDto> beveragaDtoList) {
		this.beveragaDtoList = beveragaDtoList;
	}
	public void setBlendDtoList(List<BlendDto> blendDtoList) {
		this.blendDtoList = blendDtoList;
	}
	
	
}
