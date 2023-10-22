package com.niltech.ShivajiSchool.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.niltech.ShivajiSchool.constants.ShivajiSchoolConstants;
import com.niltech.ShivajiSchool.model.Person;
import com.niltech.ShivajiSchool.model.Roles;
import com.niltech.ShivajiSchool.repository.PersonRepository;
import com.niltech.ShivajiSchool.repository.RolesRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(ShivajiSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}

