package com.mehmet.efendi.dao;

import org.springframework.stereotype.Repository;

import com.mehmet.efendi.entity.Beverage;

@Repository
public interface BeverageDao extends BaseDao<Beverage, Long> {
	
}
