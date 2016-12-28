package com.yzhang.service;

import com.yzhang.domain.Student;
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


  public boolean checkCondition(Object condition) {
    logger.info("in the process of check condition");

    return (Boolean) condition;
  }

  public void startProcessWithOutParam() {
    logger.info("in the process without param");
  }


  public void startProcessWithParam(Object p1, Object p2) {
    logger.info("in the process with param");
    logger.info("------>");
    Student a1 = (Student) p1;
    Student a2 = (Student) p2;

    logger.info(a1.toString());
    logger.info(a2.toString());

    a1.setAge(22);
    a2.setAge(32);

  }

}
