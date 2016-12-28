package com.yzhang.controller;

import com.yzhang.domain.Applicant;
import com.yzhang.repository.ApplicantRepository;
import com.yzhang.repository.CarRepository;
import com.yzhang.repository.DepartmentRepository;
import com.yzhang.repository.PersonRepository;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @Autowired
  CarRepository carRepository;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private DepartmentRepository departmentRepository;


  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private RuntimeService runtimeService;


  @RequestMapping(value = "/jpa", method = RequestMethod.GET)
  public void testJpa() {
    Applicant a = new Applicant("Yi", "sdfs@dsfds.com", "234232343");
    applicantRepository.save(a);
    runtimeService.startProcessInstanceByKey("myProcess");
  }
}
