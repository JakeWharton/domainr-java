package com.jakewharton.domainr;

import com.google.gson.Gson;
import com.jakewharton.domainr.DomainrApiService;
import com.jakewharton.domainr.enumerations.Availability;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDomainrApiService extends TestCase {
	private Gson gson;

	@Override
	protected void setUp() throws Exception {
		this.gson = DomainrApiService.getGsonBuilder().create();
	}
	
	/**
	 * Test deserialization of enumeration types.
	 */
	public void testEnumerationDeserialization() {
		Availability stateStatus1 = Availability.Available;
		
		Availability stateStatus2 = this.gson.fromJson("\"" + stateStatus1 + "\"", Availability.class);
		
		Assert.assertEquals(stateStatus1, stateStatus2);
	}
}
