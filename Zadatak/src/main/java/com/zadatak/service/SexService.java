package com.zadatak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadatak.daoimpl.ContactDao;
import com.zadatak.daoimpl.SexDao;
import com.zadatak.domain.Sex;

@Service("sexBase")
public class SexService extends ContactDao implements ServiceBase<Long, Sex> {

	@Autowired
	SexDao sex;

	@Override
	public List<Sex> getAll() {
		// TODO Auto-generated method stub
		return sex.findAll();
	}



	@Override
	public Sex findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
<<<<<<< HEAD
<<<<<<< HEAD
	public void saveOrUpdate(Sex entity) {
		// TODO Auto-generated method stub

=======
	public String saveOrUpdate(Sex entity) {
		return null;
>>>>>>> git head fatal new commit
=======
	public void saveOrUpdate(Sex entity) {
		// TODO Auto-generated method stub

>>>>>>> 95a346ea9318b7d9bfd78bd20dd538a1febc2151
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}
