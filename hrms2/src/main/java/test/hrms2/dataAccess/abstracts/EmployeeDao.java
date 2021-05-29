package test.hrms2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import test.hrms2.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
