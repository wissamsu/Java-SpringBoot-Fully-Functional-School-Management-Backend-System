package com.Wissam.springTsTest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wissam.springTsTest.Entitys.Classs;
import com.Wissam.springTsTest.Repos.ClassRepo;

@Service
public class ClassService {

    @Autowired
    private ClassRepo classsRepo;

    public List<Classs> getAllClasses() {
        return classsRepo.findAll();
    }

    public Classs getClassById(Long id) {
        return classsRepo.findById(id).orElse(null);
    }

    public void addClass(Classs classs) {
        classsRepo.save(classs);
    }

    public void updateClass(Classs classs) {
        classsRepo.save(classs);
    }

    public void deleteClass(Long id) {
        classsRepo.deleteById(id);
    }

    public Classs getClassByName(String name) {
        return classsRepo.findByName(name).orElse(null);
    }

}
