package com.file.fileupload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.fileupload.Entity.Student;

@Repository
public interface Student_repo extends JpaRepository<Student, Integer> {

}
