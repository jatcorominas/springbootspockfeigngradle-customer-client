package com.feign.customerclient.service;

import com.feign.customerclient.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="customer-service", url="http://localhost:8082")
public interface CustomerServiceClient {

    @RequestMapping(value="/customers", method= RequestMethod.GET)
    public List<Customer> getAllCustomers();

    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") int customerId);
}
