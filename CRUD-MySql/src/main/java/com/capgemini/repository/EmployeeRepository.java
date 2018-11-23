package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.beans.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
