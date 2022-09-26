package spring.boot.demo.server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.demo.model.Customer;
import spring.boot.demo.reponsetory.ReponsetoryCustomer;
@Service
public class CustomerServiceImlp implements CustomerService {
	ReponsetoryCustomer reponsetoryCustomer;
	@Autowired
	public CustomerServiceImlp(ReponsetoryCustomer theCustomer) {
		reponsetoryCustomer=theCustomer;
	}
	@Override
	public List<Customer> getCustomers() {
		return reponsetoryCustomer.findAll();
	}

	@Override
	public Customer getCustomer(String theId) {
		Optional<Customer> result=reponsetoryCustomer.findById(theId);
		Customer customer=null;
		if (result.isPresent()) {
			customer=result.get();
		}else {
			throw new RuntimeException("Không tìm thấy id cần tìm" + theId);
		}
		return customer;
	}

	@Override
	public void saCustomer(Customer customer2) {
		reponsetoryCustomer.save(customer2);
		
	}

	@Override
	public void deleteCustomer(String id) {
		reponsetoryCustomer.deleteById(id);
		
	}

}
