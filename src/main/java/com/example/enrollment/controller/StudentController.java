package com.example.enrollment.controller;

import com.example.enrollment.repository.CoursesRepository;
import com.example.enrollment.repository.UserRepository;
import com.example.enrollment.model.StudentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.enrollment.repository.EnrollmentRepository;
import com.example.enrollment.model.EnrollmentEntity;
import com.example.enrollment.model.CoursesEntity;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController
{

    @Autowired
    private UserRepository studentRepository;

    @Autowired
    private EnrollmentRepository studentEnrollments;

    @Autowired
    private CoursesRepository courses;


    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
    @GetMapping
    public List<StudentsEntity> findAllStudents() {
        return (List<StudentsEntity>) studentRepository.findAll();
        // Implement
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentsEntity> findStudentById(@PathVariable(value = "id") UUID id) {
        Optional<StudentsEntity> student = studentRepository.findById(id);

        if(student.isPresent()) {
            return ResponseEntity.ok().body(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public StudentsEntity createStudent(@Validated @RequestBody StudentsEntity student) {
        return studentRepository.save(student);
    }


    @GetMapping("/{id}/enrollments")
    public List<CoursesEntity> findAllEnrollments(@PathVariable(value = "id") UUID id) {
        List<CoursesEntity> listEnroll = studentRepository.findAllCourses(id);
        return studentRepository.findAllCourses(id);

    }


    @PostMapping("/{id}/enrollments")
    public EnrollmentEntity addEnrollments(@Validated @RequestBody List<EnrollmentEntity> enrolls, @PathVariable UUID id) {
        enrolls.stream().forEach(elt -> elt.setStudent_id(id));
        return (EnrollmentEntity) studentEnrollments.saveAll(enrolls);

    }


    @PostMapping("/{id}/enrollments?course={course}")
    public EnrollmentEntity addEnrollVerbose(@Validated @RequestBody EnrollmentEntity enroll, @PathVariable UUID id,@PathVariable String course) {
        UUID course_id = courses.findByName(course).getCourseId();
        enroll.setStudent_id(id);
        enroll.setStudent_id(course_id);
        return studentEnrollments.save(enroll);


    }

/*
    @DeleteMapping("/{id}/enrollments?course={course}")
    public EnrollmentEntity unsuscribeEnrollment(@PathVariable(value = "id") UUID id, @PathVariable(value = "course") String course) {
        UUID course_id = courses.findByName(course).getCourseId();
        EnrollmentEntity ste = studentEnrollments.findAllByOther(id,course_id);

        //return (EnrollmentEntity) studentEnrollments.delete(ste);

    }*/


















}

