package com.zadatak.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.domain.Address;

@Repository("address")
@Transactional 
public class AddressDao extends DaoClass<Long, Address> {

	public AddressDao() {
		super(Address.class);
		// TODO Auto-generated constructor stub
	}

	public void deleteById(Long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Address user = (Address) crit.uniqueResult();
		delete(user);
	}

}