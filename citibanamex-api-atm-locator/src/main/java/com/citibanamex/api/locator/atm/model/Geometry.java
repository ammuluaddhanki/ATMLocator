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
 * This is a Model class to get lat lng of location
 * 
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

	private Location location;

	/**
	 * To get location
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * To set location
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
