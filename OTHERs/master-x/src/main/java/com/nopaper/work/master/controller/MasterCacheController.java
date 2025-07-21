package com.nopaper.work.master.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nopaper.work.master.dto.CategoryDTO;
import com.nopaper.work.master.dto.CityDTO;
import com.nopaper.work.master.dto.CountryDTO;
import com.nopaper.work.master.dto.CurrencyDTO;
import com.nopaper.work.master.dto.GradeSystemDTO;
import com.nopaper.work.master.dto.LocalityDTO;
import com.nopaper.work.master.dto.ProductDTO;
import com.nopaper.work.master.dto.ProductSpecificationDTO;
import com.nopaper.work.master.dto.StateDTO;
import com.nopaper.work.master.dto.SubCategoryDTO;
import com.nopaper.work.master.dto.TimeZoneDTO;
import com.nopaper.work.master.dto.UnitDTO;
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
import com.nopaper.work.master.services.IMasterService;

import jakarta.validation.constraints.NotNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${v1API}/list")
@Validated
public class MasterCacheController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterCacheController.class);

	@Autowired
	private IMasterService masterService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(value = { "getCurrencyById/{id}" }, produces = "application/json")
	public ResponseEntity<CurrencyDTO> getCurrencyById(@NotNull @PathVariable("id") UUID id) throws Exception {
		Currency currency = masterService.getCurrencyById(id);
		CurrencyDTO postResponse = mapper.map(currency, CurrencyDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getCurrencyList" }, produces = "application/json")
	public ResponseEntity<List<CurrencyDTO>> getCurrencyList() throws Exception {
		List<Currency> currency = masterService.getCurrencyList();
		List<CurrencyDTO> postResponse = mapper.map(currency, new TypeToken<List<CurrencyDTO>>() {
		}.getType());

		if (currency != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getUnitById/{id}" }, produces = "application/json")
	public ResponseEntity<UnitDTO> getUnitById(@NotNull @PathVariable("id") UUID id) throws Exception {
		Unit unit = masterService.getUnitById(id);
		UnitDTO postResponse = mapper.map(unit, UnitDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getUnitList" }, produces = "application/json")
	public ResponseEntity<List<UnitDTO>> getUnitList() throws Exception {
		List<Unit> unit = masterService.getUnitList();
		List<UnitDTO> postResponse = mapper.map(unit, new TypeToken<List<UnitDTO>>() {
		}.getType());
		if (unit != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getCountryById/{id}" }, produces = "application/json")
	public ResponseEntity<CountryDTO> getCountryById(@NotNull @PathVariable("id") UUID id) throws Exception {
		Country country = masterService.getCountryById(id);
		CountryDTO postResponse = mapper.map(country, CountryDTO.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getCountryList" }, produces = "application/json")
	public ResponseEntity<List<CountryDTO>> getCountryList() throws Exception {
		List<Country> country = masterService.getCountryList();
		List<CountryDTO> postResponse = mapper.map(country, new TypeToken<List<CountryDTO>>() {
		}.getType());

		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getStateById/{id}" }, produces = "application/json")
	public ResponseEntity<StateDTO> getStateById(@NotNull @PathVariable("id") UUID id) throws Exception {
		State state = masterService.getStateById(id);
		StateDTO postResponse = mapper.map(state, StateDTO.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getStateList" }, produces = "application/json")
	public ResponseEntity<List<StateDTO>> getStateList() throws Exception {
		List<State> state = masterService.getStateList();
		List<StateDTO> postResponse = mapper.map(state, new TypeToken<List<StateDTO>>() {
		}.getType());

		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getCityById/{id}" }, produces = "application/json")
	public ResponseEntity<CityDTO> getCityById(@NotNull @PathVariable("id") UUID id) throws Exception {
		City city = masterService.getCityById(id);
		CityDTO postResponse = mapper.map(city, CityDTO.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getCityList" }, produces = "application/json")
	public ResponseEntity<List<CityDTO>> getCityList() throws Exception {
		List<City> city = masterService.getCityList();
		List<CityDTO> postResponse = mapper.map(city, new TypeToken<List<CityDTO>>() {
		}.getType());
		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	
	@GetMapping(value = { "getLocalityById/{id}" }, produces = "application/json")
	public ResponseEntity<LocalityDTO> getLocalityById(@NotNull @PathVariable("id") UUID id) throws Exception {
		Locality locality = masterService.getLocalityById(id);
		LocalityDTO postResponse = mapper.map(locality, LocalityDTO.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getLocalityList" }, produces = "application/json")
	public ResponseEntity<List<LocalityDTO>> getLocalityList() throws Exception {
		List<Locality> locality = masterService.getLocalityList();
		List<LocalityDTO> postResponse = mapper.map(locality, new TypeToken<List<LocalityDTO>>() {
		}.getType());
		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getStateListByCountryId" }, produces = "application/json")
	public ResponseEntity<List<StateDTO>> getStateListByCountryId(@NotNull @PathVariable("id") UUID id,
			@NotNull @PathVariable("status") String status) throws Exception {
		List<State> state = masterService.getStateListByCountryId(id, status);
		List<StateDTO> postResponse = mapper.map(state, new TypeToken<List<StateDTO>>() {
		}.getType());

		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getCityListByStateId" }, produces = "application/json")
	public ResponseEntity<List<CityDTO>> getCityListByStateId(@NotNull @PathVariable("id") UUID id,
			@NotNull @PathVariable("status") String status) throws Exception {
		List<City> city = masterService.getCityListByStateId(id, status);
		List<CityDTO> postResponse = mapper.map(city, new TypeToken<List<CityDTO>>() {
		}.getType());
		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}

	@GetMapping(value = { "getTimeZoneById/{id}" }, produces = "application/json")
	public ResponseEntity<TimeZoneDTO> getTimeZoneById(@NotNull @PathVariable("id") UUID id) throws Exception {
		TimeZone timeZone = masterService.getTimeZoneById(id);
		TimeZoneDTO postResponse = mapper.map(timeZone, TimeZoneDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getTimeZoneList" }, produces = "application/json")
	public ResponseEntity<List<TimeZoneDTO>> getTimeZoneList() throws Exception {
		List<TimeZone> timeZone = masterService.getTimeZoneList();
		List<TimeZoneDTO> postResponse = mapper.map(timeZone, new TypeToken<List<TimeZoneDTO>>() {
		}.getType());

		if (timeZone != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	
	@GetMapping(value = { "getGradeSystemById/{id}" }, produces = "application/json")
	public ResponseEntity<GradeSystemDTO> getGradeSystemById(@NotNull @PathVariable("id") UUID id) throws Exception {
		GradeSystem gradeSystem = masterService.getGradeSystemById(id);
		GradeSystemDTO postResponse = mapper.map(gradeSystem, GradeSystemDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getGradeSystemList" }, produces = "application/json")
	public ResponseEntity<List<GradeSystemDTO>> getGradeSystemList() throws Exception {
		List<GradeSystem> gradeSystem = masterService.getGradeSystemList();
		List<GradeSystemDTO> postResponse = mapper.map(gradeSystem, new TypeToken<List<GradeSystemDTO>>() {
		}.getType());

		if (gradeSystem != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	
	@GetMapping(value = { "getCategoryById/{id}" }, produces = "application/json")
	public ResponseEntity<CategoryDTO> getCategoryById(@NotNull @PathVariable("id") UUID id) throws Exception {
		Category category = masterService.getCategoryById(id);
		CategoryDTO postResponse = mapper.map(category, CategoryDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getCategoryList" }, produces = "application/json")
	public ResponseEntity<List<CategoryDTO>> getCategoryList() throws Exception {
		List<Category> category = masterService.getCategoryList();
		List<CategoryDTO> postResponse = mapper.map(category, new TypeToken<List<CategoryDTO>>() {
		}.getType());
		if (category != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	
	@GetMapping(value = { "getSubCategoryById/{id}" }, produces = "application/json")
	public ResponseEntity<SubCategoryDTO> getSubCategoryById(@NotNull @PathVariable("id") UUID id) throws Exception {
		SubCategory subCategory = masterService.getSubCategoryById(id);
		SubCategoryDTO postResponse = mapper.map(subCategory, SubCategoryDTO.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getSubCategoryList" }, produces = "application/json")
	public ResponseEntity<List<SubCategoryDTO>> getSubCategoryList() throws Exception {
		List<SubCategory> subCategory = masterService.getSubCategoryList();
		List<SubCategoryDTO> postResponse = mapper.map(subCategory, new TypeToken<List<SubCategoryDTO>>() {
		}.getType());
		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	
	@GetMapping(value = { "getProductById/{id}" }, produces = "application/json")
	public ResponseEntity<ProductDTO> getProductById(@NotNull @PathVariable("id") UUID id) throws Exception {
		Product product = masterService.getProductById(id);
		ProductDTO postResponse = mapper.map(product, ProductDTO.class);
		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getProductList" }, produces = "application/json")
	public ResponseEntity<List<ProductDTO>> getProductList() throws Exception {
		List<Product> product = masterService.getProductList();
		List<ProductDTO> postResponse = mapper.map(product, new TypeToken<List<ProductDTO>>() {
		}.getType());
		if (postResponse != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	@GetMapping(value = { "getProductSpecificationById/{id}" }, produces = "application/json")
	public ResponseEntity<ProductSpecificationDTO> getProductSpecificationById(@NotNull @PathVariable("id") UUID id) throws Exception {
		ProductSpecification productSpecification = masterService.getProductSpecificationById(id);
		ProductSpecificationDTO postResponse = mapper.map(productSpecification, ProductSpecificationDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = { "getProductSpecificationList" }, produces = "application/json")
	public ResponseEntity<List<ProductSpecificationDTO>> getProductSpecificationList() throws Exception {
		List<ProductSpecification> productSpecification = masterService.getProductSpecificationList();
		List<ProductSpecificationDTO> postResponse = mapper.map(productSpecification, new TypeToken<List<ProductSpecificationDTO>>() {
		}.getType());

		if (productSpecification != null) {
			return ResponseEntity.ok().cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS)).body(postResponse);
		} else {
			return null;
		}
	}
	
}
