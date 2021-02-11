package com.example.demo.studentsDAO;

import java.util.List;

public interface StudentsDAO {
    List<Object> findAll();
    Object findById(int id);
    void save(Object part);
    void deleteById(int id);
}
