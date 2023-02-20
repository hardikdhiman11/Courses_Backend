package com.example.Project2.repository;

import com.example.Project2.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Courses,Long>
        //This connects to database on one end and to service layer on another end
{

}
