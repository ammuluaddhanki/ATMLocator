/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package com.citibanamex.api.locator.atm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citibanamex.api.locator.atm.exceptions.BadRequestException;
import com.citibanamex.api.locator.atm.exceptions.ServerError;
import com.citibanamex.api.locator.atm.exceptions.DataNotFoundException;
import com.citibanamex.api.locator.atm.model.ATM;
import com.citibanamex.api.locator.atm.service.AtmService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is an ATM controller used to fetch the nearby banamex atms and branches.
 * 
 * @author AM241297
 *
 */
@RestController
@RequestMapping("/v1")
public class AtmController {
	private static final Logger log = LoggerFactory.getLogger(AtmController.class);
	@Autowired
	private AtmService atmService;

	/**
	 * This is an API contract to get list of nearby Banamex ATMs and Branches
	 * Which takes address and radius as required parameters and nextStartIndex,
	 * requestSize as optional parameters. nextStartIndex will be used to fetch
	 * additional results.
	 * 
	 * @param radius
	 * @param addressLine1
	 * @param addressLine2
	 * @param nextStartIndex
	 * @return list of Banamex ATMs/Branches
	 */
	@GetMapping(value = "/banamex/atms/nearby", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "getNearByAtmsOrBranches", nickname = "Get near by ATMs and Branches")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "radius", value = "radius to fetch atms", required = true, dataType = "string", paramType = "query", defaultValue = "1000"),
			@ApiImplicitParam(name = "addressLine1", value = "addressLine1 from where to fetch atms", required = true, dataType = "string", paramType = "query", defaultValue = "Santa+Fe"),
			@ApiImplicitParam(name = "addressLine2", value = "addressLine2 from where to fetch atms", required = true, dataType = "string", paramType = "query", defaultValue = "Mexico+city"),
			@ApiImplicitParam(name = "nextStartIndex", value = "nextStartIndex to fetch next page results", required = false, dataType = "string", paramType = "query", defaultValue = "")})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 400, message = "BadRequest"),
			@ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<?> getNearByAtmsOrBranches(@RequestParam(value = "radius", required = true) String radius,
			@RequestParam(value = "addressLine1", required = true) String addressLine1,
			@RequestParam(value = "addressLine2", required = true) String addressLine2,
			@RequestParam(value = "nextStartIndex", required = false) String nextStartIndex ) throws Exception {
		List<ATM> nearbyAtms = null;
		if (radius == null || addressLine1 == null || addressLine2 == null || radius.isEmpty() || addressLine1.isEmpty() || addressLine2.isEmpty() || !radius.matches("([0-9])+")) {
			log.info("*****BadRequestException*****");
			throw new BadRequestException();
		}
		try {
			nearbyAtms = atmService.getNearByAtmsOrBranches(radius, addressLine1, addressLine2, nextStartIndex);
		} catch (Exception e) {
			log.info("*****ServerError*****");
			throw new ServerError();
		}
		if (nearbyAtms.size() == 0 || null == nearbyAtms) {
			log.info("*****DataNotFoundException*****");
			throw new DataNotFoundException();
		}
		return new ResponseEntity<>(nearbyAtms, HttpStatus.OK);
	}
}
