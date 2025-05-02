package com.shroti.Assignments.Assignment4;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnquiryRepository extends JpaRepository<EnquiriesEntity, Integer> {
//    List<EnquiriesEntity>findById(int enquiry_id);
    List<EnquiriesEntity> findByName(String Name);
    List<EnquiriesEntity> findByStatus(String status);
}
