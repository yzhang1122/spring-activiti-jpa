package com.yzhang.service;

import com.yzhang.domain.Applicant;
import com.yzhang.domain.Person;
import com.yzhang.model.Student;
import com.yzhang.repository.ApplicantRepository;
import com.yzhang.repository.CarRepository;
import com.yzhang.repository.DepartmentRepository;
import com.yzhang.repository.PersonRepository;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.TooltipBuilder;

@Component
public class AppService implements ActivityBehavior {
  private static final Logger logger = LoggerFactory.getLogger(AppService.class);

  @Autowired
  private CarRepository carRepository;
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private ApplicantRepository applicantRepository;

  public AppService() {

  }

  public void checkCondition() {
    logger.info("------> in the process of check condition");
  }

  public void startProcessWithOutParam() {
    logger.info("------> in the process without param");
  }


  public void startProcessWithParam() {
    logger.info("------> in the process with param");
  }


  public void finalTask() {
    logger.info("------> in the process of finalTask");
  }

  public void savePeron() {

    logger.info("in method savePeron..");

    Person p = new Person();
    p.setFirstName("Harry");
    p.setLastName("Liang");
    p.setCity("San Francisco");
    p.setAddress("595 Mission St");
    personRepository.save(p);
    throw new BpmnError("errorCode1");

  }


  public void saveApplicant() {
    logger.info("in method saveApplicant..");
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


  public void handleException() {
    logger.info("in method handleException..");

  }

  public void savePersonManually() {
    logger.info("in method savePersonManually..");
    Person p = new Person();
    p.setFirstName("Harry");
    p.setLastName("Manually");
    p.setCity("San Francisco");
    p.setAddress("71 stevenson st");
    personRepository.save(p);

  }

  public void processStudent(Object student) {
    Student s = (Student) student;
    logger.info("in method processStudent name");
    logger.info(student.toString());
    s.setName("ssdfsdfsd");

  }


  public void processStudent1(Object student) {
    Student s = (Student) student;
    logger.info("in method processStudent age");
    logger.info(student.toString());
    s.setAge(12213);
    throw  new BpmnError("errorCode1");

  }


  public void handleStudentError(Object student) {
    Student s = (Student) student;
    logger.info("in method handleStudentError");
    logger.info(student.toString());
  }


  @Override
  public void execute(ActivityExecution activityExecution) throws Exception {
    logger.info("in method execute..");
    PvmTransition transition = null;
    try {
      savePeron();
      transition = activityExecution.getActivity().findOutgoingTransition("flow3");
    } catch (Throwable e) {
      e.printStackTrace();
      transition = activityExecution.getActivity().findOutgoingTransition("flow12");
    }
    activityExecution.take(transition);
  }
}
