package com.vijay.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vijay.model.Employee;

//@Repository
public interface EmpRepository extends MongoRepository<Employee, String>{

}
