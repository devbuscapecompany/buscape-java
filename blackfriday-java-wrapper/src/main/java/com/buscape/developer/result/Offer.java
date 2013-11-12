package com.buscape.developer.result;

public class Offer {

	private String offerName;
	private Integer categoryId;
	private Long id;
	private Boolean featured;
	private String outLink;
	
	private Links links;
	private Thumbnail thumbnail;
	private Price price;
	private Seller seller;
	
	/**
	 * @return the offerName
	 */
	public String getOfferName() {
		return offerName;
	}
	/**
	 * @param offerName the offerName to set
	 */
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the featured
	 */
	public Boolean getFeatured() {
		return featured;
	}
	/**
	 * @param featured the featured to set
	 */
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	/**
	 * @return the outLink
	 */
	public String getOutLink() {
		return outLink;
	}
	/**
	 * @param outLink the outLink to set
	 */
	public void setOutLink(String outLink) {
		this.outLink = outLink;
	}
	/**
	 * @return the links
	 */
	public Links getLinks() {
		return links;
	}
	/**
	 * @param links the links to set
	 */
	public void setLinks(Links links) {
		this.links = links;
	}
	/**
	 * @return the thumbnail
	 */
	public Thumbnail getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Price price) {
		this.price = price;
	}
	/**
	 * @return the seller
	 */
	public Seller getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
}
