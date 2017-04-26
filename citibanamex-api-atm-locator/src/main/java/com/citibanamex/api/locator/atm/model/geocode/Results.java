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
 * This is a Results class to get list of ATMs
 * 
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	private String place_id;

	private String formatted_address;

	private String[] types;

	private Geometry geometry;

	/**
	 * To get place_id
	 * 
	 * @return place_id
	 */
	public String getPlace_id() {
		return place_id;
	}

	/**
	 * To set place_id
	 * 
	 * @param place_id
	 */
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	/**
	 * To get formatted_address
	 * 
	 * @return formatted_address
	 */
	public String getFormatted_address() {
		return formatted_address;
	}

	/**
	 * To set formatted_address
	 * 
	 * @param formatted_address
	 */
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	/**
	 * To get types
	 * 
	 * @return types
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * To set types
	 * 
	 * @param types
	 */
	public void setTypes(String[] types) {
		this.types = types;
	}

	/**
	 * To get geometry
	 * 
	 * @return geometry
	 */
	public Geometry getGeometry() {
		return geometry;
	}

	/**
	 * To set geometry
	 * 
	 * @param geometry
	 */
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
}
