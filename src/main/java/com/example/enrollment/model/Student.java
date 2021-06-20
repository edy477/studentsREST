package com.example.enrollment.model;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="students")
public class Student  {


    @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY,generator = "UUID")
        @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
        )
        @Column(name = "student_id", updatable = false, nullable = false)
        @Type(type="org.hibernate.type.PostgresUUIDType")
        private UUID id;


    private  String first_name;

    private  String last_name;

    private  String username;

    private  String email;

   /* @OneToOne
    @JoinColumn(name = "student_id")
    private Enrollment enrollment;

*/
}
