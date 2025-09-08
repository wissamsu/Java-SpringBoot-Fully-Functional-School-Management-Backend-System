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

import com.Wissam.springTsTest.Entitys.Classs;
import com.Wissam.springTsTest.Services.ClassService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/class")
@CrossOrigin(origins = "*")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Classs> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Classs getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public void addClass(@Valid @RequestBody Classs classs) {
        classService.addClass(classs);
    }

    @PutMapping
    public void updateClass(@Valid @RequestBody Classs classs) {
        classService.updateClass(classs);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }

    @GetMapping("/name/{name}")
    public Classs getClassByName(@PathVariable String name) {
        return classService.getClassByName(name);
    }
}
