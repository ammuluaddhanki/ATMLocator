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
 * This is a GeoCodeResponse
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCodeResponse {
	private Results[] results;

    private String status;
    /**
     * To get results 
     * @return results
     */
    public Results[] getResults ()
    {
        return results;
    }
    /**
     * To set results
     * @param results
     */
    public void setResults (Results[] results)
    {
        this.results = results;
    }
    /**
     * To get status
     * @return status
     */
    public String getStatus ()
    {
        return status;
    }
    /**
     * To set status
     * @param status
     */
    public void setStatus (String status)
    {
        this.status = status;
    }
}
