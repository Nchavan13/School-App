package com.niltech.ShivajiSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niltech.ShivajiSchool.model.ShivajiClass;


@Repository
public interface ShivajiClassRepository extends JpaRepository<ShivajiClass, Integer> {

}
