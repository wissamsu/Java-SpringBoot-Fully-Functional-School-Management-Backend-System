package com.Wissam.springTsTest.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Wissam.springTsTest.Entitys.Classs;

public interface ClassRepo extends JpaRepository<Classs, Long> {

    Optional<Classs> findByName(String name);

}
