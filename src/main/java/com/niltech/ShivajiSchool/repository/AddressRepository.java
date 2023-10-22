package com.niltech.ShivajiSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niltech.ShivajiSchool.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
