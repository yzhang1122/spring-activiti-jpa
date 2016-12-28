package com.yzhang.service;

import com.yzhang.domain.Applicant;
import com.yzhang.domain.Person;
import com.yzhang.domain.Student;
import com.yzhang.repository.ApplicantRepository;
import com.yzhang.repository.CarRepository;
import com.yzhang.repository.DepartmentRepository;
import com.yzhang.repository.PersonRepository;

import org.activiti.engine.delegate.BpmnError;
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

  public void savePeron() {

    logger.info("in method savePeron..");

    Person p = new Person();
    p.setFirstName("Mike");
    p.setLastName("Lin");
    p.setCity("Daly city");
    p.setAddress("123 main st");
    personRepository.save(p);
  }


  public void saveApplicant() {
    logger.info("in method saveApplicant..");
    //throw new BpmnError("errorCode1");
    Applicant applicant = new Applicant("Johnny", "wer@ew.com", "2323434533");
    applicantRepository.save(applicant);

  }

  public void saveCar() {
    logger.info("in method saveCar..");

    Person p = new Person();
    p.setFirstName("Henry");
    p.setLastName("Port");
    p.setCity("San Francisco");
    p.setAddress("222 main st");
    personRepository.save(p);

  }


  public void printResult(Object person, Object applicant) {
    logger.info("in method printResult..");
    //throw new BpmnError("Ops");
    //Person p = (Person)person;
    //Applicant app = (Applicant)applicant;

    //logger.info(p.toString());
    //logger.info(app.toString());

  }

  public void handleError() {
    logger.info("in method handleError..");

  }


  public void handleDifferentError() {
    logger.info("in method handleDifferentError..");

  }


}
