package com.nopaper.work.master.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nopaper.work.master.constant.MasterConstant;
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

import jakarta.validation.constraints.NotNull;

@Service
@CacheConfig(cacheNames = "master")
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
	
	/*
	 * CACHE DETAILS for list of informations
	 */

	@Cacheable(cacheNames = "Currency")
	@Override
	public List<Currency> getCurrencyList() {
		return currencyRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Unit")
	@Override
	public List<Unit> getUnitList() {
		return unitRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Country")
	@Override
	public List<Country> getCountryList() {
		return countryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "State")
	@Override
	public List<State> getStateList() {
		return stateRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "City")
	@Override
	public List<City> getCityList() {
		return cityRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Locality")
	@Override
	public List<Locality> getLocalityList() {
		return localityRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "TimeZone")
	@Override
	public List<TimeZone> getTimeZoneList() {
		return timeZoneRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "State")
	@Override
	public List<State> getStateListByCountryId(UUID id, String status) {
		return stateRepository.getStateListByCountryId(id, status);
	}

	@Cacheable(cacheNames = "City")
	@Override
	public List<City> getCityListByStateId(UUID id, String status) {
		return cityRepository.getCityListByStateId(id, status);
	}
	
	@Cacheable(cacheNames = "GradeSystem")
	@Override
	public List<GradeSystem> getGradeSystemList() {
		return gradeSystemRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}
	
	@Cacheable(cacheNames = "Category")
	@Override
	public List<Category> getCategoryList() {
		return categoryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}
	
	@Cacheable(cacheNames = "SubCategory")
	@Override
	public List<SubCategory> getSubCategoryList() {
		return subCategoryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Product")
	@Override
	public List<Product> getProductList() {
		return productRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "ProductSpecification")
	@Override
	public List<ProductSpecification> getProductSpecificationList() {
		return productSpecificationRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}
	
	/*
	 * GET details by ID
	 */
	
	@Override
	public Currency getCurrencyById(UUID id) {
		return currencyRepository.findById(id).orElse(null);
	}

	@Override
	public Unit getUnitById(UUID id) {
		return unitRepository.findById(id).orElse(null);
	}

	@Override
	public Country getCountryById(UUID id) {
		return countryRepository.findById(id).orElse(null);
	}

	@Override
	public State getStateById(UUID id) {
		return stateRepository.findById(id).orElse(null);
	}

	@Override
	public City getCityById(UUID id) {
		return cityRepository.findById(id).orElse(null);
	}

	@Override
	public TimeZone getTimeZoneById(UUID id) {
		return timeZoneRepository.findById(id).orElse(null);
	}

	@Override
	public Locality getLocalityById(@NotNull UUID id) {
		return localityRepository.findById(id).orElse(null);
	}
	
	@Override
	public GradeSystem getGradeSystemById(@NotNull UUID id) {
		return gradeSystemRepository.findById(id).orElse(null);
	}
	
	@Override
	public Category getCategoryById(UUID id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	@Override
	public SubCategory getSubCategoryById(UUID id) {
		return subCategoryRepository.findById(id).orElse(null);
	}
	
	@Override
	public Product getProductById(UUID id) {
		return productRepository.findById(id).orElse(null);
	}
	
	
	@Override
	public ProductSpecification getProductSpecificationById(UUID id) {
		return productSpecificationRepository.findById(id).orElse(null);
	}
	
	/*
	 * CREATE STATEMENT
	 */
	
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
