package com.mehmet.efendi.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmet.efendi.dao.BaseDao;
import com.mehmet.efendi.dto.ReceiptDto;
import com.mehmet.efendi.entity.BaseEntity;

abstract class BaseServiceImp<T extends BaseEntity, PK extends Serializable> implements BaseService<T, Long> {

	private static Logger LOGGER = LoggerFactory.getLogger(BaseServiceImp.class);

	@Autowired
	private BaseDao<T, PK> dao;

	private Class<T> clazz;

	public Class<T> getClazz() {
		return clazz;
	}

//	public void setClazz(Class<T> clazz) {
//		this.clazz = clazz;
//	}

	@Override
	@Transactional(readOnly = true)
	public T findOne(Long id) {
		return dao.findOne(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public T insert(T t) {
		return dao.save(t);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public T update(T t) {
		return dao.save(t);
	}

	@Override
	@Transactional(readOnly = true)
	public T findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public int recordCount(){
		return  (int)dao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll(){
		return  (List<T>)dao.findAll(); 
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public ReceiptDto prepareReceipt(ReceiptDto receiptDto, List<String> productNameList) {
		LOGGER.debug("Receipt is preparing for  {}", getClazz().getName());
		for (String blendName : productNameList) {
			T t = findByName(blendName.trim());
			if (t == null) {
				LOGGER.error("Order cancelled. -> Invalid {} Type : {} ", getClazz().getName(), blendName);
				throw new RuntimeException("Invalid " + getClazz().getName() + " Type : " + blendName);
			}

			receiptDto.setDetail(receiptDto.getDetail() + " , " + t.getName());
			receiptDto.setCost(receiptDto.getCost() + t.getPrice());
			LOGGER.debug("{}  | added to receipt", t);
		}
		return receiptDto;
	}
}