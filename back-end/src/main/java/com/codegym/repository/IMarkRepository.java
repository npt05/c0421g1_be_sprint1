package com.codegym.repository;


import com.codegym.entity.about_student.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface IMarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value="select * from mark", nativeQuery = true)
    List<Mark> getMarkList();
}
