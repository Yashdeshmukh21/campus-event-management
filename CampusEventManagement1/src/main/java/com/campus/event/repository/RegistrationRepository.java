package com.campus.event.repository;

import com.campus.event.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    // Custom finder methods
    List<Registration> findByUser_Id(Long userId);

    List<Registration> findByEvent_Id(Long eventId);
}
