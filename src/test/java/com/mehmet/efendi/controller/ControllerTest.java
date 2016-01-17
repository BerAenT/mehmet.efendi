package com.mehmet.efendi.controller;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mehmet.efendi.MehmetEfendiApplication;
import com.mehmet.efendi.dto.BeverageDto;
import com.mehmet.efendi.dto.BlendDto;
import com.mehmet.efendi.dto.OrderDto;
import com.mehmet.efendi.dto.ReceiptDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MehmetEfendiApplication.class)
@WebIntegrationTest()
public class ControllerTest {

	private static Logger LOGGER = LoggerFactory.getLogger(ControllerTest.class);

	@Value("${local.server.port}")
	private int port;

	@Test
	public void beverageDtoListTets() {
		String url = "http://localhost:" + this.port + "/beverage/list";
		ResponseEntity<BeverageDto[]> entity = new TestRestTemplate().getForEntity(url, BeverageDto[].class);

		LOGGER.debug("Response Status : {}", entity.getStatusCode());
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

		Assert.assertNotNull(entity.getBody());

		LOGGER.debug("Response Body : {}", entity.getBody().length);
		Assert.assertNotEquals(0, entity.getBody().length);

		if (LOGGER.isDebugEnabled()) {
			for (BeverageDto beverageDto : entity.getBody()) {
				LOGGER.debug("Beverage : {}", beverageDto);
			}
		}
	}

	@Test
	public void blendDtoListTets() {
		String url = "http://localhost:" + this.port + "/blend/list";
		ResponseEntity<BlendDto[]> entity = new TestRestTemplate().getForEntity(url, BlendDto[].class);

		LOGGER.debug("Response Status : {}", entity.getStatusCode());
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

		Assert.assertNotNull(entity.getBody());

		LOGGER.debug("Response Body : {}", entity.getBody().length);
		Assert.assertNotEquals(0, entity.getBody().length);

		if (LOGGER.isDebugEnabled()) {
			for (BlendDto blendDto : entity.getBody()) {
				LOGGER.debug("Blend : {}", blendDto);
			}
		}
	}

	@Test
	public void orderTets() {
		String url = "http://localhost:" + this.port + "/order/receipt";

		OrderDto orderDto = new OrderDto();
		orderDto.getBeveragaDtoList().add(new BeverageDto("Mocha"));
		orderDto.getBlendDtoList().add(new BlendDto("Milk"));
		orderDto.getBlendDtoList().add(new BlendDto("Milk"));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<OrderDto> request = new HttpEntity<OrderDto>(orderDto, headers);
		ResponseEntity<ReceiptDto> entity = new TestRestTemplate().postForEntity(url, request, ReceiptDto.class);

		LOGGER.debug("Response Status : {}", entity.getStatusCode());
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

		Assert.assertNotNull(entity.getBody());

		LOGGER.debug("Response Body : {}", entity.getBody());

	}
}
