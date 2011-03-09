package com.buscape.developer.request;

import com.buscape.developer.util.Messages;

public enum Service {
	
	LIST_CATEGORY(Messages.getString("Service.find-category-service")), //$NON-NLS-1$
	LIST_PRODUCT(Messages.getString("Service.find-product-service")), //$NON-NLS-1$
	LIST_OFFER(Messages.getString("Service.find-offer-service")), //$NON-NLS-1$
	TOP_PRODUCTS(Messages.getString("Service.top-products-service")), //$NON-NLS-1$
	USER_RATING(Messages.getString("Service.user-rating-service")), //$NON-NLS-1$
	DETAILS_PRODUCT(Messages.getString("Service.product-details-service")), //$NON-NLS-1$
	DETAILS_SELLER(Messages.getString("Service.seller-details-service")); //$NON-NLS-1$
	
	private String service;
	
	private Service(String service) {
		this.service = service;
	}
	
	@Override
	public String toString() {
		return this.service;
	}

}
