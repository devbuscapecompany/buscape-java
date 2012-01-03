package com.buscape.developer;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.buscape.developer.result.type.Result;

public class FindOfferTest {

	@BeforeClass
	public static void oneTimeSetUp() throws Exception {

		JAXBContext jc = JAXBContext
				.newInstance("com.buscape.developer.result.type");

		Unmarshaller u = jc.createUnmarshaller();

		result = (Result) u.unmarshal(new File(
				"src/test/resources/find_offer_list_for_lg_cookie.xml"));
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		result = null;
	}

	static Result result;

	@Test
	public void testDetailsApplicationId(){
		String applicationId = result.getDetails().getApplicationID();
		assertEquals("564771466d477a4458664d3d", applicationId);
	}
	
	@Test
	public void testDetailApplicationVersion(){
		String applicationVersion = result.getDetails().getApplicationVersion();
		assertEquals("1.0.0.0", applicationVersion);
	}
	
	@Test
	public void testDetailApplicationPath(){
		String applicationPath = result.getDetails().getApplicationPath();
		assertEquals("http://bws-apps.buscape.com/mobile/update", applicationPath);
	}
	
	@Test
	public void testDetailMessage(){
		String message = result.getDetails().getMessage();
		assertEquals("success", message);
	}
	
	@Test
	public void testCategoryName(){
		String name = result.getCategory().getName();
		assertEquals("Celular e Smartphone", name);
	}
}
