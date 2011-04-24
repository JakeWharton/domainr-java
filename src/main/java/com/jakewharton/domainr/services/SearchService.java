package com.jakewharton.domainr.services;

import com.google.gson.reflect.TypeToken;
import com.jakewharton.domainr.DomainrApiBuilder;
import com.jakewharton.domainr.DomainrApiService;
import com.jakewharton.domainr.entities.SearchResult;

/**
 * Represents Domainr's remote search service.
 */
public final class SearchService extends DomainrApiService {
	/**
	 * Query a specific set of terms.
	 * 
	 * @return Builder instance.
	 */
	public final QueryBuilder query(String query) {
		return new QueryBuilder(this).query(query);
	}
	
	/**
	 * Request builder for {@link SearchService#query(String)}.
	 */
	public static final class QueryBuilder extends DomainrApiBuilder<SearchResult> {
		private static final String PARAM_QUERY = "q";
		
		private static final String URI = "/search";
		
		private QueryBuilder(SearchService service) {
			super(service, new TypeToken<SearchResult>() {}, URI);
		}
		
		/**
		 * Search string to query against.
		 * 
		 * @param query Search query.
		 * @return Builder instance.
		 */
		public QueryBuilder query(String query) {
			this.parameter(PARAM_QUERY, query);
			return this;
		}
	}
}
