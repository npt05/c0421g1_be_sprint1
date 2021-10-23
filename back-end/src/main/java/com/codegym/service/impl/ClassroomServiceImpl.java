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

    //DanhNT coding 2:00PM - 23-10-2021
    @Override
    public List<Classroom> findAll() {
        return this.classroomRepository.findAllList();
    }

    //DanhNT coding 2:00PM - 23-10-2021
    @Override
    public Classroom getById(Integer id) {
        return this.classroomRepository.findById(id).orElse(null);
    }


    //DanhNT coding 2:00PM - 23-10-2021
    @Override
    public void updateSchoolYear(String schoolYear, Integer id) {
        this.classroomRepository.updateSchoolYear(schoolYear, id);
    }


}
