package com.yzhang.service;

import com.yzhang.domain.Applicant;
import com.yzhang.repository.ApplicantRepository;
import com.yzhang.repository.CarRepository;
import com.yzhang.repository.DepartmentRepository;
import com.yzhang.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppService {
  private static final Logger logger = LoggerFactory.getLogger(AppService.class);

  @Autowired
  CarRepository carRepository;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private DepartmentRepository departmentRepository;


  @Autowired
  private ApplicantRepository applicantRepository;

  public void startProcess() {
    Applicant a = new Applicant("Yi", "sdfs@dsfds.com", "234232343");
    applicantRepository.save(a);
    logger.info("in the process");
  }
}
