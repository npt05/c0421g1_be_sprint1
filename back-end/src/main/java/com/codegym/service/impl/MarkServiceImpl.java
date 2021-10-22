package com.codegym.service.impl;

import com.codegym.entity.about_student.Mark;
import com.codegym.repository.IMarkRepository;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkServiceImpl implements IMarkService {
    @Autowired
    private IMarkRepository iMarkRepository;

    @Override
    public List<Mark> findAll() {
        return iMarkRepository.getAllMarkStudent();
    }

    @Override
    public Mark getById(Integer id) {
        return null;
    }

    @Override
    public void save(Mark mark) {
        iMarkRepository.editMark(mark.getMarkPointNumber1(), mark.getMarkPointNumber2(),mark.getMarkPointNumber3(), mark.getMarkId());
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Mark> search(String search) {
        return null;
    }
}
