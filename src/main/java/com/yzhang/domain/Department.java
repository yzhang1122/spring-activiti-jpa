package com.yzhang.domain;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "test")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "dept_name")
  private String departmentName;

  @Column(name = "dept_desc")
  private String departmentDesc;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "departments")
  private Set<Person> persons;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentDesc() {
    return departmentDesc;
  }

  public void setDepartmentDesc(String departmentDesc) {
    this.departmentDesc = departmentDesc;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }

  @Override
  public String toString() {
    return "Department{" +
        "id=" + id +
        ", departmentName='" + departmentName + '\'' +
        ", departmentDesc='" + departmentDesc + '\'' +
        '}';
  }
}