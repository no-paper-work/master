package com.nopaper.work.master.reactive.services;

import java.util.UUID;

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

import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMasterReactiveService {

	Mono<Currency> getCurrencyById(UUID id);

	Mono<Unit> getUnitById(UUID id);

	Mono<Country> getCountryById(UUID id);

	Mono<State> getStateById(UUID id);

	Mono<City> getCityById(UUID id);
	
	Mono<TimeZone> getTimeZoneById(UUID id);
	
	Mono<Locality> getLocalityById(@NotNull UUID id);
	
	Mono<Category> getCategoryById(@NotNull UUID id);

	Mono<GradeSystem> getGradeSystemById(@NotNull UUID id);
	
	Mono<Product> getProductById(@NotNull UUID id);
	
	Mono<SubCategory> getSubCategoryById(@NotNull UUID id);
	
	Mono<ProductSpecification> getProductSpecificationById(@NotNull UUID id);
	
	/*
	 * All list of Masters
	 */

	Flux<Currency> getCurrencyList();

	Flux<Unit> getUnitList();

	Flux<Country> getCountryList();

	Flux<State> getStateList();

	Flux<City> getCityList();
	
	Flux<Locality> getLocalityList();
	
	Flux<TimeZone> getTimeZoneList();
	
	

	/*
	 * Conditional Joins with Parent ID
	 */

	Flux<State> getStateListByCountryId(UUID id, String status);

	Flux<City> getCityListByStateId(UUID id, String status);

	Flux<GradeSystem> getGradeSystemList();

	Flux<Category> getCategoryList();

	Flux<SubCategory> getSubCategoryList();

	Flux<Product> getProductList();

	Flux<ProductSpecification> getProductSpecificationList();


}
