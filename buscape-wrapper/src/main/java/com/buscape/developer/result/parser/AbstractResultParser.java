package com.buscape.developer.result.parser;

import com.buscape.developer.result.type.Result;


public abstract class AbstractResultParser {
	
	protected Result result;
	protected final String data;
	
	/**
	 * Default constructor that indicates the raw data of parser.
	 * @param data the raw data that will be parsed.
	 */
	public AbstractResultParser(String data) {
		this.data = data;
	}
	
	/**
	 * Parses the raw data of a single API call into a {@link Result} object and return it.
	 * @return a {@link Result} object populated with information of API call.
	 */
	public abstract Result getResult();
}