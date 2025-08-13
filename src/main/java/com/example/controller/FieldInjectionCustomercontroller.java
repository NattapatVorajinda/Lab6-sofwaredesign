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
@RequestMapping("/field")
public class FieldInjectionCustomercontroller {
	@Autowired           //field injection
	private CustomerService customerService;
	@GetMapping("/{id}") //Get http://localhost:8080/field/15
	public String getCustomerById(@PathVariable Long id) {
		Customer cust= customerService.getCustomerById(id);
		return "Field Injection: Id:"+cust.getId() + " ,Name:"+cust.getName();
	}

	@GetMapping("/customer/{id}/{name}")   //Get http://localhost:8080/field/customer/15/Natcha
	public String getCustomerByIdName(@PathVariable Long id, @PathVariable String name) {
		Customer cust= customerService.getCustomerByIdName(id,name);
		return "Field Injection: Id:"+cust.getId() + " ,Name:"+cust.getName();
	}
	@GetMapping("/customerlist") //Get http://localhost:8080/field/customerlist
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

}
