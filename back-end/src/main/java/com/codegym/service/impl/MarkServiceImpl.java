package com.codegym.service.impl;

import com.codegym.entity.about_student.Mark;
import com.codegym.repository.IMarkRepository;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkServiceImpl implements IMarkService {
    @Autowired
    private IMarkRepository markRepository;
    @Override
    public List<Mark> getMarkList() {
        return this.markRepository.getMarkList();
    }

    @Override
    public List<Mark> findAll() {
        return null;
    }

    @Override
    public Mark getById(Integer id) {
        return null;
    }

    @Override
    public Mark save(Mark mark) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Mark> search(String search) {
        return null;
    }
}
