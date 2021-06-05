package test.hrms2.business.abstracts;

import java.util.List;

import test.hrms2.core.results.DataResult;
import test.hrms2.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> findAll();
}
