package com.niltech.ShivajiSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niltech.ShivajiSchool.model.Roles;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles getByRoleName(String roleName);
}
