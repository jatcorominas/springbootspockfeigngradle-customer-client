package com.feign.customerclient.controller;

import com.feign.customerclient.service.CustomerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerClientController {

    @Autowired
    CustomerServiceClient customerServiceClient;

    @GetMapping("/fetchCustomers")
    public ResponseEntity<?> fetchCustomers() { return ResponseEntity.ok(customerServiceClient.getAllCustomers());}

    @GetMapping("/fetchCustomer/{id}")
    public ResponseEntity<?> fetchCCustomer(@PathVariable int id){
        return ResponseEntity.ok(customerServiceClient.getCustomer(id));
    }


}
