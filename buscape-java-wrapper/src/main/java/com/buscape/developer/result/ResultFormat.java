package com.buscape.developer.result;

import com.buscape.developer.util.Messages;

/**
 * Format of API call response.
 * 
 * @author neto
 */
public enum ResultFormat {
	/**
	 * JSON format
	 */
	JSON( Messages.getString("ResultFormat.json") ), //$NON-NLS-1$

	/**
	 * XML format
	 */
	XML( Messages.getString("ResultFormat.xml") ); //$NON-NLS-1$


	private String format;

	private ResultFormat( String format ) {
		this.format = format;
	}

	@Override
	public String toString() {
		return format;
	}
	
	/**
	 * Returns a instance equivalent to the value.
	 * @param value the value of {@link ResultFormat}.
	 * @return a {@link ResultFormat} equivalent to value.
	 */
	public static ResultFormat fromString(String value) {
		if(Messages.getString("ResultFormat.json").equals(value)) { //$NON-NLS-1$
			return JSON;
		} else if(Messages.getString("ResultFormat.xml").equals(value)) { //$NON-NLS-1$
			return XML;
		} else {
			throw new IllegalArgumentException(String.format("The string '%s' is not a valid result format.", value)); //$NON-NLS-1$
		}
	}
}