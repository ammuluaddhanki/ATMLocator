/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.exceptions;

/**
 * This is a Base Exception to handle any unexpected exceptions like server
 * errors.
 * 
 * @author AM241297
 *
 */
public class ServerError extends RuntimeException {

	private int errorCode;
	private String message;
	/**
	 * serialVersion UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public ServerError() {
	}

	/**
	 * Parameterized Constructor
	 */
	public ServerError(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	/**
	 * To get errorCode
	 * 
	 * @return errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * To set errorCode
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * To get message
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * To set message
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
