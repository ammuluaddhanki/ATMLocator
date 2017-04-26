/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package com.citibanamex.api.locator.atm.service;

import java.util.List;

import com.citibanamex.api.locator.atm.model.ATM;

/**
 * This is a service class to fetch list of nearby banamex ATMs from google places api.
 * @author AM241297
 *
 */
public interface AtmService {
	/**
	 * This method is to fetch list of nearby banamex ATMs by calling google places API.
	 * @param radius
	 * @param addressLine1
	 * @param addressLine2
	 * @param nextStartIndex
	 * @return list of ATMs
	 * @throws InterruptedException 
	 */
	List<ATM> getNearByAtmsOrBranches(String radius, String addressLine1, String addressLine2, String nextStartIndex) throws InterruptedException;
}
