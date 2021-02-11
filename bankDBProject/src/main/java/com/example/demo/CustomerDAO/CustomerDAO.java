package com.example.demo.CustomerDAO;

import java.util.List;

public interface CustomerDAO {
    List<Object> findAll();
    Object findById(int id);
    void save(Object part);
    void deleteById(int id);
}
