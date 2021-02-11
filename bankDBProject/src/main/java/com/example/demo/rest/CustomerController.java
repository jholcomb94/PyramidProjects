package com.example.demo.rest;

import com.example.demo.CustomerDAO.CustomerDAO;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class CustomerController {
    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(@Qualifier("customerIMPL") CustomerDAO customerDAO) {this.customerDAO = customerDAO;}

    @GetMapping("/retrieveAllCustomers")
    public List<Object> findAll(){
        return customerDAO.findAll();
    }

    @GetMapping("/findCustomerById/{id}")
    public Object findById(@PathVariable int id){
        return customerDAO.findById(id);
    }
    @PutMapping("/withdraw")
    public Customer withdrawMoney(@RequestBody Transaction transaction)
    {
        Customer customer = (Customer) customerDAO.findById(transaction.getId());
        if(customer == null)
        {
            throw new RuntimeException("Customer not found! id: " + transaction.getId());
        }
        customer.setBalance(customer.getBalance() - transaction.getAmmount());
        customerDAO.save(customer);
        return customer;
    }

    @PutMapping("/deposit")
    public Customer depositMoney(@RequestBody Transaction transaction)
    {
        Customer customer = (Customer) customerDAO.findById(transaction.getId());
        if(customer == null)
        {
            throw new RuntimeException("Customer not found! id: " + transaction.getId());
        }
        customer.setBalance(customer.getBalance() + transaction.getAmmount());
        customerDAO.save(customer);
        return customer;
    }
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        customer.setId(0);
        customerDAO.save(customer);
        return customer;
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        Customer customer = (Customer) customerDAO.findById(id);
        if(customer == null)
        {
            throw new RuntimeException("Customer not found! id: " + id);
        }
        customerDAO.deleteById(id);
        return "Deleted Customer id : " + id;
    }

    @PutMapping("/updateCustomer")
    public Object updateEmployee(@RequestBody Customer updateCustomer){
        customerDAO.save(updateCustomer);
        return updateCustomer;
    }

}
