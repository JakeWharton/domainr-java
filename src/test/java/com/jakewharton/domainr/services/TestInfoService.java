package com.jakewharton.domainr.services;

import com.jakewharton.domainr.ServiceManager;
import com.jakewharton.domainr.entities.InfoResult;
import com.jakewharton.domainr.enumerations.Availability;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestInfoService extends TestCase {
	private ServiceManager serviceManager;
	
	@Override
	protected void setUp() throws Exception {
		this.serviceManager = new ServiceManager();
	}
	
	/**
	 * Test an info query on http://domi.nr/ itself.
	 */
	public void testInfoQuery() {
		String query = "domai.nr";
		InfoResult result = this.serviceManager.infoService().query(query).fire();
		
		Assert.assertNotNull(result);
		Assert.assertEquals("domai.nr", result.getDomain());
		Assert.assertEquals("http://domai.nr/domai.nr/whois", result.getWhoisUrl());
		Assert.assertEquals("http://domai.nr/domai.nr/register", result.getRegisterUrl());
		Assert.assertEquals("", result.getHost());
		Assert.assertEquals("", result.getPath());
		Assert.assertEquals("http://domai.nr/domai.nr/www", result.getWwwUrl());
		Assert.assertEquals(query, result.getQuery());
		Assert.assertEquals("domai.nr", result.getSubdomain());
		Assert.assertEquals("domai.nr", result.getDomainIdna());
		Assert.assertEquals(Availability.Taken, result.getAvailability());
		
		Assert.assertNotNull(result.getTld());
		Assert.assertEquals("nr", result.getTld().getDomain());
		Assert.assertEquals("nr", result.getTld().getDomainIdna());
		Assert.assertEquals("http://wikipedia.org/wiki/.nr", result.getTld().getWikipediaUrl());
		Assert.assertEquals("http://www.iana.org/domains/root/db/nr.html", result.getTld().getIanaUrl());
		
		Assert.assertNotNull(result.getRegistrars());
		Assert.assertTrue(result.getRegistrars().size() > 0);
		Assert.assertNotNull(result.getRegistrars().get(0).getRegistrar());
		Assert.assertNotNull(result.getRegistrars().get(0).getName());
		Assert.assertNotNull(result.getRegistrars().get(0).getRegisterUrl());
		
	}
}
