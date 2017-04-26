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
 * This is a Results object class to get geaometry object
 * 
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	private Photos[] photos;

	private String id;

	private String place_id;

	private String icon;

	private String vicinity;

	private String scope;

	private String name;

	private String rating;

	private String[] types;

	private String reference;

	private Geometry geometry;

	/**
	 * To get photos
	 * 
	 * @return photos
	 */
	public Photos[] getPhotos() {
		return photos;
	}

	/**
	 * To set photos
	 * 
	 * @param photos
	 */
	public void setPhotos(Photos[] photos) {
		this.photos = photos;
	}

	/**
	 * To get id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * To set id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * To get icon
	 * 
	 * @return icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * To set icon
	 * 
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * To get vicinity
	 * 
	 * @return vicinity
	 */
	public String getVicinity() {
		return vicinity;
	}

	/**
	 * To set vicinity
	 * 
	 * @param vicinity
	 */
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	/**
	 * To get scope
	 * 
	 * @return scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * To set scope
	 * 
	 * @param scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * To get name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * To set name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * To get rating
	 * 
	 * @return rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * To set rating
	 * 
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
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
	 * To get reference
	 * 
	 * @return reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * To set reference
	 * 
	 * @param reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
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
