package com.mehmet.efendi.service;

import java.io.Serializable;
import java.util.List;

import com.mehmet.efendi.dto.ReceiptDto;
import com.mehmet.efendi.entity.BaseEntity;

public interface BaseService<T extends BaseEntity,PK extends Serializable> {


	public T insert(T t);

	public T findByName(String name);
	
	public T findOne(PK id);

	public T update(T t);
	
	public int recordCount();
	
	public ReceiptDto prepareReceipt(ReceiptDto receiptDto, List<String> productNameList);

	public List<T> findAll();
	
	
}
