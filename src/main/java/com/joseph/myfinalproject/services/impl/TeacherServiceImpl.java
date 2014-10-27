package com.joseph.myfinalproject.services.impl;

import com.joseph.myfinalproject.domain.Students;
import com.joseph.myfinalproject.domain.Teacher;
import com.joseph.myfinalproject.repository.TeacherRepository;
import com.joseph.myfinalproject.services.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Override
    public Teacher find(Long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Teacher persist(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public Teacher merge(Teacher entity) {
        if (entity.getTeacher_id()!= null) {
            return teacherRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Teacher entity) {
        teacherRepository.delete(entity);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
    
}
