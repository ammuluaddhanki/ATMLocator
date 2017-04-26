/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.model;

/**
 * This is a ATM Branch locator Resource Model class
 * 
 * @author AM241297
 *
 */
public class ATM {

	private String uuid;
	private String type;
	private String name;
	private String vicinity;
	private Location location;
	private String photo_URL;
	private String place_id;
	private String nextStartIndex;
	/**
	 * Default constructor
	 */
	public ATM() {
	}

	/**
	 * To get Uuid
	 * 
	 * @return Uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * To set Uuid
	 * 
	 * @param uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * To get Type
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * To set Type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * To get Name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * To set Name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * To get Vicinity
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
	 * To get Location
	 * 
	 * @return Location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * To set Location
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * To get photo_URL
	 * 
	 * @return photo_URL
	 */
	public String getPhoto_URL() {
		return photo_URL;
	}

	/**
	 * To set photo_URL
	 * 
	 * @param photo_URL
	 */
	public void setPhoto_URL(String photo_URL) {
		this.photo_URL = photo_URL;
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
	 * To get nextStartIndex
	 * 
	 * @return nextStartIndex
	 */
	public String getNextStartIndex() {
		return nextStartIndex;
	}

	/**
	 * To set nextStartIndex
	 * 
	 * @param nextStartIndex
	 */
	public void setNextStartIndex(String nextStartIndex) {
		this.nextStartIndex = nextStartIndex;
	}

	/**
	 * This is toString() method of ATM model useful in JUNIT Testing.
	 */
	@Override
	public String toString() {
		return "ATM [uuid=" + uuid + ", type=" + type + ", name=" + name + ", vicinity=" + vicinity + ", location="
				+ location + ", photo_URL=" + photo_URL + ", place_id=" + place_id + "]";
	}

}
