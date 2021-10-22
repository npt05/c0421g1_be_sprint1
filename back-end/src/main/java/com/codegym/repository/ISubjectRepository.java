package com.codegym.repository;

import com.codegym.entity.about_schedule.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
//    @Query(value = "", nativeQuery = true)
//    List<Subject>
}
