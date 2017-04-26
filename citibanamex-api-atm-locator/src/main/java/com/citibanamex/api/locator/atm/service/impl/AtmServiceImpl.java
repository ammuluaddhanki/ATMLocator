/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citibanamex.api.locator.atm.model.ATM;
import com.citibanamex.api.locator.atm.model.GooglePlaces;
import com.citibanamex.api.locator.atm.model.Results;
import com.citibanamex.api.locator.atm.model.geocode.GeoCodeResponse;
import com.citibanamex.api.locator.atm.model.geocode.Location;
import com.citibanamex.api.locator.atm.service.AtmService;

/**
 * This is a service implementation class to fetch list of nearby banamex ATMs
 * and branches using google places api. First it will take address and fetch
 * corresponding geocodes and then fetches list of atms/branches using lat lng.
 * 
 * @author AM241297
 *
 */
@Service
public class AtmServiceImpl implements AtmService {

	private static final Logger log = LoggerFactory.getLogger(AtmServiceImpl.class);
	private static final String GOOGLE_PLACES_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	private static final String API_KEY_VALUE = "&key=AIzaSyAJBIQdfnhuEcSi6qFDoXCszJpRZxlSFZ0";
	private static final String KEY_WORD = "&keyword=Banamex";
	private static final String LOCATION = "&location=";
	private static final String COMMA = ",";
	private static final String RADIUS = "&radius=";
	private static final String PHOTO_REF_URL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&photoreference=";
	private static final String GEO_CODE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private static final String NEXT_START_INDEX = "&pagetoken=";

	/**
	 * This method first takes the address and gets lat lng cordinates of it and
	 * then passes to the google places url along with radius to get list of
	 * banamex atms and branches nearby. We must need API KEY to access google
	 * places APIs.By default Google places limits search to 20 objects, but we
	 * can fetch more than 20 by passing next page token to same url which we
	 * get from first call.
	 * 
	 * @param radius
	 * @param addressLine1
	 * @param addressLine2
	 * @param nextStartIndex
	 * @return list of CitiBanamex ATMs/Branches
	 * @throws InterruptedException
	 */
	public List<ATM> getNearByAtmsOrBranches(String radius, String addressLine1,String addressLine2, String nextStartIndex)
			throws InterruptedException {
		String address = addressLine1+" "+addressLine2;
		RestTemplate restTemplate = new RestTemplate();
		Location location = new Location();
		List<ATM> atmsList = new ArrayList<ATM>();
		GooglePlaces response = null;
		Results[] resultList = null;
		StringBuffer imgURL = new StringBuffer(PHOTO_REF_URL);
		StringBuffer GEO_CODE_URI = new StringBuffer(GEO_CODE_URL);
		GEO_CODE_URI.append(address);
		GEO_CODE_URI.append(API_KEY_VALUE);
		log.info("****************GEO_CODE_URI****************" + GEO_CODE_URI);
		GeoCodeResponse cordinates = restTemplate.getForObject(GEO_CODE_URI.toString(), GeoCodeResponse.class);
		com.citibanamex.api.locator.atm.model.geocode.Results[] results = cordinates.getResults();
		for (com.citibanamex.api.locator.atm.model.geocode.Results result : results) {
			location = result.getGeometry().getLocation();
			location.setLat(location.getLat());
			location.setLng(location.getLng());
		}
		log.info("****Geocode coordinates for a given address : " + address + ", location: " + location.getLat() + ","
				+ location.getLng());
		StringBuffer googlePlacesURI = new StringBuffer(GOOGLE_PLACES_URL);
		googlePlacesURI.append(KEY_WORD);
		googlePlacesURI.append(API_KEY_VALUE);
		googlePlacesURI.append(LOCATION);
		googlePlacesURI.append(location.getLat());
		googlePlacesURI.append(COMMA);
		googlePlacesURI.append(location.getLng());
		googlePlacesURI.append(RADIUS);
		googlePlacesURI.append(radius);
		if (nextStartIndex != null) {
			googlePlacesURI.append(NEXT_START_INDEX);
			googlePlacesURI.append(nextStartIndex);
		}
		response = restTemplate.getForObject(googlePlacesURI.toString(), GooglePlaces.class);
		resultList = response.getResults();
		String next_page_token = response.getNext_page_token();
		log.info("****************googlePlacesURI****************" + googlePlacesURI);
		atmsList = getATMsList(atmsList, resultList, imgURL, next_page_token);
		log.info("*****List of nearby Banamex atms/branches list returning : " + atmsList.size());
		return atmsList;
	}

	/**
	 * A private method to fetch list of nearby banamex atms using Google places
	 * API. This will fetch upto 20 json objects which is google places limit.
	 * 
	 * @param atmsList
	 * @param resultList
	 * @param imgURL
	 * @param next_page_token
	 * @return list of nearby ATMs/Branches
	 */
	private List<ATM> getATMsList(List<ATM> atmsList, Results[] resultList, StringBuffer imgURL,
			String next_page_token) {
		ATM atm = null;
		log.info("*****The size of results returned from google places api : " + resultList.length);
		for (Results resultObj : resultList) {
			atm = new ATM();
			atm.setUuid(UUID.randomUUID().toString());
			atm.setType(resultObj.getTypes()[0]);
			atm.setName(resultObj.getName());
			atm.setVicinity(resultObj.getVicinity());
			atm.setLocation(resultObj.getGeometry().getLocation());
			if (null != resultObj.getPhotos() && null != resultObj.getPhotos()[0].getPhoto_reference()) {
				imgURL.append(resultObj.getPhotos()[0].getPhoto_reference());
				imgURL.append(API_KEY_VALUE);
			}
			if (null != imgURL) {
				atm.setPhoto_URL(imgURL.toString());
			}
			atm.setPlace_id(resultObj.getPlace_id());
			if (next_page_token != null) {
				atm.setNextStartIndex(next_page_token);
			} else {
				atm.setNextStartIndex("");
			}
			//String name = atm.getName().toLowerCase();
			//if (name != null && name.contains("banamex")) {
				atmsList.add(atm);
			/*}else{
				log.info("*****There is other name of ATM found in banamex atms list which is : " + atm.getName());
			}*/
		}
		return atmsList;
	}

}