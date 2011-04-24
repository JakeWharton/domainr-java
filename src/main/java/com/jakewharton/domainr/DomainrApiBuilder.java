package com.jakewharton.domainr;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.apibuilder.ApiBuilder;

/**
 * Domainr-specific API builder extension which provides helper methods for
 * adding fields, parameters, and post-parameters commonly used in the API.
 * 
 * @param <T> Native class type of the HTTP method call result.
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public abstract class DomainrApiBuilder<T> extends ApiBuilder {
	/** Domainr API URL base. */
	private static final String BASE_URL = "http://domai.nr";
	
	/** Domainr API URI base. */
	private static final String BASE_URI = "/api/json";
	
	
	/** Service instance. */
	private final DomainrApiService service;
	
	/** Type token of return type. */
	private final TypeToken<T> token;
	
	
	/**
	 * Initialize a new builder for the specified HTTP method and API version.
	 * 
	 * @param service Service to bind to.
	 * @param token Return type token.
	 * @param urlFormat URL format string.
	 */
	public DomainrApiBuilder(DomainrApiService service, TypeToken<T> token, String urlFormat) {
		super(BASE_URL + BASE_URI + urlFormat);
		
		this.service = service;
		this.token = token;
	}

	
	/**
	 * Execute remote API method and unmarshall the result to its native type.
	 * 
	 * @return Instance of result type.
	 */
	public final T fire() {
		return this.service.unmarshall(this.token, this.execute());
	}
	
	/**
	 * <p>Execute the remote API method and return the JSON object result.<p>
	 * 
	 * <p>This method can be overridden to select a specific subset of the JSON
	 * object. The overriding implementation should still call 'super.execute()'
	 * and then perform the filtering from there.</p> 
	 * 
	 * @return JSON object instance.
	 */
	protected JsonElement execute() {
		return this.service.get(this.buildUrl());
	}
}
