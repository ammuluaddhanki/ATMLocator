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
 * This is a Photos class
 * 
 * @author AM241297
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photos {
	private String photo_reference;

	private String height;

	private String[] html_attributions;

	private String width;

	/**
	 * To get photo_reference
	 * 
	 * @return photo_reference
	 */
	public String getPhoto_reference() {
		return photo_reference;
	}

	/**
	 * To set photo_reference
	 * 
	 * @param photo_reference
	 */
	public void setPhoto_reference(String photo_reference) {
		this.photo_reference = photo_reference;
	}

	/**
	 * To get height
	 * 
	 * @return height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * To set height
	 * 
	 * @param height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Tp get html_attributions
	 * 
	 * @return html_attributions
	 */
	public String[] getHtml_attributions() {
		return html_attributions;
	}

	/**
	 * To set html_attributions
	 * 
	 * @param html_attributions
	 */
	public void setHtml_attributions(String[] html_attributions) {
		this.html_attributions = html_attributions;
	}

	/**
	 * To get width
	 * 
	 * @return width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * To set width
	 * 
	 * @param width
	 */
	public void setWidth(String width) {
		this.width = width;
	}
}
