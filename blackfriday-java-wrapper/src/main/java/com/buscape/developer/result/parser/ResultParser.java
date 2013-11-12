package com.buscape.developer.result.parser;

import com.buscape.developer.result.Result;
import com.google.gson.Gson;

/**
 * @author Daniel Freire (09/11/2013)
 *
 */
public class ResultParser {
	
	private String data;
	
	/**
	 * @param json 
	 * 
	 */
	public ResultParser(String json) {
		this.data = json;
	}

	/**
	 * @return
	 */
	public Result getResult() {
		return new Gson().fromJson(data, Result.class);
	}

}
