package com.buscape.developer.request;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class Parameters {

	private Integer categoryId;
	
	private Integer productId;
	
	private Integer sellerId;
	
	private String keyword;
	
	private String barcode;
	

	/**
	 * @return the categoryId
	 */
	public final Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public final void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the productId
	 */
	public final Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public final void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the sellerId
	 */
	public final Integer getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public final void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the keyword
	 */
	public final String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public final void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the barcode
	 */
	public final String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public final void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	/**
	 * Build a {@link Map} that represents this instance. The pair 
	 * key/value of map are the name of fields in object and the values 
	 * of fields, respectively.
	 * @return a {@link Map} populated with the values of this instance.
	 */
	public Map<String, Object> asMap() {
		Map<String, Object> result = new HashMap<String, Object>();

		for (Field field : getClass().getDeclaredFields()) {
			try {
				String fieldName = field.getName();
				Method getter = getClass().getMethod(buildGetterName(fieldName));
				Object fieldValue = getter.invoke(this);
				if (fieldValue != null) {
					result.put(fieldName, fieldValue);
				}
			} catch (Exception ignored) {
			} 
		}

		return result;
	}

	private String buildGetterName(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); //$NON-NLS-1$
	}	
}
