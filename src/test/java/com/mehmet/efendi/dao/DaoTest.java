package com.mehmet.efendi.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mehmet.efendi.MehmetEfendiApplication;
import com.mehmet.efendi.entity.Beverage;
import com.mehmet.efendi.entity.Blend;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MehmetEfendiApplication.class)
public class DaoTest {
	private static Logger LOGGER = LoggerFactory.getLogger(DaoTest.class);

	@Autowired
	private BeverageDao beverageDao;

	@Autowired
	private BlendDao blendDao;

	@Test
	public void insertTest() {
		
		beverageDao.deleteAll();
		blendDao.deleteAll();
		insertBeverages();
		insertBlend();

		Beverage latte = beverageDao.findByName("Latte");
		Blend milk = blendDao.findByName("Milk");
		
		Assert.assertNotNull(latte);
		LOGGER.debug("{}", latte);
		Assert.assertNotNull(milk);
		LOGGER.debug("{}", milk);
	}


	private void insertBeverages() {
		Beverage filterCoffe = new Beverage("Filter Coffe", 5.0f);
		Beverage mocha = new Beverage("Mocha", 6.0f);
		Beverage latte = new Beverage("Latte", 5.0f);
		Beverage tea = new Beverage("Tea", 3.0f);

		beverageDao.save(filterCoffe);
		beverageDao.save(mocha);
		beverageDao.save(latte);
		beverageDao.save(tea);

		LOGGER.debug("{}", filterCoffe);
		LOGGER.debug("{}", mocha);
		LOGGER.debug("{}", latte);
		LOGGER.debug("{}", tea);
	}
	
	private void insertBlend() {
		Blend milk = new Blend("Milk",2.0f);
		Blend chocolateSyrup = new Blend("Chocolate Syrup",5.0f);
		Blend nutSyrup = new Blend("Nut Syrup",3.0f);
		
		blendDao.save(milk);
		blendDao.save(chocolateSyrup);
		blendDao.save(nutSyrup);
		
		 
		LOGGER.debug("{}",milk);
		LOGGER.debug("{}",chocolateSyrup);
		LOGGER.debug("{}",nutSyrup);

	}

}
