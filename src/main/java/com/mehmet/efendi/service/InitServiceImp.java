package com.mehmet.efendi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmet.efendi.entity.Beverage;
import com.mehmet.efendi.entity.Blend;

@Service("initService")
public class InitServiceImp implements InitService {

	private static Logger LOGGER = LoggerFactory.getLogger(InitServiceImp.class);

	@Autowired
	private BeverageService beverageService;

	@Autowired
	private BlendService blendService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void loadData() {
		if (blendService.recordCount() == 0)
			insertBlend();
		if (beverageService.recordCount() == 0)
			insertBeverages();
	}

	private void insertBeverages() {
		Beverage filterCoffe = new Beverage("Filter Coffe", 5.0f);
		Beverage mocha = new Beverage("Mocha", 6.0f);
		Beverage latte = new Beverage("Latte", 5.0f);
		Beverage tea = new Beverage("Tea", 3.0f);

		beverageService.insert(filterCoffe);
		beverageService.insert(mocha);
		beverageService.insert(latte);
		beverageService.insert(tea);

		LOGGER.debug("{}", filterCoffe);
		LOGGER.debug("{}", mocha);
		LOGGER.debug("{}", latte);
		LOGGER.debug("{}", tea);
	}

	private void insertBlend() {
		Blend milk = new Blend("Milk", 2.0f);
		Blend chocolateSyrup = new Blend("Chocolate Syrup", 5.0f);
		Blend nutSyrup = new Blend("Nut Syrup", 3.0f);

		blendService.insert(milk);
		blendService.insert(chocolateSyrup);
		blendService.insert(nutSyrup);

		LOGGER.debug("{}", milk);
		LOGGER.debug("{}", chocolateSyrup);
		LOGGER.debug("{}", nutSyrup);

	}

}
