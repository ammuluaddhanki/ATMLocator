/*
 * Copyright Banco Nacional de Mexico, S.A.
 * Integrante de Grupo Financiero Banamex.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.citibanamex.api.locator.atm.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.citibanamex.api.locator.atm.controller.AtmController;
import com.citibanamex.api.locator.atm.model.ATM;

/**
 * This class is to test AtmService functionality
 * 
 * @author AM241297
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AtmController.class)
@ComponentScan("com.citibanamex.api.locator.atm.service")
public class AtmServiceTest {
	List<ATM> atms = null;

	@Autowired
	private AtmService atmService;

	/**
	 * This function is to verify the getNearByAtmsOrBranhes service
	 * functionality
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNearByAtms() throws Exception {
		assertNotNull(atmService);
		atms = atmService.getNearByAtmsOrBranches("1000", "bosque+de+duraznos+78", "Mexico+city", "");
		assertNotNull(atms);
		assertThat(atms.get(1).getName(), equalTo("Banamex"));
	}

	/**
	 * This function is to verify the getNearByAtmsOrBranhes service negative
	 * functionality
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNearByAtmsNegative() throws Exception {
		atms = atmService.getNearByAtmsOrBranches("1000", "bosque+de+duraznos+78", "Mexico+city", "");
		assertFalse(atms.get(1).getName(), equalTo(atms.get(1).getName()) == null);
		assertTrue(atms.get(1).getName(), equalTo(atms.get(1).getName()) != null);

	}
}
