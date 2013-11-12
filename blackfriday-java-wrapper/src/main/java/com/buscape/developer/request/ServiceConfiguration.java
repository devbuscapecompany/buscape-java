package com.buscape.developer.request;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public class ServiceConfiguration {
	
	public static final String SANDBOX = "sandbox";
	public static final String BWS = "bws";
	
	private String applicationId;
	private String environment;
	
	/**
	 * @param applicationId 
	 * @param environment 
	 * 
	 */
	public ServiceConfiguration(String applicationId, String environment) {
		this.applicationId = applicationId;
		this.environment = environment;
	}

	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

}
