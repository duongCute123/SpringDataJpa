package spring.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.demo.model.Customer;
import spring.boot.demo.server.CustomerService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000/")
public class CustomerRestController {
	CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}

	@GetMapping("/getlist")
	public List<Customer> getList() {
		return customerService.getCustomers();
	}

	@GetMapping("/getcustomer/{theid}")
	public Customer getCustomer(@PathVariable String theid) {
		Customer customer = customerService.getCustomer(theid);
		return customer;
	}

	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
//		customer.setId("0");
		customerService.saCustomer(customer);
		return customer;
	}

	@PutMapping("/addcustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saCustomer(customer);
		return customer;
	}
	@DeleteMapping("/deletecustomer/{theId}")
	public String deleteCustomer(@PathVariable String theId) {
		Customer customer = customerService.getCustomer(theId);
		customerService.deleteCustomer(theId);
		return "xóa thạhf công" + theId;
	}
}
