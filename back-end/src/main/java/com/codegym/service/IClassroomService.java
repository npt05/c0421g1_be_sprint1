package com.codegym.service;

import com.codegym.entity.about_classroom.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassroomService {
    //DanhNT coding 3:00PM 23-10-21
    List<Classroom> findAll();

    //DanhNT coding 3:00PM 23-10-21
    Classroom getById(Integer id);

    //DanhNT coding 3:00PM 23-10-21
    void updateSchoolYear(String schoolYear, Integer teacherId, Integer classId);

    //DanhNT coding 3:00PM 23-10-21
    Page<Classroom> findAllPage(Pageable pageable);
}
