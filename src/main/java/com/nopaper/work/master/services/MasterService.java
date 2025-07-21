package com.nopaper.work.master.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nopaper.work.master.models.Category;
import com.nopaper.work.master.models.City;
import com.nopaper.work.master.models.Country;
import com.nopaper.work.master.models.Currency;
import com.nopaper.work.master.models.GradeSystem;
import com.nopaper.work.master.models.Locality;
import com.nopaper.work.master.models.Product;
import com.nopaper.work.master.models.ProductSpecification;
import com.nopaper.work.master.models.Relations;
import com.nopaper.work.master.models.State;
import com.nopaper.work.master.models.SubCategory;
import com.nopaper.work.master.models.TimeZone;
import com.nopaper.work.master.models.Unit;
import com.nopaper.work.master.repositories.CategoryRepository;
import com.nopaper.work.master.repositories.CityRepository;
import com.nopaper.work.master.repositories.CountryRepository;
import com.nopaper.work.master.repositories.CurrencyRepository;
import com.nopaper.work.master.repositories.GradeSystemRepository;
import com.nopaper.work.master.repositories.LocalityRepository;
import com.nopaper.work.master.repositories.ProductRepository;
import com.nopaper.work.master.repositories.ProductSpecificationRepository;
import com.nopaper.work.master.repositories.RelationsRepository;
import com.nopaper.work.master.repositories.StateRepository;
import com.nopaper.work.master.repositories.SubCategoryRepository;
import com.nopaper.work.master.repositories.TimeZoneRepository;
import com.nopaper.work.master.repositories.UnitRepository;

@Service
public class MasterService implements IMasterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterService.class);

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private UnitRepository unitRepository;

	@Autowired
	private TimeZoneRepository timeZoneRepository;

	@Autowired
	private LocalityRepository localityRepository;

	@Autowired
	private RelationsRepository relationsRepository;

	@Autowired
	private GradeSystemRepository gradeSystemRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductSpecificationRepository productSpecificationRepository;


	@Override
	public Currency createCurrency(Currency postRequest) {
		return currencyRepository.saveAndFlush(postRequest);
	}

	@Override
	public State createState(State postRequest) {
		return stateRepository.saveAndFlush(postRequest);
	}

	@Override
	public Country createCountry(Country postRequest) {
		return countryRepository.saveAndFlush(postRequest);
	}

	@Override
	public City createCity(City postRequest) {
		return cityRepository.saveAndFlush(postRequest);
	}

	@Override
	public Unit createUnit(Unit postRequest) {
		return unitRepository.saveAndFlush(postRequest);
	}

	@Override
	public TimeZone createTimeZone(TimeZone postRequest) {
		return timeZoneRepository.saveAndFlush(postRequest);
	}

	@Override
	public Locality createLocality(Locality postRequest) {
		return localityRepository.saveAndFlush(postRequest);
	}

	@Override
	public Relations createRelations(Relations postRequest) {
		return relationsRepository.saveAndFlush(postRequest);
	}

	@Override
	public GradeSystem createGradeSystem(GradeSystem postRequest) {
		return gradeSystemRepository.saveAndFlush(postRequest);
	}

	@Override
	public Category createCategory(Category postRequest) {
		return categoryRepository.saveAndFlush(postRequest);
	}

	@Override
	public SubCategory createSubCategory(SubCategory postRequest) {
		return subCategoryRepository.saveAndFlush(postRequest);
	}

	@Override
	public Product createProduct(Product postRequest) {
		return productRepository.saveAndFlush(postRequest);
	}

	@Override
	public ProductSpecification createProductSpecification(ProductSpecification postRequest) {
		return productSpecificationRepository.saveAndFlush(postRequest);
	}

}
