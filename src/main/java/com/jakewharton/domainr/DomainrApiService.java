package com.jakewharton.domainr;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.apibuilder.ApiException;
import com.jakewharton.apibuilder.ApiService;
import com.jakewharton.domainr.enumerations.Availability;

/**
 * Domainr-specific API service extension which facilitates provides helper
 * methods for performing remote method calls as well as deserializing the
 * corresponding JSON responses.
 * 
 * @author Jake Wharton <jakewharton@gmail.com>
 */
public abstract class DomainrApiService extends ApiService {
	/** Default connection timeout (in milliseconds). */
	private static final int DEFAULT_TIMEOUT_CONNECT = 60 * 1000;
	
	/** Default read timeout (in milliseconds). */
	private static final int DEFAULT_TIMEOUT_READ = 60 * 1000;
	
	/** Character set used for encoding and decoding transmitted values. */
	private static final Charset UTF_8_CHAR_SET = Charset.forName(ApiService.CONTENT_ENCODING);
	
	
	/** JSON parser for reading the content stream. */
    private final JsonParser parser;
	
    
    /**
     * Create a new Domainr service with our proper default values.
     */
	public DomainrApiService() {
		this.parser = new JsonParser();
		
		this.setConnectTimeout(DEFAULT_TIMEOUT_CONNECT);
		this.setReadTimeout(DEFAULT_TIMEOUT_READ);
		this.acceptGzip();
	}
	
	
	/**
	 * Execute request using HTTP GET.
	 * 
	 * @param url URL to request.
	 * @return JSON object.
	 */
	public JsonObject get(String url) {
		return this.unmarshall(this.executeGet(url));
	}

	/**
	 * Use GSON to deserialize a JSON object to a native class representation.
	 * 
	 * @param <T> Native class type.
	 * @param typeToken Native class type wrapper.
	 * @param response Serialized JSON object.
	 * @return Deserialized native instance.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
		return (T)DomainrApiService.getGsonBuilder().create().fromJson(response, typeToken.getType());
	}
	
	/**
	 * Read the entirety of an input stream and parse to a JSON object.
	 * 
	 * @param jsonContent JSON content input stream.
	 * @return Parsed JSON object.
	 */
	protected JsonObject unmarshall(InputStream jsonContent) {
        try {
        	JsonElement element = this.parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (element.isJsonObject()) {
        		return element.getAsJsonObject();
        	} else {
        		throw new ApiException("Unknown content found in response." + element);
        	}
        } catch (Exception e) {
            throw new ApiException(e);
        } finally {
	        ApiService.closeStream(jsonContent);
	    }
	}

	/**
	 * Create a {@link GsonBuilder} and register all of the custom types needed
	 * in order to properly deserialize complex Domainr-specific types.
	 * 
	 * @return Assembled GSON builder instance.
	 */
	static GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		
		builder.registerTypeAdapter(Availability.class, new JsonDeserializer<Availability>() {
			@Override
			public Availability deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return Availability.fromValue(json.getAsString());
			}
		});
		
		return builder;
	}
}
