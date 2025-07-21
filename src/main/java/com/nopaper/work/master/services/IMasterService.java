package com.nopaper.work.master.services;

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

public interface IMasterService {

	Currency createCurrency(Currency postRequest);

	State createState(State postRequest);

	Country createCountry(Country postRequest);

	City createCity(City postRequest);

	Unit createUnit(Unit postRequest);

	TimeZone createTimeZone(TimeZone postRequest);

	Locality createLocality(Locality postRequest);

	Relations createRelations(Relations postRequest);

	GradeSystem createGradeSystem(GradeSystem postRequest);

	Category createCategory(Category postRequest);

	SubCategory createSubCategory(SubCategory postRequest);

	Product createProduct(Product postRequest);

	ProductSpecification createProductSpecification(ProductSpecification postRequest);

}
