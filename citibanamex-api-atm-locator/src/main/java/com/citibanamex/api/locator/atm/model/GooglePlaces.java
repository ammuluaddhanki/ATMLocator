/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a GooglePlaces model class
 * 
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GooglePlaces {

	private String next_page_token;

	private Results[] results;

	private String[] html_attributions;

	private String status;

	/**
	 * To get next_page_token
	 * 
	 * @return next_page_token
	 */
	public String getNext_page_token() {
		return next_page_token;
	}

	/**
	 * To set next_page_token
	 * 
	 * @param next_page_token
	 */
	public void setNext_page_token(String next_page_token) {
		this.next_page_token = next_page_token;
	}

	/**
	 * To get results
	 * 
	 * @return Results[]
	 */
	public Results[] getResults() {
		return results;
	}

	/**
	 * To set Results[]
	 * 
	 * @param results
	 */
	public void setResults(Results[] results) {
		this.results = results;
	}

	/**
	 * To get html_attributions
	 * 
	 * @return String[]
	 */
	public String[] getHtml_attributions() {
		return html_attributions;
	}

	/**
	 * To set html_attributions
	 * 
	 * @param String[]
	 */
	public void setHtml_attributions(String[] html_attributions) {
		this.html_attributions = html_attributions;
	}

	/**
	 * To get status
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * To set status
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
