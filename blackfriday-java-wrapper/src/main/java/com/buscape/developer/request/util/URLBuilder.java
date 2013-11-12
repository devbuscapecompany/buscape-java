package com.buscape.developer.request.util;

import com.buscape.developer.request.Parameters;
import com.buscape.developer.request.ServiceConfiguration;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public final class URLBuilder {
	
	private String hostName;	
	private String applicationId;
	private Parameters parameters;
	
	public URLBuilder hostName(String hostName) {
		if (hostName.equals(ServiceConfiguration.BWS)) {
			this.hostName = "http://bws.buscape.com";
		} else {
			this.hostName = "http://sandbox.buscape.com";
		}
		return this;
	}
	
	public URLBuilder parameters(Parameters parameters) {
		this.parameters = parameters;
		return this;
	}
	
	public URLBuilder applicationId(String applicationId) {
		this.applicationId = applicationId;
		return this;
	}

	public String build() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(hostName);
		sb.append("/service/blackfriday/buscape/");
		sb.append(applicationId);
		sb.append("/BR/?format=json");
		if (parameters.getSourceId()!=null) {
			sb.append("&sourceId=");
			sb.append(parameters.getSourceId());
		}
		if (parameters.getCategoryId()!=null) {
			sb.append("&categoryId=");
			sb.append(parameters.getCategoryId());
		}
		if (parameters.getClientIp()!=null && !parameters.getClientIp().isEmpty()) {
			sb.append("&clientIp=");
			sb.append(parameters.getClientIp());
		}
		
		return sb.toString();		
	}

}
