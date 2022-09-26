package spring.boot.demo.dao;

import java.util.List;

import spring.boot.demo.model.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
}
