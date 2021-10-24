package com.codegym.service;

import com.codegym.entity.about_student.Mark;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.util.List;


public interface IMarkService  {
    List<Mark> findAll();

    Mark getById(int id);

    void save(Mark mark);

    void delete(int id);

    List<Mark> search(String nameStudent, String subject);
}
