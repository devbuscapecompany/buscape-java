package com.buscape.developer.request;

import com.buscape.developer.util.Messages;


/**
 * Medals from EBit
 * @author neto
 */
public enum EBitMedal {
	/**
	 * Any medal
	 */
	ALL( Messages.getString("Medal.all") ), //$NON-NLS-1$

	/**
	 * Bronze medal
	 */
	BRONZE( Messages.getString("Medal.bronze") ), //$NON-NLS-1$

	/**
	 * Diamond medal
	 */
	DIAMOND( Messages.getString("Medal.diamond") ), //$NON-NLS-1$

	/**
	 * Gold medal
	 */
	GOLD( Messages.getString("Medal.gold") ), //$NON-NLS-1$

	/**
	 * Silver medal
	 */
	SILVER( Messages.getString("Medal.silver") ); //$NON-NLS-1$

	private String medal;

	private EBitMedal( String medal ) {
		this.medal = medal;
	}
	
	public static EBitMedal fromString( String medal ) throws IllegalArgumentException {
		if ( medal.equals( Messages.getString("Medal.all") ) ){ //$NON-NLS-1$
			return ALL;
		} else if ( medal.equals( Messages.getString("Medal.bronze") ) ) { //$NON-NLS-1$
			return BRONZE;
		} else if ( medal.equals( Messages.getString("Medal.diamond") ) ){ //$NON-NLS-1$
			return DIAMOND;
		} else if ( medal.equals( Messages.getString("Medal.gold") ) ) { //$NON-NLS-1$
			return GOLD;
		} else if ( medal.equals( Messages.getString("Medal.silver") ) ) { //$NON-NLS-1$
			return SILVER;
		} else {
			throw new IllegalArgumentException(String.format("The medal '%s' isn't recognized.", medal)); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}


	/**
	 * @return string representation of medal
	 */
	@Override
	public String toString() {
		return medal;
	}
}