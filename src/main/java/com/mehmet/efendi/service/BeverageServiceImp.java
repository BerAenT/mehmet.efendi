package com.mehmet.efendi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmet.efendi.dto.BeverageDto;
import com.mehmet.efendi.entity.Beverage;


@Service("beveragaService")
public class BeverageServiceImp extends BaseServiceImp<Beverage, Long> implements BeverageService {

	
	@Override
	@Transactional(readOnly = true)
	public List<BeverageDto> getAllBeverageDtoList() {
		List<BeverageDto> beverageDtoList = new ArrayList<BeverageDto>();
		for(Beverage beverage : findAll()){
			beverageDtoList.add(new BeverageDto(beverage));
		}
		return beverageDtoList;
	}
}
