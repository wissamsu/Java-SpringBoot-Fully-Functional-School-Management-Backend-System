package com.Wissam.springTsTest.Entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Min(value = 8, message = "Password must be at least 8 characters")
    private String password;

    private String subject;

    @OneToMany(mappedBy = "teacher")
    private List<Classs> classs;

    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
}
