package com.example.Project2.service;

import com.example.Project2.model.Courses;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface
{
   //Method for Posting a new Course
    Courses create(Courses courses);

    List<Courses> readAll();

    Courses readById(long id);
    Courses updateById(Courses courses, long id);
    void deleteById(long id);





}
