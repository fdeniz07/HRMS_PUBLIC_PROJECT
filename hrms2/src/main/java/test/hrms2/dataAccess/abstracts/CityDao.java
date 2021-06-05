package test.hrms2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.hrms2.entities.concretes.City;
@Repository
public interface CityDao extends JpaRepository<City, Integer>{

}
