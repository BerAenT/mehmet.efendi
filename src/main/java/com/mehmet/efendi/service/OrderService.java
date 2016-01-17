package com.mehmet.efendi.service;

import com.mehmet.efendi.dto.OrderDto;
import com.mehmet.efendi.dto.ReceiptDto;

public interface OrderService {

	public ReceiptDto order(OrderDto orderDto);
}
