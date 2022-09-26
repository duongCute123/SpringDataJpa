package spring.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.demo.dao.CustomerDao;
import spring.boot.demo.dao.CustomerDaoImlp;
import spring.boot.demo.model.Customer;

@RestController
public class CustomerController {
	CustomerDao customerDao;
	@Autowired
	public CustomerController(CustomerDao dao) {
		customerDao=dao;
	}
	@GetMapping("/getCustomer")
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	@GetMapping("/hello")
	public ResponseEntity getHome() {
		return ResponseEntity.ok("hello các bạn nhá");
	}
	
}
