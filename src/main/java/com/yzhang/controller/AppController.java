package com.yzhang.controller;

import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  private static final Logger logger = LoggerFactory.getLogger(AppController.class);

  @Autowired
  private RuntimeService runtimeService;


  @RequestMapping(value = "/jpa", method = RequestMethod.GET)
  public void testJpa() {

    runtimeService.startProcessInstanceByKey("myProcess");
  }
}
