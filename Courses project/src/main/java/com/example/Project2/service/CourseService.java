package com.example.Project2.service;

// This is the service layer.
// This layer consists of all our business logic
//Dependency injection of repository layer is injected in this layer

import com.example.Project2.model.Courses;
import com.example.Project2.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseServiceInterface {
   // Constructor injection using lombok
    private final CourseRepository courseRepository;


    @Override
    public Courses create(Courses courses) {
        return courseRepository.save(courses);          // Here we are saving the course using the save method inside the CRUD repo
    }

    @Override
    public List<Courses> readAll()
    {
        return (List<Courses>) courseRepository.findAll();      // Here we are returning a list of courses
    }

    public Courses readById(long id)
    {
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("Runtime Exception occured"));       // Here we are using the method findById to find a particular course by id
    }

    @Override
    public Courses updateById(Courses courses, long id) {
        Courses updatedCourse = courseRepository.findById(id).orElseThrow(()->new RuntimeException("A runtime exception error occurred"));
        updatedCourse.setCourseName(courses.getCourseName());
        updatedCourse.setCourseLength(courses.getCourseLength());
        updatedCourse.setNumberOfStudentsEnrolled(courses.getNumberOfStudentsEnrolled());
        courseRepository.save(updatedCourse);       // Saving our updatedCourse inside the repository

        return updatedCourse;
    }

    @Override
    public void deleteById(long id)
    {
        courseRepository.findById(id).orElseThrow(()->new RuntimeException("A runtime exception error occurred"));  //Checking if course exists

        courseRepository.deleteById(id); // Deleting employee
    }


}
