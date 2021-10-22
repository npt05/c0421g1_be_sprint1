package com.codegym.repository;

import com.codegym.entity.about_student.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMarkRepository extends JpaRepository<Mark, Integer> {
    @Query(value = "SELECT mark.mark_id, student.student_id,student.student_date_of_birth,classroom.classroom_name,mark.mark_point_number1,mark.mark_point_number2,mark.mark_point_number3\n" +
            "FROM mark\n" +
            "JOIN student ON student.student_id = mark.mark_id\n" +
            "JOIN classroom ON classroom.classroom_id = student.student_id\n" +
            "JOIN `subject` ON `subject`.subject_id = mark.mark_id ", nativeQuery = true)
    List<Mark> getAllMarkStudent();

    @Query(value = "UPDATE mark as m\n" +
            "SET m.point_number1=?1, m.point_number2=?2, m.point_number3=?3 \n" +
            "WHERE m.mark_id =?4 ", nativeQuery = true)
    void editMark(Double point1, Double point2, Double point3, Integer id);
}
