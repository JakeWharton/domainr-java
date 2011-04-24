package com.jakewharton.domainr.entities;

import java.util.List;
import com.jakewharton.domainr.DomainrEntity;
import com.jakewharton.domainr.enumerations.Availability;

/**
 * Represents a Domainr search result.
 */
public final class SearchResult implements DomainrEntity {
	private static final long serialVersionUID = -1156218153258462856L;
	
	/**
	 * Represents a single domain object in a query result.
	 */
	public static final class Result implements DomainrEntity {
		private static final long serialVersionUID = -5584366260827037899L;
		
		private String domain;
		private String registerUrl;
		private String host;
		private String path;
		private String subdomain;
		private Availability availability;
		
		public String getDomain() {
			return this.domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getRegisterUrl() {
			return this.registerUrl;
		}
		public void setRegisterUrl(String registerUrl) {
			this.registerUrl = registerUrl;
		}
		public String getHost() {
			return this.host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getPath() {
			return this.path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getSubdomain() {
			return this.subdomain;
		}
		public void setSubdomain(String subdomain) {
			this.subdomain = subdomain;
		}
		public Availability getAvailability() {
			return this.availability;
		}
		public void setAvailability(Availability availability) {
			this.availability = availability;
		}
	}
	
	public static final class Error implements DomainrEntity {
		private static final long serialVersionUID = -1013139356354907794L;
		
		private int status;
		private String message;
		
		public int getStatus() {
			return this.status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return this.message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	private String query;
	private List<Result> results;
	private Error error;
	
	public String getQuery() {
		return this.query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public List<Result> getResults() {
		return this.results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public Error getError() {
		return this.error;
	}
	public void setError(Error error) {
		this.error = error;
	}
}