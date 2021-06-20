package com.example.enrollment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrollment", schema = "enrolled", catalog = "enrollment")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="enrollmentId")
public class EnrollmentEntity implements Serializable {

    @Id
    @Column(name = "enrollment_id", nullable = false)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID enrollmentId;



    @Column(name = "student_id", insertable = false, updatable = false)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID student_id;


    @Column(name = "course_id", insertable = false, updatable = false)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID course_id;



    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private  StudentsEntity studentEnrollment;


    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private  CoursesEntity courseEnrollments;




}
