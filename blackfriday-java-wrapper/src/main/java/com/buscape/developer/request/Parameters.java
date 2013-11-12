package com.buscape.developer.request;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public final class Parameters {
	
	private Integer categoryId;
	private Long sourceId;
	private String clientIp;
	
	/**
	 * 
	 */
	protected Parameters() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the sourceId
	 */
	public Long getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}


	public String getClientIp() {
		return clientIp;
	}


	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

}
