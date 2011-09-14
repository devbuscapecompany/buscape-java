package com.buscape.developer.request;

import com.buscape.developer.util.Messages;

/**
 * Countries codes used on url composition to API calls. 
 * 
 * @author neto
 */
public enum Country {
	/**
	 * Argentina
	 */
	ARGENTINA(Messages.getString("Country.argentina")), //$NON-NLS-1$

	/**
	 * Brazil
	 */
	BRAZIL(Messages.getString("Country.brasil")), //$NON-NLS-1$

	/**
	 * Chile
	 */
	CHILE(Messages.getString("Country.chile")), //$NON-NLS-1$

	/**
	 * Colombia
	 */
	COLOMBIA(Messages.getString("Country.colombia")), //$NON-NLS-1$

	/**
	 * Mexico
	 */
	MEXICO(Messages.getString("Country.mexico")), //$NON-NLS-1$

	/**
	 * Peru
	 */
	PERU(Messages.getString("Country.peru")), //$NON-NLS-1$

	/**
	 * Venezuela
	 */
	VENEZUELA(Messages.getString("Country.venezuela")); //$NON-NLS-1$


	private String code;

	private Country( String code ){
		this.code = code;
	}

	/**
	 * The code, to be used on url composition, of current country.
	 * @return a string with the value of code.
	 */
	public String code(){
		return code;
	}
}