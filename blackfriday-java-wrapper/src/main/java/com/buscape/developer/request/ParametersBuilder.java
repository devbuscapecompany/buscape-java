package com.buscape.developer.request;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public final class ParametersBuilder {

	private final Parameters params;
	
	/**
	 * 
	 */
	public ParametersBuilder() {
		params = new Parameters();
	}
	
	public ParametersBuilder category(Integer categoryId) {
		params.setCategoryId(categoryId);
		return this;
	}
	
	public ParametersBuilder source(Long sourceId) {
		params.setSourceId(sourceId);
		return this;
	}
	
	public ParametersBuilder clientIp(String clientIp) {
		params.setClientIp(clientIp);
		return this;
	}
	
	public Parameters bluid() {
		return params;
	}
}
