/**
 * @package com.nopaper.work.master.controller -> master
 * @author saikatbarman
 * @date 2025 17-Jul-2025 12:46:05 am
 * @git 
 */
package com.nopaper.work.master.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nopaper.work.master.dto.UnitDTO;
import com.nopaper.work.master.reactive.services.IMasterReactiveService;

import reactor.core.publisher.Mono;

/**
 * 
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${v1API}")
@Validated
	
public class MasterReactiveController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterCreationController.class);
	
	@Autowired
	private IMasterReactiveService masterService;

	@Autowired
	private ModelMapper mapper;
	
	@GetMapping(value = { "getUnitList" }, produces = "application/json")
	public Mono<ResponseEntity<List<UnitDTO>>> getUnitList() throws Exception {
		return masterService.getUnitList()
		        .map(unit -> mapper.map(unit, UnitDTO.class))
		        .collectList()
		        .map(postResponse -> ResponseEntity.ok()
		            .cacheControl(CacheControl.maxAge(4, TimeUnit.HOURS))
		            .body(postResponse));
	}
	
}
