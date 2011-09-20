package com.buscape.developer.request;

import com.buscape.developer.util.Messages;

/**
 * Types of sorting available in API calls. 
 * @author neto
 */
public enum Sort {
	
	/**
	 * Descending ordering by price of parcel.
	 */
	D_INSTALLMENT(Messages.getString("Sort.desc-installment")), //$NON-NLS-1$

	/**
	 * Descending ordering by number of parcels.
	 */
	D_NUMBEROFINSTALLMENTS(Messages.getString("Sort.desc-num-installment")), //$NON-NLS-1$

	/**
	 * Descending ordering by price.
	 */
	D_PRICE(Messages.getString("Sort.desc-price")), //$NON-NLS-1$

	/**
	 * Descending ordering by user rating.
	 */
	D_RATE(Messages.getString("Sort.desc-rate")), //$NON-NLS-1$

	/**
	 * Descending ordering by seller.
	 */
	D_SELLER(Messages.getString("Sort.desc-seller")), //$NON-NLS-1$

	/**
	 * Ascending ordering by price of parcel.
	 */
	INSTALLMENT(Messages.getString("Sort.installment")), //$NON-NLS-1$

	/**
	 * Ascending ordering by number of parcel.
	 */
	NUMBEROFINSTALLMENTS(Messages.getString("Sort.num-installment")), //$NON-NLS-1$

	/**
	 * Ascending ordering by price.
	 */
	PRICE(Messages.getString("Sort.price")), //$NON-NLS-1$

	/**
	 * Ascending ordering by user rating.
	 */
	RATE(Messages.getString("Sort.rate")), //$NON-NLS-1$

	/**
	 * Ascending ordering by seller.
	 */
	SELLER(Messages.getString("Sort.seller")), //$NON-NLS-1$

	/**
	 * Ascending ordering by seal of trusted store.
	 */
	TRUSTEDSTORE(Messages.getString("Sort.trusted-store")); //$NON-NLS-1$


	private String sort;

	private Sort( String sort ){
		this.sort = sort;
	}

	/**
	 * @return string representation of sorting type
	 */
	@Override
	public String toString(){
		return sort;
	}
}