/**
 * git Config: 
 * Project Name: profile
 * Created: 2 Aug 2023 23:54:18
 * Author: metis
 * Copyright # Saikat Barman
 * 
 */
package com.nopaper.work.master.annotations;

/**
 * 
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.nopaper.work.master.enums.ValidationType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowAnonymous {

	ValidationType validationType() default ValidationType.ANONYMOUS;

}
