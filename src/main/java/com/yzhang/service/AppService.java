package com.yzhang.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppService {
  private static final Logger logger = LoggerFactory.getLogger(AppService.class);

  public void startProcess() {
    logger.info("in the process");
  }
}
