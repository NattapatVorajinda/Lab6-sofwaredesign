package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.services.CustomerService;

@RestController
@RequestMapping("/constructor")
public class ConstructorInjectionCustomercontroller {
	           //Constructor injection
	private CustomerService customerService;
	@Autowired
	public void constructorInjectionCustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	@GetMapping("/{id}") //Get http://localhost:8080/constructor/15
	public String getCustomerById(@PathVariable Long id) {
		Customer cust= customerService.getCustomerById(id);
		return "Constructor Injection: Id:"+cust.getId() + " ,Name:"+cust.getName();
	}

	@GetMapping("/customer/{id}/{name}")   //Get http://localhost:8080/constructor/customer/15/Natcha
	public String getCustomerByIdName(@PathVariable Long id, @PathVariable String name) {
		Customer cust= customerService.getCustomerByIdName(id,name);
		return "Constructor Injection: Id:"+cust.getId() + " ,Name:"+cust.getName();
	}
	@GetMapping("/customerlist") //Get http://localhost:8080/constructor/customerlist
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

}
