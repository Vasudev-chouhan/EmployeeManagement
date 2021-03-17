package com.nagarro.daoImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.UserDao;
import com.nagarro.model.User;

/*
* Class name: UserDaoImpl 

* Author: vasudev.chouhan

* Created on: 06/03/2021

* Last updated by: vasudev.chouhan

* Last updated: 10/03/2021

* Description: This is the DaoImpl of User

*/

@Repository
public class UserDaoImpl implements UserDao {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Bean.xml");
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addUser(User user) {
		hibernateTemplate = applicationContext.getBean("hibernateTemplate", HibernateTemplate.class);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public boolean authenticateUser(String userName, String password) {
		String query = "FROM User WHERE userName = :userName AND password = :password";
		hibernateTemplate = applicationContext.getBean("hibernateTemplate", HibernateTemplate.class);
		User user = (User) hibernateTemplate.getSessionFactory().openSession().createQuery(query)
				.setParameter("userName", userName).setParameter("password", password).uniqueResult();
		if (user != null) {
			return true;
		}
		return false;
	}

}
