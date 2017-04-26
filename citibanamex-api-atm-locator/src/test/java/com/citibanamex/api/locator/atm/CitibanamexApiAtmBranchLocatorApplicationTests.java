package com.citibanamex.api.locator.atm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.citibanamex.api.locator.atm.model.ATM;
import com.citibanamex.api.locator.atm.model.Location;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CitibanamexApiAtmBranchLocatorApplicationTests.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@ComponentScan("com.citibanamex.api.locator.atm")
public class CitibanamexApiAtmBranchLocatorApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	ATM atm1 = null;
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup() {
	mockMvc = webAppContextSetup(webApplicationContext).build();
	Location location = new Location();
	location.setLat("19.40686879999999");
	location.setLng("-99.2392411");

	atm1 = new ATM();
	atm1.setType("atm");
	atm1.setName("Banamex Plaza Bosques");
	atm1.setVicinity("Bosque de Duraznos 187");
	atm1.setLocation(location);
	atm1.setPhoto_URL("https://maps.googleapis.com/maps/api/place/photo?maxwidth=100&photoreference=");
	atm1.setPlace_id("ChIJqSXFf3MB0oURQLEULqdYQV0");
	atm1.setNextStartIndex("");
	}
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		this.mockMvc
				.perform(get("/v1/banamex/atms/nearby?radius=5000&addressLine1=bosque+de+duraznos+78&addressLine2=Mexico+city")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
		this.mockMvc.perform(get("/v1/banamex/atms/nearby?radius=1000&addressLine1=bosque+de+duraznos+78&addressLine2=Mexico+city"))
				.andDo(print());
	}
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
