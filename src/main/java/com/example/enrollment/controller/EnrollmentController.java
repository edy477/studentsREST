package com.example.enrollment.controller;


import com.example.enrollment.repository.EnrollmentRepository;
import com.example.enrollment.model.EnrollmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController
{
    @Autowired
    private EnrollmentRepository enrollmentsRepository;

    @RequestMapping("/")
    public String home(){
        return "Nothing tho se here";
    }

    @GetMapping
    public List<EnrollmentEntity> findAllEnrollments() {
        return (List<EnrollmentEntity>) enrollmentsRepository.findAll();


    }


}
