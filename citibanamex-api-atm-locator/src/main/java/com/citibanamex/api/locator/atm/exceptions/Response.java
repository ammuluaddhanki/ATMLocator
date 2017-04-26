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
 * This is a Error Response Class to return error object
 * 
 * @author AM241297
 *
 */
public class Response {
	private String status;
	private String description;
	private int errorCode;
	private String message;
	private long timeStamp;
	
	/**
	 * Default Constructor
	 */
	public Response(){}

	/**
	 * Parameterized Constructor
	 * @param description
	 * @param errorCode
	 * @param message
	 * @param timeStamp
	 */
	public Response(String description, int errorCode, String message, long timeStamp) {
		super();
		this.description = description;
		this.errorCode = errorCode;
		this.message = message;
		this.timeStamp = timeStamp;
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
	 * To ser errorCode
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

	/**
	 * To get description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * To set description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * To get timeStamp
	 * 
	 * @return timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * To set timeStamp
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * To get status
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * To set status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
