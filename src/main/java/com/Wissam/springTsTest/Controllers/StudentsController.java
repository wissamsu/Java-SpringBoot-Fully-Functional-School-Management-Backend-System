package com.Wissam.springTsTest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wissam.springTsTest.Entitys.Student;
import com.Wissam.springTsTest.Services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/class/{classId}")
    public List<Student> getStudentsByClassId(@PathVariable Long classId) {
        return studentService.getStudentsByClassId(classId);
    }

    @GetMapping("/class/{classId}/email/{email}")
    public Student getStudentByClassIdAndEmail(@PathVariable Long classId, @PathVariable String email) {
        return studentService.getStudentByClassIdAndEmail(classId, email);
    }

    @GetMapping("/class/{classId}/name/{name}")
    public List<Student> getStudentByClassIdAndName(@PathVariable Long classId, @PathVariable String name) {
        return studentService.getStudentByClassIdAndName(classId, name);
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update")
    public void updateStudent(@Valid @RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @PostMapping("/add")
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

}
