package com.nopaper.work.master.reactive.services;

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
import com.nopaper.work.master.models.State;
import com.nopaper.work.master.models.SubCategory;
import com.nopaper.work.master.models.TimeZone;
import com.nopaper.work.master.models.Unit;
import com.nopaper.work.master.reactive.repositories.CategoryReactiveRepository;
import com.nopaper.work.master.reactive.repositories.CityReactiveRepository;
import com.nopaper.work.master.reactive.repositories.CountryReactiveRepository;
import com.nopaper.work.master.reactive.repositories.CurrencyReactiveRepository;
import com.nopaper.work.master.reactive.repositories.GradeSystemReactiveRepository;
import com.nopaper.work.master.reactive.repositories.LocalityReactiveRepository;
import com.nopaper.work.master.reactive.repositories.ProductReactiveRepository;
import com.nopaper.work.master.reactive.repositories.ProductSpecificationReactiveRepository;
import com.nopaper.work.master.reactive.repositories.RelationsReactiveRepository;
import com.nopaper.work.master.reactive.repositories.StateReactiveRepository;
import com.nopaper.work.master.reactive.repositories.SubCategoryReactiveRepository;
import com.nopaper.work.master.reactive.repositories.TimeZoneReactiveRepository;
import com.nopaper.work.master.reactive.repositories.UnitReactiveRepository;

import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@CacheConfig(cacheNames = "master")
public class MasterReactiveService implements IMasterReactiveService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterReactiveService.class);

	@Autowired
	private CityReactiveRepository cityRepository;

	@Autowired
	private CountryReactiveRepository countryRepository;

	@Autowired
	private StateReactiveRepository stateRepository;

	@Autowired
	private CurrencyReactiveRepository currencyRepository;

	@Autowired
	private UnitReactiveRepository unitRepository;

	@Autowired
	private TimeZoneReactiveRepository timeZoneRepository;

	@Autowired
	private LocalityReactiveRepository localityRepository;
	
	@Autowired
	private GradeSystemReactiveRepository gradeSystemRepository;
	
	@Autowired
	private CategoryReactiveRepository categoryRepository;

	@Autowired
	private SubCategoryReactiveRepository subCategoryRepository;

	@Autowired
	private ProductReactiveRepository productRepository;
	
	@Autowired
	private ProductSpecificationReactiveRepository productSpecificationRepository;
	
	/*
	 * CACHE DETAILS for list of informations
	 */

	@Cacheable(cacheNames = "Currency")
	@Override
	public Flux<Currency> getCurrencyList() {
		return currencyRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Unit")
	@Override
	public Flux<Unit> getUnitList() {
		return unitRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Country")
	@Override
	public Flux<Country> getCountryList() {
		return countryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "State")
	@Override
	public Flux<State> getStateList() {
		return stateRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "City")
	@Override
	public Flux<City> getCityList() {
		return cityRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Locality")
	@Override
	public Flux<Locality> getLocalityList() {
		return localityRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "TimeZone")
	@Override
	public Flux<TimeZone> getTimeZoneList() {
		return timeZoneRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "State")
	@Override
	public Flux<State> getStateListByCountryId(UUID id, String status) {
		return stateRepository.getStateListByCountryId(id, status);
	}

	@Cacheable(cacheNames = "City")
	@Override
	public Flux<City> getCityListByStateId(UUID id, String status) {
		return cityRepository.getCityListByStateId(id, status);
	}
	
	@Cacheable(cacheNames = "GradeSystem")
	@Override
	public Flux<GradeSystem> getGradeSystemList() {
		return gradeSystemRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}
	
	@Cacheable(cacheNames = "Category")
	@Override
	public Flux<Category> getCategoryList() {
		return categoryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}
	
	@Cacheable(cacheNames = "SubCategory")
	@Override
	public Flux<SubCategory> getSubCategoryList() {
		return subCategoryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Product")
	@Override
	public Flux<Product> getProductList() {
		return productRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "ProductSpecification")
	@Override
	public Flux<ProductSpecification> getProductSpecificationList() {
		return productSpecificationRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}
	
	/*
	 * GET details by ID
	 */
	
	@Override
	public Mono<Currency> getCurrencyById(UUID id) {
		return currencyRepository.findById(id);
	}

	@Override
	public Mono<Unit> getUnitById(UUID id) {
		return unitRepository.findById(id);
	}

	@Override
	public Mono<Country> getCountryById(UUID id) {
		return countryRepository.findById(id);
	}

	@Override
	public Mono<State> getStateById(UUID id) {
		return stateRepository.findById(id);
	}

	@Override
	public Mono<City> getCityById(UUID id) {
		return cityRepository.findById(id);
	}

	@Override
	public Mono<TimeZone> getTimeZoneById(UUID id) {
		return timeZoneRepository.findById(id);
	}

	@Override
	public Mono<Locality> getLocalityById(@NotNull UUID id) {
		return localityRepository.findById(id);
	}
	
	@Override
	public Mono<GradeSystem> getGradeSystemById(@NotNull UUID id) {
		return gradeSystemRepository.findById(id);
	}
	
	@Override
	public Mono<Category> getCategoryById(UUID id) {
		return categoryRepository.findById(id);
	}
	
	@Override
	public Mono<SubCategory> getSubCategoryById(UUID id) {
		return subCategoryRepository.findById(id);
	}
	
	@Override
	public Mono<Product> getProductById(UUID id) {
		return productRepository.findById(id);
	}
	
	
	@Override
	public Mono<ProductSpecification> getProductSpecificationById(UUID id) {
		return productSpecificationRepository.findById(id);
	}
	
}
