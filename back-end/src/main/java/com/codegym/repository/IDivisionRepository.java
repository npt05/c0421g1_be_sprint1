package com.codegym.repository;

import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
    @Query(value = "select division_name from division ",nativeQuery = true)
    List<Division> findDivisionAll();
}
