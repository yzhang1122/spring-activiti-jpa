package com.yzhang.domain;

import java.io.Serializable;

public class Student implements Serializable {
  String name;
  int age;
  String subject;

  public Student(String name, int age, String subject) {
    this.name = name;
    this.age = age;
    this.subject = subject;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", subject='" + subject + '\'' +
        '}';
  }
}
