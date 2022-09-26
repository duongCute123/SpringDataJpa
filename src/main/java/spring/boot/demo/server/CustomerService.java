package spring.boot.demo.server;

import java.util.List;

import spring.boot.demo.model.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
	Customer getCustomer(String theId);
	void saCustomer (Customer customer);
	void deleteCustomer(String id);
}
