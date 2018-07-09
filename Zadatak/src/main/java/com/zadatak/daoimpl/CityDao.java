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

	public void deleteById(Long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		City city = (City) crit.uniqueResult();
		delete(city);
	}

	
	public void update(City city) {
	Criteria criteria = createEntityCriteria();
    criteria.add(Restrictions.eq("id",city.getId()));
    City cityUpdate = (City) criteria.uniqueResult();
    update(cityUpdate);
	
	}
}
