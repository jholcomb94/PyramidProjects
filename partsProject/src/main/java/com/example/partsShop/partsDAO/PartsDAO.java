package com.example.partsShop.partsDAO;

import java.util.List;

public interface PartsDAO {
    List<Object> findAll();
    Object findById(int id);
    void save(Object part);
    void deleteById(int id);
}
