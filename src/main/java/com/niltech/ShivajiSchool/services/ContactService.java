package com.niltech.ShivajiSchool.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.niltech.ShivajiSchool.config.ShivajiSchoolProps;
import com.niltech.ShivajiSchool.constants.ShivajiSchoolConstants;
import com.niltech.ShivajiSchool.model.Contact;
import com.niltech.ShivajiSchool.repository.ContactRepository;


@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    ShivajiSchoolProps eazySchoolProps;

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ShivajiSchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(null != savedContact && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = eazySchoolProps.getPageSize();
        if(null!=eazySchoolProps.getContact() && null!=eazySchoolProps.getContact().get("pageSize")){
            pageSize = Integer.parseInt(eazySchoolProps.getContact().get("pageSize").trim());
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatusWithQuery(
                ShivajiSchoolConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatusNative(ShivajiSchoolConstants.CLOSE,contactId);
        if(rows > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }

}

