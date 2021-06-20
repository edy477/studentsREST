package com.example.enrollment.repository;
import com.example.enrollment.model.StudentsEntity;
import  com.example.enrollment.model.EnrollmentEntity;
import  com.example.enrollment.model.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<StudentsEntity , UUID> {

    public List<EnrollmentEntity> allEnrollments = new ArrayList<>();

    @Query("SELECT r.courseEnrollments FROM EnrollmentEntity r where r.studentEnrollment.id = :id")
    List<CoursesEntity> findAllCourses(@Param("id") UUID name);




    //String findNameById(@Param("id") UUID id);


    /*public default List<EnrollmentEntity> getAllEnrollments(){

    }
*/

}
