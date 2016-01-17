package com.mehmet.efendi.service;

import java.util.List;

import com.mehmet.efendi.dto.BeverageDto;
import com.mehmet.efendi.entity.Beverage;

public interface BeverageService extends BaseService<Beverage, Long> {

	public List<BeverageDto> getAllBeverageDtoList();

}
