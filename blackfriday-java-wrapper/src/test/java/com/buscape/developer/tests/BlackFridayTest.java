package com.buscape.developer.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.buscape.developer.BlackfridayLomadee;
import com.buscape.developer.request.ParametersBuilder;
import com.buscape.developer.request.ServiceConfiguration;
import com.buscape.developer.result.Result;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public class BlackFridayTest {

	@Test
	public void findOffers(){
		String applicationId = "564771466d477a4458664d3d";
		Long sourceId = 23647050L;
		
		ServiceConfiguration serviceConfiguration = new ServiceConfiguration(applicationId, ServiceConfiguration.SANDBOX);
		
		ParametersBuilder paramBuilder = new ParametersBuilder()
			.category(null)
			.source(sourceId)
			.clientIp(null);
		
		BlackfridayLomadee bp = new BlackfridayLomadee(serviceConfiguration, paramBuilder.bluid());
		Result result = null;
		try {
			result = bp.getOffers();
		} catch (IOException e) {
			
		}
		
		assertEquals("success", result.getDetails().getStatus());
	}
}
