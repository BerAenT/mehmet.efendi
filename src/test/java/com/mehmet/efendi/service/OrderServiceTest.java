package com.mehmet.efendi.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mehmet.efendi.MehmetEfendiApplication;
import com.mehmet.efendi.beverage.Beverage;
import com.mehmet.efendi.beverage.ChocolateSyrup;
import com.mehmet.efendi.beverage.Latte;
import com.mehmet.efendi.beverage.Milk;
import com.mehmet.efendi.beverage.Mocha;
import com.mehmet.efendi.beverage.NutSyrup;
import com.mehmet.efendi.beverage.Tea;
import com.mehmet.efendi.dto.BeverageDto;
import com.mehmet.efendi.dto.BlendDto;
import com.mehmet.efendi.dto.OrderDto;
import com.mehmet.efendi.dto.ReceiptDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MehmetEfendiApplication.class)
@WebAppConfiguration
public class OrderServiceTest {

	private static Logger LOGGER = LoggerFactory.getLogger(OrderServiceTest.class);

	@Autowired
	private OrderService orderService;

	@Test
	public void filterCoffeWithMilkTest() {
		// Sütlü filtre kahve

		OrderDto orderDto = new OrderDto();
		orderDto.getBeveragaDtoList().add(new BeverageDto("Filter Coffe"));
		orderDto.getBlendDtoList().add(new BlendDto("Milk"));

		ReceiptDto receiptDto = orderService.order(orderDto);
		Assert.assertEquals(7.0f, receiptDto.getCost(), 0f);

	}

	@Test
	public void mochaWithDoubleMilkTest() {
		// - Bol sütlü (2 x süt) Mocha

		OrderDto orderDto = new OrderDto();
		orderDto.getBeveragaDtoList().add(new BeverageDto("Mocha"));
		orderDto.getBlendDtoList().add(new BlendDto("Milk"));
		orderDto.getBlendDtoList().add(new BlendDto("Milk"));

		ReceiptDto receiptDto = orderService.order(orderDto);
		Assert.assertEquals(10.0f, receiptDto.getCost(), 0f);

		// Decorator Test
		Beverage mocha = new Mocha();
		mocha = new Milk(mocha);
		mocha = new Milk(mocha);
		LOGGER.debug("Order Detail : {}", mocha);
		Assert.assertEquals(10.0f, mocha.cost(), 0f);

	}

	@Test
	public void latteWithMilkAndNutSyrupTest() {
		// - Sütlü ve fındık şuruplu Latte

		OrderDto orderDto = new OrderDto();
		orderDto.getBeveragaDtoList().add(new BeverageDto("Latte"));
		orderDto.getBlendDtoList().add(new BlendDto("Milk"));
		orderDto.getBlendDtoList().add(new BlendDto("Nut Syrup"));

		ReceiptDto receiptDto = orderService.order(orderDto);
		Assert.assertEquals(10.0f, receiptDto.getCost(), 0f);

		Beverage latte = new Latte();
		latte = new Milk(latte);
		latte = new NutSyrup(latte);
		LOGGER.debug("Order Detail : {}", latte);
		Assert.assertEquals(10.0f, latte.cost(), 0f);
	}

	@Test
	public void teaTest() {
		// - Çay

		OrderDto orderDto = new OrderDto();
		orderDto.getBeveragaDtoList().add(new BeverageDto("Tea"));

		ReceiptDto receiptDto = orderService.order(orderDto);
		Assert.assertEquals(3.0f, receiptDto.getCost(), 0f);

		Beverage tea = new Tea();
		LOGGER.debug("Order Detail : {}", tea);
		Assert.assertEquals(3.0f, tea.cost(), 0f);
	}

	@Test
	public void mochaWithChocolateSyrupTest() {

		OrderDto orderDto = new OrderDto();
		orderDto.getBeveragaDtoList().add(new BeverageDto("Mocha"));
		orderDto.getBlendDtoList().add(new BlendDto("Chocolate Syrup"));

		ReceiptDto receiptDto = orderService.order(orderDto);
		Assert.assertEquals(11.0f, receiptDto.getCost(), 0f);

		Beverage mocha = new Mocha();
		mocha = new ChocolateSyrup(mocha);
		LOGGER.debug("Order Detail : {}", mocha);
		Assert.assertEquals(11.0f, mocha.cost(), 0f);

	}

}
