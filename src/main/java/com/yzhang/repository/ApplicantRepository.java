package com.yzhang.repository;

import com.yzhang.domain.Applicant;

import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

}