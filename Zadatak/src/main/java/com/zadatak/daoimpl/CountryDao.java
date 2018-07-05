package com.zadatak.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.domain.Country;

@Repository("country")
@Transactional 
public class CountryDao extends DaoClass<Long, Country> {

	public CountryDao() {
		super(Country.class);
	}

	public void deleteById(Long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Country user = (Country) crit.uniqueResult();
		delete(user);
	}
}
