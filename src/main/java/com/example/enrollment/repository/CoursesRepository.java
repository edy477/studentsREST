package com.example.enrollment.repository;

import com.example.enrollment.model.CoursesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface CoursesRepository extends CrudRepository<CoursesEntity , UUID> {

    @Query("select s from CoursesEntity s where s.courseName = :name")
    CoursesEntity findByName(@Param("name") String name);



}
