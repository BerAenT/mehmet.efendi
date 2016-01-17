package com.mehmet.efendi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmet.efendi.dto.ReceiptDto;
import com.mehmet.efendi.entity.Receiptable;

@Service("receiptService")
public class ReceptServiceImp implements ReceiptService {

	private static Logger LOGGER = LoggerFactory.getLogger(ReceptServiceImp.class);
	
	@Override
	@Transactional(readOnly=true)
	public ReceiptDto prepareReceipt(ReceiptDto receiptDto, List<Receiptable> receiptableList) {
		for (Receiptable receiptable : receiptableList) {
			receiptDto.setDetail(receiptDto.getDetail() + " , " + receiptable.getName());
			receiptDto.setCost(receiptDto.getCost() + receiptable.getPrice());
			LOGGER.debug("{} added to receipt",receiptable);
		}
		return receiptDto;
	}

}
