package com.buscape.developer.result;

import java.util.List;

public class Result {
	
	private Integer totalResultsAvailable;
	private Integer totalResultsReturned;
	private Integer totalLooseOffers;
	private Details details;
	private List<Offer> offer;
	private Categorys categorys;
	
	/**
	 * @return the totalResultsAvailable
	 */
	public Integer getTotalResultsAvailable() {
		return totalResultsAvailable;
	}
	/**
	 * @param totalResultsAvailable the totalResultsAvailable to set
	 */
	public void setTotalResultsAvailable(Integer totalResultsAvailable) {
		this.totalResultsAvailable = totalResultsAvailable;
	}
	/**
	 * @return the totalResultsReturned
	 */
	public Integer getTotalResultsReturned() {
		return totalResultsReturned;
	}
	/**
	 * @param totalResultsReturned the totalResultsReturned to set
	 */
	public void setTotalResultsReturned(Integer totalResultsReturned) {
		this.totalResultsReturned = totalResultsReturned;
	}
	/**
	 * @return the totalLooseOffers
	 */
	public Integer getTotalLooseOffers() {
		return totalLooseOffers;
	}
	/**
	 * @param totalLooseOffers the totalLooseOffers to set
	 */
	public void setTotalLooseOffers(Integer totalLooseOffers) {
		this.totalLooseOffers = totalLooseOffers;
	}
	/**
	 * @return the details
	 */
	public Details getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(Details details) {
		this.details = details;
	}
	/**
	 * @return the offer
	 */
	public List<Offer> getOffer() {
		return offer;
	}
	/**
	 * @param offer the offer to set
	 */
	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}
	public Categorys getCategorys() {
		return categorys;
	}
	public void setCategorys(Categorys categorys) {
		this.categorys = categorys;
	}
}
