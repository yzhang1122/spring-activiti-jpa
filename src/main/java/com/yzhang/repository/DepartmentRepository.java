package com.yzhang.repository;


import com.yzhang.domain.Department;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
  Department findById(Long id);
}