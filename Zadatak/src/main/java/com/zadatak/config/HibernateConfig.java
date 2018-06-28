package com.zadatak.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zadatak.domain.Address;
import com.zadatak.domain.City;
import com.zadatak.domain.Contact;
import com.zadatak.domain.Country;
import com.zadatak.domain.Sex;
 
public class HibernateConfig{
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
            			.configure("hibernate.cfg.xml")
            			.addAnnotatedClass(Address.class)
                        .addAnnotatedClass(City.class)
                        .addAnnotatedClass(Contact.class)
                        .addAnnotatedClass(Country.class)
                        .addAnnotatedClass(Sex.class)
            			.buildSessionFactory();	
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
}