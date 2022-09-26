package spring.boot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.boot.demo.model.Customer;

@Repository
public class CustomerDaoImlp implements CustomerDao {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	public CustomerDaoImlp(EntityManager manager) {
		entityManager=manager;
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session  session=entityManager.unwrap(Session.class);
		Query<Customer> query=session.createQuery("from customers",Customer.class);
		List<Customer> customers=query.getResultList();
		
		return customers;
	}

}
