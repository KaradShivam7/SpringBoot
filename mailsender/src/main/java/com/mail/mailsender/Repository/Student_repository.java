package com.mail.mailsender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail.mailsender.Entity.Student;

@Repository
public interface Student_repository extends JpaRepository<Student, Integer> {

}
