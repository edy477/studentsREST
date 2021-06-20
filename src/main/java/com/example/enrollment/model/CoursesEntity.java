package com.example.enrollment.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses", schema = "enrolled", catalog = "enrollment")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="courseId")
public class CoursesEntity implements Serializable {
    private String courseName;
    private String created;
    private String category;




    @Id
    @Column(name = "course_id", nullable = false)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID  courseId;




    private Timestamp startDate;

}
