package com.syn.datawork.writer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syn.datawork.writer.model.Employee;





public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
