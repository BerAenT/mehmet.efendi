package com.mehmet.efendi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmet.efendi.dto.BeverageDto;
import com.mehmet.efendi.dto.BlendDto;
import com.mehmet.efendi.dto.OrderDto;
import com.mehmet.efendi.dto.ReceiptDto;
import com.mehmet.efendi.entity.Beverage;
import com.mehmet.efendi.entity.Blend;
import com.mehmet.efendi.entity.Receiptable;

@Service("orderService")
public class OrderServiceImp implements OrderService {

	private static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImp.class);

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private BeverageService beveragaService;

	@Autowired
	private BlendService blendService;

	@Override
	@Transactional(readOnly = true)
	public ReceiptDto order(OrderDto orderDto) {
		if (orderDto == null) {
			throw new RuntimeException("Order required...");
		}
		LOGGER.debug("Receipt is preparing....");
		ReceiptDto receiptDto = new ReceiptDto();
		List<Receiptable> receiptableList = new ArrayList<Receiptable>();
		for (BeverageDto beverageDto : orderDto.getBeveragaDtoList()) {
			Beverage beverage = beveragaService.findByName(beverageDto.getName());
			if (beverage == null) {
				throw new RuntimeException("Invalid beverage : " + beverageDto.getName());
			}
			receiptableList.add(beverage);
		}

		for (BlendDto blendDto : orderDto.getBlendDtoList()) {
			Blend blend = blendService.findByName(blendDto.getName());
			if (blend == null) {
				throw new RuntimeException("Invalid blend : " + blendDto.getName());
			}
			receiptableList.add(blend);
		}

		receiptDto = receiptService.prepareReceipt(receiptDto, receiptableList);

		LOGGER.debug("Receipt DONE");
		LOGGER.debug("-------------------------------------");
		LOGGER.debug("{}", receiptDto);
		LOGGER.debug("-------------------------------------");
		return receiptDto;
	}


}
