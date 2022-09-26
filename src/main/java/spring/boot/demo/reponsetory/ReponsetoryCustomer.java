package spring.boot.demo.reponsetory;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.demo.model.Customer;

public interface ReponsetoryCustomer extends JpaRepository<Customer, String>{

}
