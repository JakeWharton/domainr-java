package com.jakewharton.domainr.services;

import com.jakewharton.domainr.ServiceManager;
import com.jakewharton.domainr.entities.SearchResult;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSearchService extends TestCase {
	private ServiceManager serviceManager;
	
	@Override
	protected void setUp() throws Exception {
		this.serviceManager = new ServiceManager();
	}
	
	/**
	 * Test a search query on http://domi.nr/ itself.
	 */
	public void testSearchQuery() {
		String query = "domai.nr";
		SearchResult result = this.serviceManager.searchService().query(query).fire();
		
		Assert.assertNotNull(result);
		Assert.assertEquals(query, result.getQuery());
		
		Assert.assertNotNull(result.getResults());
		Assert.assertTrue(result.getResults().size() > 0);
		Assert.assertNotNull(result.getResults().get(0).getDomain());
		Assert.assertNotNull(result.getResults().get(0).getRegisterUrl());
		Assert.assertNotNull(result.getResults().get(0).getHost());
		Assert.assertNotNull(result.getResults().get(0).getPath());
		Assert.assertNotNull(result.getResults().get(0).getSubdomain());
		Assert.assertNotNull(result.getResults().get(0).getAvailability());
	}
}
