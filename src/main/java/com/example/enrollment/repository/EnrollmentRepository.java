package com.example.enrollment.repository;

import com.example.enrollment.model.CoursesEntity;
import com.example.enrollment.model.EnrollmentEntity;
import com.example.enrollment.model.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface EnrollmentRepository extends CrudRepository<EnrollmentEntity , UUID> {


    @Query("select s from EnrollmentEntity s where s.student_id = :student_id and s.course_id = :course_id")
    EnrollmentEntity findAllByOther(@Param("student_id") UUID student_id, @Param("course_id") UUID course_id);








}
