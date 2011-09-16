package com.buscape.developer.request;

public final class ParametersBuilder {

	private final Parameters params;
	
	public ParametersBuilder() {
		this.params = new Parameters();
	}
	
	public ParametersBuilder categoryId(Integer categoryId) {
		this.params.setCategoryId(categoryId);
		return this;
	}
	
	public ParametersBuilder productId(Integer productId) {
		this.params.setProductId(productId);
		return this;
	}
	
	public ParametersBuilder sellerId(Integer sellerId) {
		this.params.setSellerId(sellerId);
		return this;
	}
	
	public ParametersBuilder keyword(String keyword) {
		this.params.setKeyword(keyword);
		return this;
	}
	
	public ParametersBuilder barcode(String barcode) {
		this.params.setBarcode(barcode);
		return this;
	}
	
	public Parameters build() {
		return this.params;
	}
	
}
