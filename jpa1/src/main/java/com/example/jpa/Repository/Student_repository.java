package com.example.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.Entity.Student;

public interface Student_repository extends JpaRepository<Student, Integer> {

}
