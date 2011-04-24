package com.jakewharton.domainr;

import com.jakewharton.domainr.services.InfoService;
import com.jakewharton.domainr.services.SearchService;

/**
 * Class to manage service creation with default settings.
 * 
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public class ServiceManager {
	/** Connection timeout (in milliseconds). */
	private Integer connectionTimeout;
	/** Read timeout (in milliseconds). */
	private Integer readTimeout;
	
	
	/** Create a new manager instance. */
	public ServiceManager() {}
	
	
	/**
	 * Set default connection timeout.
	 * 
	 * @param connectionTimeout Timeout (in milliseconds).
	 * @return Current instance for builder pattern.
	 */
	public ServiceManager setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this;
	}
	
	/**
	 * Set default read timeout.
	 * 
	 * @param readTimeout Timeout (in milliseconds).
	 * @return Current instance for builder pattern.
	 */
	public ServiceManager setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}
	
	/**
	 * Set up a new service with the defaults.
	 * 
	 * @param service Service to set up.
	 */
	private void setupService(DomainrApiService service) {
		if (this.connectionTimeout != null) {
			service.setConnectTimeout(this.connectionTimeout);
		}
		if (this.readTimeout != null) {
			service.setReadTimeout(this.readTimeout);
		}
	}
	
	/**
	 * Get info service instance.
	 * 
	 * @return Instance.
	 */
	public InfoService infoService() {
		InfoService service = ServiceManager.newInfoService();
		this.setupService(service);
		return service;
	}
	
	/**
	 * Get search service instance.
	 * 
	 * @return Instance.
	 */
	public SearchService searchService() {
		SearchService service = ServiceManager.newSearchService();
		this.setupService(service);
		return service;
	}
	
	
	/**
	 * Create new info service instance.
	 * 
	 * @return Instance.
	 */
	public static final InfoService newInfoService() {
		return new InfoService();
	}
	
	/**
	 * Create new search service instance.
	 * 
	 * @return Instance.
	 */
	public static final SearchService newSearchService() {
		return new SearchService();
	}
}
