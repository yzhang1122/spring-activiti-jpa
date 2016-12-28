package com.yzhang.repository;

import com.yzhang.domain.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

  Person findById(Long id);
}
