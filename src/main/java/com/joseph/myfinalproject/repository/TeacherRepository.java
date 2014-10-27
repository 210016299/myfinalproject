package com.joseph.myfinalproject.repository;

import com.joseph.myfinalproject.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
