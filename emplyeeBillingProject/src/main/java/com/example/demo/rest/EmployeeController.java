package com.example.demo.rest;

import com.example.demo.employeeDAO.EmployeeDAO;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public class EmployeeController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(@Qualifier("employeeIMPL") EmployeeDAO employeeDAO){this.employeeDAO = employeeDAO;}

    @GetMapping("/retrieveAllEmployees")
    public List<Object> findAll(){
        return employeeDAO.findAll();
    }
    @GetMapping("/findEmployeeById/{id}")
    public Object findById(@PathVariable int id){
        return employeeDAO.findById(id);
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        employeeDAO.save(employee);
        return employee;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = (Employee) employeeDAO.findById(id);
        if(employee == null)
        {
            throw new RuntimeException("Employee not found! id: " + id);
        }
        employeeDAO.deleteById(id);
        return "Deleted Employee id : " + id;
    }

    @PutMapping("/updateEmployee")
    public Object updateEmployee(@RequestBody Employee updateEmployee){
        employeeDAO.save(updateEmployee);
        return updateEmployee;
    }


}
