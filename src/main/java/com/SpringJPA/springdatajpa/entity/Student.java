package com.SpringJPA.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email_address")
) // Creates table name according to name
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false
    )  // Creates column name according to name
    private String email;

    @Embedded
    private Guardian guardian;

}
