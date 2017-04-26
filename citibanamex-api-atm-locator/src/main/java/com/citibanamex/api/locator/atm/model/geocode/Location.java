/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.model.geocode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a Location class to get lat lng
 * 
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
	private String lng;

	private String lat;

	/**
	 * To get lng
	 * 
	 * @return lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * To set lng
	 * 
	 * @param lng
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * To get lat
	 * 
	 * @return lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * To set lat
	 * 
	 * @param lat
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
}
