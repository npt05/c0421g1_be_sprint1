package com.codegym.service.impl;

import com.codegym.entity.about_classroom.Grade;
import com.codegym.repository.IGradeRepository;
import com.codegym.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private IGradeRepository gradeRepository;

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAllGrade();
    }

    @Override
    public Grade getById(Integer id) {
        return null;
    }

    @Override
    public Grade save(Grade e) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Grade> search(String search) {
        return null;
    }
}
