package com.buscape.developer.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class HttpRequester {
	
	private HttpURLConnection conn;
	private URLRequestMethod method;
	private URL url;
	
	/**
	 * Constructs HttpRequester object with <code>GET</code> as method..
	 * @param url a url used in requests of the new object.
	 */
	public HttpRequester(String url) {
		this(url, URLRequestMethod.GET);
	}
	
	/**
	 * Constructs HttpRequester object.
	 * @param url a url used in requests of the new object.
	 * @param method the http method used in requests of the new object.
	 */
	public HttpRequester(String url, URLRequestMethod method) {
		super();
		try {
			this.url = new URL(url);
			this.method = method;
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Performs an http request in url and returns its response.
	 * @return an string with the content of response.
	 * @throws IOException if an I/O error occurs while reading the response.
	 */
	public String getResponse() throws IOException {
		createConnection();
		return readInputStream();		
	}

	private void createConnection() throws IOException {
		this.conn = (HttpURLConnection) this.url.openConnection();
		this.conn.setRequestMethod(this.method.toString());
		this.conn.setDoOutput(true);
		this.conn.connect();		
	}
	
	private String readInputStream() throws IOException {
		InputStream in = conn.getInputStream();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			final StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line + '\n');
			}
			
			return sb.toString();
		} finally { 
			try {
				in.close();
			} catch (IOException ignored) {
			}
		}
	}

}