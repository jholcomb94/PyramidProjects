package com.example.partsShop.rest;
import com.example.partsShop.partsDAO.PartsDAO;
import com.example.partsShop.entities.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class PartController {
    private final PartsDAO partsDAO;

    @Autowired
    public PartController(@Qualifier("partsIMPL") PartsDAO partsDAO) {
        this.partsDAO = partsDAO;
    }
    @GetMapping("/findPartById/{testId}")
    public Object findById(@PathVariable int testId){
        return partsDAO.findById(testId);
    }

    @GetMapping("/retrieveAllParts")
    public List<Object> findAll() {
        return partsDAO.findAll();
    }
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part part)
    {
        part.setId(0);
        partsDAO.save(part);
        return part;
    }
    @DeleteMapping("/deletePart/{id}")
    public String deletePart(@PathVariable int id) {
        Part part = (Part) partsDAO.findById(id);
        if(part == null) {
            throw new RuntimeException("Employee is not found : " + id);
        }

        //This will execute the deleteByID.
        partsDAO.deleteById(id);
        return "Deleted employee id : " + id;
    }

    @PutMapping("/updatePart")
    public Object updateEmployee(@RequestBody Part updatePart) {
        partsDAO.save(updatePart);
        return updatePart;
    }




}
