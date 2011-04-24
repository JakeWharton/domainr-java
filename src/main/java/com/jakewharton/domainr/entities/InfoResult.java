package com.jakewharton.domainr.entities;

import java.util.List;
import com.jakewharton.domainr.DomainrEntity;
import com.jakewharton.domainr.enumerations.Availability;

/**
 * Represents a Domainr info result.
 */
public final class InfoResult implements DomainrEntity {
	private static final long serialVersionUID = 9152702812297209848L;
	
	/**
	 * Represents a TLD.
	 */
	public static final class Tld implements DomainrEntity {
		private static final long serialVersionUID = -4863211966201619201L;
		
		private String domain;
		private String domainIdna;
		private String wikipediaUrl;
		private String ianaUrl;
		
		public String getDomain() {
			return this.domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getDomainIdna() {
			return this.domainIdna;
		}
		public void setDomainIdna(String domainIdna) {
			this.domainIdna = domainIdna;
		}
		public String getWikipediaUrl() {
			return this.wikipediaUrl;
		}
		public void setWikipediaUrl(String wikipediaUrl) {
			this.wikipediaUrl = wikipediaUrl;
		}
		public String getIanaUrl() {
			return this.ianaUrl;
		}
		public void setIanaUrl(String ianaUrl) {
			this.ianaUrl = ianaUrl;
		}
	}
	
	/**
	 * Represents a domain registrar.
	 */
	public static final class Registrar implements DomainrEntity {
		private static final long serialVersionUID = -6017321094631779092L;
		
		private String registrar;
		private String name;
		private String registerUrl;
		
		public String getRegistrar() {
			return this.registrar;
		}
		public void setRegistrar(String registrar) {
			this.registrar = registrar;
		}
		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRegisterUrl() {
			return this.registerUrl;
		}
		public void setRegisterUrl(String registerUrl) {
			this.registerUrl = registerUrl;
		}
	}
	
	private String domain;
	private String whoisUrl;
	private String registerUrl;
	private Tld tld;
	private List<Registrar> registrars;
	private String host;
	private String path;
	private String wwwUrl;
	private String query;
	private String subdomain;
	private String domainIdna;
	private Availability availability;
	
	public String getDomain() {
		return this.domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getWhoisUrl() {
		return this.whoisUrl;
	}
	public void setWhoisUrl(String whoisUrl) {
		this.whoisUrl = whoisUrl;
	}
	public String getRegisterUrl() {
		return this.registerUrl;
	}
	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}
	public Tld getTld() {
		return this.tld;
	}
	public void setTld(Tld tld) {
		this.tld = tld;
	}
	public List<Registrar> getRegistrars() {
		return this.registrars;
	}
	public void setRegistrars(List<Registrar> registrars) {
		this.registrars = registrars;
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
	public String getWwwUrl() {
		return this.wwwUrl;
	}
	public void setWwwUrl(String wwwUrl) {
		this.wwwUrl = wwwUrl;
	}
	public String getQuery() {
		return this.query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSubdomain() {
		return this.subdomain;
	}
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	public String getDomainIdna() {
		return this.domainIdna;
	}
	public void setDomainIdna(String domainIdna) {
		this.domainIdna = domainIdna;
	}
	public Availability getAvailability() {
		return this.availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
}