package com.codegym.service.impl;

import com.codegym.entity.about_teacher.Division;
import com.codegym.repository.IDivisionRepository;
import com.codegym.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DivisionServiceImpl implements GeneralService<Division,Integer> {
    @Autowired
    private final IDivisionRepository iDivisionRepository;

    public DivisionServiceImpl(IDivisionRepository iDivisionRepository) {
        this.iDivisionRepository = iDivisionRepository;
    }

    @Override
    public List<Division> findAll() {
        return this.iDivisionRepository.findDivisionAll() ;
    }

    @Override
    public Division getById(Integer id) {
        return null;
    }

    @Override
    public void save(Division division) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Division> search(String search) {
        return null;
    }
}
