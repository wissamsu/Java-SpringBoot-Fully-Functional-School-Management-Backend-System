package com.Wissam.springTsTest.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wissam.springTsTest.Entitys.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findByClasssIdAndEmail(Long classId, String email);

    List<Student> findByClasssIdAndName(Long classId, String name);

    List<Student> findByClasssId(Long classId);

}
