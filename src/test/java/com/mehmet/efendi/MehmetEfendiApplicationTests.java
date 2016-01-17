package com.mehmet.efendi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mehmet.efendi.beverage.Beverage;
import com.mehmet.efendi.beverage.ChocolateSyrup;
import com.mehmet.efendi.beverage.FilterCoffee;
import com.mehmet.efendi.beverage.Latte;
import com.mehmet.efendi.beverage.Milk;
import com.mehmet.efendi.beverage.Mocha;
import com.mehmet.efendi.beverage.NutSyrup;
import com.mehmet.efendi.beverage.Tea;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MehmetEfendiApplication.class)
@WebAppConfiguration
public class MehmetEfendiApplicationTests {

	private static Logger LOGGER = LoggerFactory.getLogger(MehmetEfendiApplicationTests.class);

	@Test
	public void filterCoffeWithMilkTest() {
		// Sütlü filtre kahve
		Beverage filterCoffee = new FilterCoffee();
		filterCoffee = new Milk(filterCoffee);

		LOGGER.debug("Order Detail : {}", filterCoffee);

		Assert.assertEquals(7.0f, filterCoffee.cost(), 0f);

	}

	@Test
	public void mochaWithDoubleMilkTest() {
		// - Bol sütlü (2 x süt) Mocha
		Beverage mocha = new Mocha();
		mocha = new Milk(mocha);
		mocha = new Milk(mocha);
		LOGGER.debug("Order Detail : {}", mocha);
		Assert.assertEquals(10.0f, mocha.cost(), 0f);

	}

	@Test
	public void latteWithMilkAndNutSyrupTest() {
		// - Sütlü ve fındık şuruplu Latte
		Beverage latte = new Latte();
		latte = new Milk(latte);
		latte = new NutSyrup(latte);
		LOGGER.debug("Order Detail : {}", latte);
		Assert.assertEquals(10.0f, latte.cost(), 0f);
	}

	@Test
	public void teaTest() {
		// - Çay
		Beverage tea = new Tea();
		LOGGER.debug("Order Detail : {}", tea);
		Assert.assertEquals(3.0f, tea.cost(), 0f);
	}

	@Test
	public void mochaWithChocolateSyrupTest() {

		Beverage mocha = new Mocha();
		mocha = new ChocolateSyrup(mocha);
		LOGGER.debug("Order Detail : {}", mocha);
		Assert.assertEquals(11.0f, mocha.cost(), 0f);

	}

}
