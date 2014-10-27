package com.joseph.myfinalproject.repository;

import com.joseph.myfinalproject.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long>{
    
}
