package com.nopaper.work.master.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.nopaper.work.master.dto.RelationsDTO;
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
import com.nopaper.work.master.models.Relations;
import com.nopaper.work.master.models.State;
import com.nopaper.work.master.models.SubCategory;
import com.nopaper.work.master.models.TimeZone;
import com.nopaper.work.master.models.Unit;
import com.nopaper.work.master.services.IMasterService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${v1API}")
@Validated
public class MasterCreationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterCreationController.class);

	@Autowired
	private IMasterService masterService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping(value = { "createCurrency" }, produces = "application/json")
	public ResponseEntity<CurrencyDTO> createCurrency(@RequestBody @Valid CurrencyDTO currencyDTO) throws Exception {

		Currency postRequest = mapper.map(currencyDTO, Currency.class);
		Currency currency = masterService.createCurrency(postRequest);
		CurrencyDTO postResponse = mapper.map(currency, CurrencyDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createCountry" }, produces = "application/json")
	public ResponseEntity<CountryDTO> createCountry(@RequestBody @Valid CountryDTO countryDTO) throws Exception {

		Country postRequest = mapper.map(countryDTO, Country.class);
		Country country = masterService.createCountry(postRequest);
		CountryDTO postResponse = mapper.map(country, CountryDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createState" }, produces = "application/json")
	public ResponseEntity<StateDTO> createState(@RequestBody @Valid StateDTO stateDTO) throws Exception {

		State postRequest = mapper.map(stateDTO, State.class);
		State state = masterService.createState(postRequest);
		StateDTO postResponse = mapper.map(state, StateDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createCity" }, produces = "application/json")
	public ResponseEntity<CityDTO> createCity(@RequestBody @Valid CityDTO cityDTO) throws Exception {

		City postRequest = mapper.map(cityDTO, City.class);
		City city = masterService.createCity(postRequest);
		CityDTO postResponse = mapper.map(city, CityDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createLocality" }, produces = "application/json")
	public ResponseEntity<LocalityDTO> createLocality(@RequestBody @Valid LocalityDTO localityDTO) throws Exception {

		Locality postRequest = mapper.map(localityDTO, Locality.class);
		Locality locality = masterService.createLocality(postRequest);
		LocalityDTO postResponse = mapper.map(locality, LocalityDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createUnit" }, produces = "application/json")
	public ResponseEntity<UnitDTO> createUnit(@RequestBody @Valid UnitDTO unitDTO) throws Exception {

		Unit postRequest = mapper.map(unitDTO, Unit.class);
		Unit unit = masterService.createUnit(postRequest);
		UnitDTO postResponse = mapper.map(unit, UnitDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createTimeZone" }, produces = "application/json")
	public ResponseEntity<TimeZoneDTO> createTimeZone(@RequestBody @Valid TimeZoneDTO timeZoneDTO) throws Exception {

		TimeZone postRequest = mapper.map(timeZoneDTO, TimeZone.class);
		TimeZone timeZone = masterService.createTimeZone(postRequest);
		TimeZoneDTO postResponse = mapper.map(timeZone, TimeZoneDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createRelations" }, produces = "application/json")
	public ResponseEntity<RelationsDTO> createRelations(@RequestBody @Valid RelationsDTO relationsDTO) throws Exception {

		Relations postRequest = mapper.map(relationsDTO, Relations.class);
		Relations relations = masterService.createRelations(postRequest);
		RelationsDTO postResponse = mapper.map(relations, RelationsDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createGradeSystem" }, produces = "application/json")
	public ResponseEntity<GradeSystemDTO> createGradeSystem(@RequestBody @Valid GradeSystemDTO gradeSystemDTO) throws Exception {

		GradeSystem postRequest = mapper.map(gradeSystemDTO, GradeSystem.class);
		GradeSystem gradeSystem = masterService.createGradeSystem(postRequest);
		GradeSystemDTO postResponse = mapper.map(gradeSystem, GradeSystemDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createCategory" }, produces = "application/json")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) throws Exception {

		Category postRequest = mapper.map(categoryDTO, Category.class);
		Category category = masterService.createCategory(postRequest);
		CategoryDTO postResponse = mapper.map(category, CategoryDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createSubCategory" }, produces = "application/json")
	public ResponseEntity<SubCategoryDTO> createSubCategory(@RequestBody @Valid SubCategoryDTO subCategoryDTO) throws Exception {

		SubCategory postRequest = mapper.map(subCategoryDTO, SubCategory.class);
		SubCategory subCategory = masterService.createSubCategory(postRequest);
		SubCategoryDTO postResponse = mapper.map(subCategory, SubCategoryDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	@PostMapping(value = { "createProduct" }, produces = "application/json")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO) throws Exception {

		Product postRequest = mapper.map(productDTO, Product.class);
		Product product = masterService.createProduct(postRequest);
		ProductDTO postResponse = mapper.map(product, ProductDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createProductSpecification" }, produces = "application/json")
	public ResponseEntity<ProductSpecificationDTO> createProductSpecification(@RequestBody @Valid ProductSpecificationDTO productSpecificationDTO) throws Exception {

		ProductSpecification postRequest = mapper.map(productSpecificationDTO, ProductSpecification.class);
		ProductSpecification productSpecification = masterService.createProductSpecification(postRequest);
		ProductSpecificationDTO postResponse = mapper.map(productSpecification, ProductSpecificationDTO.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

}
