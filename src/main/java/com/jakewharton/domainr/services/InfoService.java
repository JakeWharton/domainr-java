package com.jakewharton.domainr.services;

import com.google.gson.reflect.TypeToken;
import com.jakewharton.domainr.DomainrApiBuilder;
import com.jakewharton.domainr.DomainrApiService;
import com.jakewharton.domainr.entities.InfoResult;

/**
 * Represents Domainr's remote search service.
 */
public final class InfoService extends DomainrApiService {
	/**
	 * Query a specific set of terms.
	 * 
	 * @return Builder instance.
	 */
	public final InfoBuilder query(String query) {
		return new InfoBuilder(this).query(query);
	}
	
	/**
	 * Request builder for {@link InfoService#query(String)}.
	 */
	public static final class InfoBuilder extends DomainrApiBuilder<InfoResult> {
		private static final String PARAM_QUERY = "q";
		
		private static final String URI = "/info";
		
		private InfoBuilder(InfoService service) {
			super(service, new TypeToken<InfoResult>() {}, URI);
		}
		
		/**
		 * Search string to query against.
		 * 
		 * @param query Search query.
		 * @return Builder instance.
		 */
		public InfoBuilder query(String query) {
			this.parameter(PARAM_QUERY, query);
			return this;
		}
	}
}
