package com.zadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.dao.DaoBase;
import com.zadatak.domain.Sex;

@Service
public class SexService extends ServiceClass<Sex> {

	@Autowired
	static DaoBase<Sex> dao;

	public void setDao(DaoBase<Sex> entityClass) {
		SexService.dao = entityClass;
		dao.setClass(Sex.class);
	}

}