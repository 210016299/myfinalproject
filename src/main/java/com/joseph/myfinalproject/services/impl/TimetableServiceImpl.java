package com.joseph.myfinalproject.services.impl;

import com.joseph.myfinalproject.domain.Timetable;
import com.joseph.myfinalproject.repository.TimetableRepository;
import com.joseph.myfinalproject.services.TimetableService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;
    
    @Override
    public Timetable find(Long id) {
        return timetableRepository.findOne(id);
    }

    @Override
    public Timetable persist(Timetable entity) {
        return timetableRepository.save(entity);
    }

    @Override
    public Timetable merge(Timetable entity) {
        if (entity.getId()!= 0) {
            return timetableRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Timetable entity) {
        timetableRepository.delete(entity);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }
    
}
