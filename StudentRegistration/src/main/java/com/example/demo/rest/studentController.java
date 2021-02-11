package com.example.demo.rest;

import com.example.demo.entities.Student;
import com.example.demo.studentsDAO.StudentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class studentController {
    private final StudentsDAO studentsDAO;

    @Autowired
    public studentController(@Qualifier("studentsIMPL") StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @GetMapping("/retrieveAllStudents")
    public List<Object> findAll() { return studentsDAO.findAll();
    }

    @GetMapping("/findStudentById/{testId}")
    public Object findById(@PathVariable int testId){ return studentsDAO.findById(testId);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student)
    {
        student.setId(0);
        studentsDAO.save(student);
        return student;
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudnet(@PathVariable int id) {
        Student part = (Student) studentsDAO.findById(id);
        if(part == null) {
            throw new RuntimeException("Student is not found : " + id);
        }

        //This will execute the deleteByID.
        studentsDAO.deleteById(id);
        return "Deleted student id : " + id;
    }

    @PutMapping("/updateStudent")
    public Object updateStudent(@RequestBody Student updateStudent) {
        studentsDAO.save(updateStudent);
        return updateStudent;
    }
}
