package com.codegym.repository;

import com.codegym.entity.about_teacher.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IDegreeRepository extends JpaRepository<Degree,Integer> {
    @Query(value = "select degree_name from degree ",nativeQuery = true)
    List<Degree> findDegreeAll();


}
