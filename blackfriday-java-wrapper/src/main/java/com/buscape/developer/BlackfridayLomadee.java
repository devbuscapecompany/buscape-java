package com.buscape.developer;

import java.io.IOException;

import com.buscape.developer.http.HttpRequester;
import com.buscape.developer.request.Parameters;
import com.buscape.developer.request.ServiceConfiguration;
import com.buscape.developer.request.util.URLBuilder;
import com.buscape.developer.result.Result;
import com.buscape.developer.result.parser.ResultParser;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public class BlackfridayLomadee {
	
	private ServiceConfiguration configuration;
	private Parameters parameters;

	/**
	 * @param serviceConfiguration 
	 * @param requestParameters 
	 * 
	 */
	public BlackfridayLomadee(ServiceConfiguration serviceConfiguration, Parameters requestParameters) {
		configuration = serviceConfiguration;
		parameters = requestParameters;
	}
	
	public Result getOffers() throws IOException {
		URLBuilder url = new URLBuilder();
		url.applicationId(configuration.getApplicationId());
		url.hostName(configuration.getEnvironment());
		url.parameters(parameters);
		
		String json = callService(url.build());
		
		return new ResultParser(json).getResult();
	}

	private String callService(String url) throws IOException {
		final HttpRequester request = new HttpRequester(url);
		
		return request.getResponse();
	}
}
