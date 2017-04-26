/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.exceptions;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This is a GlobalExceptionHandler class to handle all Exceptions
 * 
 * @author AM241297
 *
 */
@RestControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/**
	 * This method is to handle BadRequestException category
	 * 
	 * @param BadRequestException
	 * @return Response
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<?> handleBadRequestException(BadRequestException ex) {
		Response respObj = new Response();
		respObj.setTimeStamp(new Date().getTime());
		respObj.setStatus("FAILURE");
		respObj.setErrorCode(HttpStatus.BAD_REQUEST.value());
		respObj.setMessage("Bad Request");
		respObj.setDescription("Invalid 'radius' or/and 'address' parameters");
		logger.info("Http response -" + respObj.getErrorCode() + "-" + respObj.getDescription() + "-" + respObj.getMessage());
		return new ResponseEntity<Response>(respObj, HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is to handle BaseException category
	 * 
	 * @param ServerError
	 * @return Response
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = ServerError.class)
	public ResponseEntity<?> handleBaseException(ServerError e) {
		Response response = new Response();
		response.setTimeStamp(new Date().getTime());
		response.setStatus("FAILURE");
		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage("Internal Server Error");
		response.setDescription("Internal Server Error");
		logger.info("Http response -" + response.getErrorCode() + "-" + response.getDescription() + "-" + response.getMessage());
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * This method is to handle NotFoundException category
	 * 
	 * @param NotFoundException
	 * @return Response
	 */
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<?> handleResourceNotFoundException(final NoHandlerFoundException ex) {
		Response eR = new Response();
		eR.setTimeStamp(new Date().getTime());
		eR.setStatus("FAILURE");
		eR.setErrorCode(HttpStatus.NOT_FOUND.value());
		eR.setMessage("Resource Not Found");
		eR.setDescription("Resource you are trying to reach is not found");
		logger.info("Http response -" + eR.getErrorCode() + "-" + eR.getDescription() + "-" + eR.getMessage());
		return new ResponseEntity<Response>(eR, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle NotFoundException category
	 * 
	 * @param NotFoundException
	 * @return Response
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException ne) {
		Response resp = new Response();
		resp.setTimeStamp(new Date().getTime());
		resp.setStatus("SUCCESS");
		resp.setErrorCode(HttpStatus.OK.value());
		resp.setMessage("Data Not Found");
		resp.setDescription("0 Results Returned");
		logger.info("Http response -" + resp.getErrorCode() + "-" + resp.getDescription() + "-" + resp.getMessage());
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
		Response resp = new Response();
		resp.setTimeStamp(new Date().getTime());
		resp.setStatus("SUCCESS");
		resp.setErrorCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage("The 'radius' and 'address' parameters required");
		resp.setDescription("Missing Request Parameters");
		logger.info("Http response -" + resp.getErrorCode() + "-" + resp.getDescription() + "-" + resp.getMessage());
		return new ResponseEntity<Response>(resp, HttpStatus.BAD_REQUEST);
	}
}
