package com.yzhang.repository;


import com.yzhang.domain.Car;
import com.yzhang.domain.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

  List<Car> findByPerson(Person p);

}
