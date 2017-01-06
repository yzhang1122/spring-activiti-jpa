package com.yzhang.controller;

import com.yzhang.model.Student;

import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

  private static final Logger logger = LoggerFactory.getLogger(AppController.class);

  @Autowired
  private RuntimeService runtimeService;


  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public void testJpa() {
    runtimeService.startProcessInstanceByKey("myProcess");

  }


  @RequestMapping(value = "/test1", method = RequestMethod.GET)
  public void test() {
    runtimeService.startProcessInstanceByKey("transactionTest");
  }

  @RequestMapping(value = "/test2", method = RequestMethod.GET)
  public void testError() {
    runtimeService.startProcessInstanceByKey("errorHandler");
  }


  @RequestMapping(value = "/transaction", method = RequestMethod.GET)
  public void testTransactionError() {
    runtimeService.startProcessInstanceByKey("transactionEvent");
  }

  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public void testDataProcess() {
    Map<String, Object> map = new HashMap<String, Object>();
    Student s = new Student("Yi", 11);
    map.put("student", s);
    runtimeService.startProcessInstanceByKey("studentProcess", map);
    logger.info("finally: " + s.toString());
  }
}
