package com.jakewharton.domainr.enumerations;

import java.util.HashMap;
import java.util.Map;
import com.jakewharton.domainr.DomainrEnumeration;

/**
 * Represents domain availability.
 */
public enum Availability implements DomainrEnumeration {
	Taken("taken"),
	Available("available"),
	Maybe("maybe"),
	TLD("tld");
	
	private final String value;
	
	private Availability(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	private static final Map<String, Availability> stringToEnum = new HashMap<String, Availability>();

	static {
		for (Availability status : Availability.values()) {
			stringToEnum.put(status.toString(), status);
		}
	}
	
	public static Availability fromValue(String value) {
		return stringToEnum.get(value);
	}
}