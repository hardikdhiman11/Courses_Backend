package com.example.Project2.model;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "final_table")
public class Courses
{
    @Id         //Primary key as courseName
    @GeneratedValue(strategy =GenerationType.IDENTITY)      // Creating a strategy for generation of primary key
    private long SrNo;


    @Column(name = "Course_Name",nullable = false)
    private String courseName;

    @Column(name="Course_Length",nullable = false)
    private long courseLength;

    @Column(name="Number_of_students_enrolled",nullable = false)
    private long numberOfStudentsEnrolled;

}