package com.zadatak.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadatak.domain.Contact;

@Repository("contact")
@Transactional 
public class ContactDao extends DaoClass<Long, Contact> {

	public ContactDao() {
		super(Contact.class);
		// TODO Auto-generated constructor stub
	}

	public void deleteById(Long id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Contact user = (Contact) crit.uniqueResult();
		delete(user);
	}

}
