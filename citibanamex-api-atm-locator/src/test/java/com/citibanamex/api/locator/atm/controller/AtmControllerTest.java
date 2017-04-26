/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.citibanamex.api.locator.atm.model.ATM;
import com.citibanamex.api.locator.atm.model.Location;
import com.citibanamex.api.locator.atm.service.AtmService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a AtmController test class to verify the functionality
 * 
 * @author AM241297
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AtmController.class)
@ComponentScan("com.citibanamex.api.locator.atm.service")
public class AtmControllerTest {
	List<ATM> atms = null;
	ATM atm1 = null;
	ATM atm2 = null;
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AtmService service;

	/**
	 * This setUp method is for initializing work
	 * 
	 * @throws InterruptedException
	 */
	@Before
	public void setUp() throws InterruptedException {
		atms = service.getNearByAtmsOrBranches("1000", "bosque+de+duraznos+78", "Mexico+city", "");
		Location location = new Location();
		location.setLat("19.40686879999999");
		location.setLng("-99.2392411");

		atm1 = new ATM();
		atm1.setUuid(atms.get(0).getUuid());
		atm1.setType("atm");
		atm1.setName("Banamex Plaza Bosques");
		atm1.setVicinity("Bosque de Duraznos 187");
		atm1.setLocation(location);
		atm1.setPhoto_URL("https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&photoreference=");
		atm1.setPlace_id("ChIJqSXFf3MB0oURQLEULqdYQV0");
		atm1.setNextStartIndex("");
		atms.add(atm1);

		Location location1 = new Location();
		location1.setLat("19.4044756");
		location1.setLng("-99.24111069999999");
		atm2 = new ATM();
		atm2.setUuid(atms.get(1).getUuid());
		atm2.setType("bank");
		atm2.setName("Banamex Plaza Bosques");
		atm2.setVicinity("Bosque de Duraznos 75, Bosque de las Lomas, Ciudad de México");
		atm2.setLocation(location1);
		atm2.setPhoto_URL("https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&photoreference=");
		atm2.setPlace_id("ChIJh2-YSnMB0oURafJ3-7bJHDA");
		atm2.setNextStartIndex("");
		atms.add(atm2);
	}

	/**
	 * This funtion is to test the status codes
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		this.mockMvc
				.perform(get("/v1/banamex/atms/nearby?radius=5000&addressLine1=bosque+de+duraznos+78&addressLine2=Mexico+city")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
		this.mockMvc.perform(get("/v1/banamex/atms/nearby?radius=1000&addressLine1=bosque+de+duraznos+78&addressLine2=Mexico+city"))
				.andDo(print());
	}

	/**
	 * This function is test the actual functionality of getNearByAtms
	 * controller.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNearByAtms() throws Exception {
		MvcResult result = this.mockMvc
				.perform(get("/v1/banamex/atms/nearby?radius=1000&addressLine1=bosque+de+duraznos+78&addressLine2=Mexico+city"))
				.andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		List<ATM> atmslist = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<Iterable<ATM>>() {
				});
		assertThat(atmslist.get(0).getName(), equalTo(atm1.getName()));
		assertThat(atmslist.get(0).getType(), equalTo(atm1.getType()));
		assertThat(atmslist.get(0).getVicinity(), equalTo(atm1.getVicinity()));
		assertThat(atmslist.get(0).getPhoto_URL(), equalTo(atm1.getPhoto_URL()));
		assertThat(atmslist.get(0).getPlace_id(), equalTo(atm1.getPlace_id()));

	}
}
