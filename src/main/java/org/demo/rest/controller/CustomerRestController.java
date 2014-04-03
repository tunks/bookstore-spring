/*
 * Created on 3 avr. 2014 ( Time 19:39:49 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.demo.bean.Customer;
import org.demo.business.service.CustomerService;
import org.demo.web.listitem.CustomerListItem;

/**
 * Spring MVC controller for 'Customer' management.
 */
@Controller
public class CustomerRestController {

	@Resource
	private CustomerService customerService;
	
	@RequestMapping( value="/items/customer",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CustomerListItem> findAllAsListItems() {
		List<Customer> list = customerService.findAll();
		List<CustomerListItem> items = new LinkedList<CustomerListItem>();
		for ( Customer customer : list ) {
			items.add(new CustomerListItem( customer ) );
		}
		return items;
	}
	
	@RequestMapping( value="/customer",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@RequestMapping( value="/customer/{code}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer findOne(@PathVariable("code") String code) {
		return customerService.findById(code);
	}
	
	@RequestMapping( value="/customer",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer create(@RequestBody Customer customer) {
		return customerService.create(customer);
	}

	@RequestMapping( value="/customer/{code}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer update(@PathVariable("code") String code, @RequestBody Customer customer) {
		return customerService.update(customer);
	}

	@RequestMapping( value="/customer/{code}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("code") String code) {
		customerService.delete(code);
	}
	
}