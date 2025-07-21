package com.nopaper.work.master.services;

import java.util.List;
import java.util.UUID;

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

import jakarta.validation.constraints.NotNull;

public interface IMasterService {

	Currency getCurrencyById(UUID id);

	Unit getUnitById(UUID id);

	Country getCountryById(UUID id);

	State getStateById(UUID id);

	City getCityById(UUID id);
	
	TimeZone getTimeZoneById(UUID id);
	
	Locality getLocalityById(@NotNull UUID id);

	/*
	 * All list of Masters
	 */

	List<Currency> getCurrencyList();

	List<Unit> getUnitList();

	List<Country> getCountryList();

	List<State> getStateList();

	List<City> getCityList();
	
	List<Locality> getLocalityList();
	
	List<TimeZone> getTimeZoneList();

	/*
	 * Conditional Joins with Parent ID
	 */

	List<State> getStateListByCountryId(UUID id, String status);

	List<City> getCityListByStateId(UUID id, String status);

	/*
	 * MASTER CREATE OPTIONS
	 */

	Currency createCurrency(Currency postRequest);

	State createState(State postRequest);

	Country createCountry(Country postRequest);

	City createCity(City postRequest);
	
	Unit createUnit(Unit postRequest);

	TimeZone createTimeZone(TimeZone postRequest);
	
	Locality createLocality(Locality postRequest);
	
	Relations createRelations(Relations postRequest);

	GradeSystem createGradeSystem(GradeSystem postRequest);

	/**
	 * @param id
	 * @return
	 */
	GradeSystem getGradeSystemById(@NotNull UUID id);

	/**
	 * @return
	 */
	List<GradeSystem> getGradeSystemList();

	/**
	 * @param postRequest
	 * @return
	 */
	Category createCategory(Category postRequest);

	/**
	 * @param postRequest
	 * @return
	 */
	SubCategory createSubCategory(SubCategory postRequest);

	/**
	 * @param postRequest
	 * @return
	 */
	Product createProduct(Product postRequest);

	/**
	 * @param id
	 * @return
	 */
	Category getCategoryById(@NotNull UUID id);

	/**
	 * @return
	 */
	List<Category> getCategoryList();

	/**
	 * @param id
	 * @return
	 */
	SubCategory getSubCategoryById(@NotNull UUID id);

	/**
	 * @return
	 */
	List<SubCategory> getSubCategoryList();

	/**
	 * @param id
	 * @return
	 */
	Product getProductById(@NotNull UUID id);

	/**
	 * @return
	 */
	List<Product> getProductList();

	/**
	 * @param id
	 * @return
	 */
	ProductSpecification getProductSpecificationById(@NotNull UUID id);

	/**
	 * @return
	 */
	List<ProductSpecification> getProductSpecificationList();

	/**
	 * @param postRequest
	 * @return
	 */
	ProductSpecification createProductSpecification(ProductSpecification postRequest);

}
