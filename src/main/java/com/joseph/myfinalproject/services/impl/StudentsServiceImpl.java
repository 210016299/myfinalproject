package com.joseph.myfinalproject.services.impl;

import com.joseph.myfinalproject.domain.Students;
import com.joseph.myfinalproject.repository.StudentsRepository;
import com.joseph.myfinalproject.services.StudentsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    
    @Override
    public Students find(Long id) {
        return studentsRepository.findOne(id);
    }

    @Override
    public Students persist(Students entity) {
        return studentsRepository.save(entity);
    }

    @Override
    public Students merge(Students entity) {
        if (entity.getId()!= 0) {
            return studentsRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Students entity) {
        studentsRepository.delete(entity);
    }

    @Override
    public List<Students> findAll() {
        return studentsRepository.findAll();
    }
    
}
