package com.niltech.ShivajiSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.niltech.ShivajiSchool.model.Courses;

import java.util.List;

@Repository
//@RepositoryRestResource(exported = false)
@RepositoryRestResource(path = "courses")
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    /*
    Spring Data JPA allows us to apply static sorting by adding the OrderBy keyword
    to the method name along with the property name and sort direction (Asc or Desc).
    * */
    List<Courses> findByOrderByNameDesc();

    /*
    The Asc keyword is optional as OrderBy, by default,
    sorts the results in the ascending order.
    * */
    List<Courses> findByOrderByName();
}

