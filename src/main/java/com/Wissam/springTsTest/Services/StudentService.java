package com.Wissam.springTsTest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wissam.springTsTest.Entitys.Classs;
import com.Wissam.springTsTest.Entitys.Student;
import com.Wissam.springTsTest.Repos.ClassRepo;
import com.Wissam.springTsTest.Repos.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ClassRepo classsRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        // Get the class from request
        Classs classs = student.getClasss();

        // Try to find existing class by name
        Classs existingClasss = classsRepo.findByName(classs.getName())
                .orElseGet(() -> classsRepo.save(classs));

        // Reattach the existing class to the student
        student.setClasss(existingClasss);

        // Now save the student
        studentRepo.save(student);
    }

    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepo.findByClasssId(classId);
    }

    public Student getStudentByClassIdAndEmail(Long classId, String email) {
        return studentRepo.findByClasssIdAndEmail(classId, email)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getStudentByClassIdAndName(Long classId, String name) {
        return studentRepo.findByClasssIdAndName(classId, name);
    }

}
