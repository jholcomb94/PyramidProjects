package com.example.demo.employeeDAO;

import java.util.List;

public interface EmployeeDAO {
    List<Object> findAll();
    Object findById(int id);
    void save(Object part);
    void deleteById(int id);
}
