package com.mehmet.efendi.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mehmet.efendi.entity.BaseEntity;

@Repository
public interface BaseDao<T extends BaseEntity, PK extends Serializable> extends CrudRepository<T, Long> {
	T findByName(String name);
}
