package com.yzhang.controller;

import com.yzhang.domain.Student;

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
    Student s1 = new Student("Sam", 11, "Math");
    Student s2 = new Student("Jack", 12, "English");
    Boolean condition = true;
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("p1", s1);
    map.put("p2", s2);
    map.put("condition", condition);
    runtimeService.startProcessInstanceByKey("myProcess", map);

    logger.info(s1.toString());
    logger.info(s2.toString());
  }
}
