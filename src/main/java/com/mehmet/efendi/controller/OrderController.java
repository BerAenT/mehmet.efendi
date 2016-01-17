package com.mehmet.efendi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.efendi.dto.OrderDto;
import com.mehmet.efendi.dto.ReceiptDto;
import com.mehmet.efendi.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/receipt", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
	public ResponseEntity<ReceiptDto> receipt(@RequestBody OrderDto orderDto) {
		try {
			LOGGER.debug("/orde/receipt/ contoller called");
			ReceiptDto receiptDto = orderService.order(orderDto);
			LOGGER.debug("/orde/receipt/ contoller returned SUCCESS");
			return new ResponseEntity<ReceiptDto>(receiptDto, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<ReceiptDto>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/prepareReceipt", method = RequestMethod.POST)
	public ReceiptDto prepareReceipt(OrderDto orderDto) {
		ReceiptDto receiptDto = orderService.order(orderDto);
		return receiptDto;
	}
}
