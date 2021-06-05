package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.CityService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.dataAccess.abstracts.CityDao;
import test.hrms2.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> findAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler başarıyla listelendi.");
	}
}
