package com.UHGUsecase.ContactUsService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UHGUsecase.ContactUsService.Entity.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {

}
