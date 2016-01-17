package com.mehmet.efendi.service;

import java.util.List;

import com.mehmet.efendi.dto.ReceiptDto;
import com.mehmet.efendi.entity.Receiptable;

public interface ReceiptService {

	public ReceiptDto prepareReceipt(ReceiptDto receiptDto, List<Receiptable> receiptableList);
}
