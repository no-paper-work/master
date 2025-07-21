package com.nopaper.work.master.annotations;

/**
 * @package com.nopaper.work.master.annotations -> master
 * @author saikatbarman
 * @date 2025 16-Jul-2025 11:15:01 pm
 * @git 
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