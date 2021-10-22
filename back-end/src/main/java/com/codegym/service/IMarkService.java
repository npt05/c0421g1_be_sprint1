package com.codegym.service;

import com.codegym.entity.about_student.Mark;

import java.util.List;

public interface IMarkService extends GeneralService<Mark, Integer>{
    List<Mark> getMarkList();
}
