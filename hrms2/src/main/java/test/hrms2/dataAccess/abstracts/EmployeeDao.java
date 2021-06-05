package test.hrms2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	Employee findById(int id);


}
