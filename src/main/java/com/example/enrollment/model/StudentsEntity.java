package com.example.enrollment.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import  com.example.enrollment.model.EnrollmentEntity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students", schema = "enrolled")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class StudentsEntity implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY,generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "student_id", nullable = false)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID id;

    private  String first_name;

    private  String last_name;

    private  String username;

    private  String email;

    private String password;
    private String dateOfBirth;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEnrollment")
    private List<EnrollmentEntity> enrollments = new ArrayList<>();





}
