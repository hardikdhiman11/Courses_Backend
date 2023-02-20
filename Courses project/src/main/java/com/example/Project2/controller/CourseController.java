package com.example.Project2.controller;

import com.example.Project2.exception.MyExceptionHandler;
import com.example.Project2.model.Courses;
import com.example.Project2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


//This is our Controller or Presentation layer
// In this layer we inject dependency of Service layer
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController
{
    //Constructor injection
    private final CourseService courseService;




    // Creating a new course
    @PostMapping
    public ResponseEntity<Courses> create(@RequestBody Courses courses)
    {
        return new ResponseEntity<Courses>(courseService.create(courses), HttpStatus.CREATED);
    }

    // Reading all courses
    @GetMapping
    public List<Courses> readAll()
    {
        return courseService.readAll();
    }

    //Reading courses by id
    @GetMapping("{id}")
    public ResponseEntity<Courses>  readById(@PathVariable("id") long courseID)
    {
        return new ResponseEntity<Courses>(courseService.readById(courseID),HttpStatus.CREATED);
    }

    //Updating courses by id
    @PutMapping("{id}")
    public ResponseEntity<Courses> updateById(@PathVariable("id") long courseID,@RequestBody Courses courses)
    {
        return new ResponseEntity<Courses>(courseService.updateById(courses, courseID), HttpStatus.CREATED);

    }

    //Deleting courses by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long courseID)
    {
        courseService.deleteById(courseID);
        return new ResponseEntity<String>("Employee Deleted successfully",HttpStatus.OK);
    }



}
