package com.zadatak.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.domain.City;

@Repository("city")
@Transactional 
public class CityDao extends DaoClass<Long, City> {

	public CityDao() {
		super(City.class);
	}

	public void deleteById(Long id) { //creating criteria for deleting city
		Criteria crit = createEntityCriteria(); // we can only delete city with id
		crit.add(Restrictions.eq("id", id));
		City city = (City) crit.uniqueResult();
		delete(city);
	}

}
