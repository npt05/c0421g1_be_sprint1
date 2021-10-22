package com.codegym.service.impl;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.repository.IClassroomRepository;
import com.codegym.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public List<Classroom> findAll() {
        return null;
    }

    @Override
    public Classroom getById(Integer id) {
        return null;
    }

    @Override
    public void save(Classroom classroom) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Classroom> search(String search) {
        return null;
    }
}
