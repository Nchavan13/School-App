package com.niltech.ShivajiSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niltech.ShivajiSchool.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person readByEmail(String email);

}
