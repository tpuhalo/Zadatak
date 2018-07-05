package com.zadatak.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.domain.Sex;

@Repository("sex")
@Transactional
public class SexDao extends DaoClass<Long, Sex> {

	public SexDao() {
		super(Sex.class);
	}

	public void deleteById(Long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Sex user = (Sex) crit.uniqueResult();
		delete(user);
	}
}