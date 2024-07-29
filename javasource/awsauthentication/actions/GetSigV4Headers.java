// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package awsauthentication.actions;

import static java.util.Objects.requireNonNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import awsauthentication.impl.MxLogger;
import awsauthentication.impl.Utils;
import awsauthentication.proxies.SigV4Headers;
import awsauthentication.proxies.SigV4Parameter;
import awsauthentication.proxies.TemporaryCredentials;

/**
 * GetSigV4Headers java action calculates and provides headers needed to make a RESTful call to AWS Services.
 * Description of all input entity attributes and the output entity attributes can be found in the attribute documentation in the Domain Model.
 * Note - If you are using temporary credentials (object of type TemporaryCredentials), then add the header 'x-amz-security-token' with value as the TemporaryCredentials/Token attribute in the REST request.
 */
public class GetSigV4Headers extends CustomJavaAction<IMendixObject>
{
	/** @deprecated use Credentials.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Credentials;
	private final awsauthentication.proxies.Credentials Credentials;
	/** @deprecated use SigV4Builder.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __SigV4Builder;
	private final awsauthentication.proxies.SigV4Builder SigV4Builder;
	/** @deprecated use com.mendix.utils.ListUtils.map(Headers, com.mendix.systemwideinterfaces.core.IEntityProxy::getMendixObject) instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final java.util.List<IMendixObject> __Headers;
	private final java.util.List<awsauthentication.proxies.SigV4Parameter> Headers;
	/** @deprecated use com.mendix.utils.ListUtils.map(QueryParameters, com.mendix.systemwideinterfaces.core.IEntityProxy::getMendixObject) instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final java.util.List<IMendixObject> __QueryParameters;
	private final java.util.List<awsauthentication.proxies.SigV4Parameter> QueryParameters;

	public GetSigV4Headers(
		IContext context,
		IMendixObject _credentials,
		IMendixObject _sigV4Builder,
		java.util.List<IMendixObject> _headers,
		java.util.List<IMendixObject> _queryParameters
	)
	{
		super(context);
		this.__Credentials = _credentials;
		this.Credentials = _credentials == null ? null : awsauthentication.proxies.Credentials.initialize(getContext(), _credentials);
		this.__SigV4Builder = _sigV4Builder;
		this.SigV4Builder = _sigV4Builder == null ? null : awsauthentication.proxies.SigV4Builder.initialize(getContext(), _sigV4Builder);
		this.__Headers = _headers;
		this.Headers = java.util.Optional.ofNullable(_headers)
			.orElse(java.util.Collections.emptyList())
			.stream()
			.map(headersElement -> awsauthentication.proxies.SigV4Parameter.initialize(getContext(), headersElement))
			.collect(java.util.stream.Collectors.toList());
		this.__QueryParameters = _queryParameters;
		this.QueryParameters = java.util.Optional.ofNullable(_queryParameters)
			.orElse(java.util.Collections.emptyList())
			.stream()
			.map(queryParametersElement -> awsauthentication.proxies.SigV4Parameter.initialize(getContext(), queryParametersElement))
			.collect(java.util.stream.Collectors.toList());
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			requireNonNull(Credentials, "AWS Credentials are required");
			requireNonNull(SigV4Builder, "SigV4Builder object is required");
			
			// instantiate required date/time variables
			Date now = getDate();
			String amzDate = getAmzDate(now);
			String dateStamp = getDateStamp(now);
			
			// Get AWS Region as String
			String awsRegionString = Utils.convertAWSRegion(SigV4Builder.getRegion()).toString();
			
			// Get the initial headers
			Map<String, String> headers = getHeaders(amzDate, awsRegionString);
			
			// Get credentialScop, canocicalQueryString and signed headers, that are needed as inputs in more than one place
			String credentialScope = getCredentialScope(dateStamp, awsRegionString);
			String canonicalQueryString = getCanonicalizedQueryString();
			String signedHeaders = getCanonicalizeHeaderNames(headers);
			
			LOGGER.trace("The signed headers are " + signedHeaders);
	
			// Create signature
			String signature = getSignature(SCHEME,
					Credentials.getSecretAccessKey(),
					dateStamp,
					awsRegionString,
					SigV4Builder.getServiceName(),
					getStringToSign(headers, canonicalQueryString, signedHeaders, amzDate, credentialScope));
			
			// Create authorization header from signature
			String authorizationHeader = getAuthorizationHeader(credentialScope, signedHeaders, signature);
			
			// Add authorization header
			headers.put(HEADER_AUTHORIZATION, authorizationHeader);

			LOGGER.trace("--------- Request headers ---------");
			LOGGER.trace(headers);
			LOGGER.trace("-----------------------------------");
		
			// Create and return Mendix SigV4Headers object
			SigV4Headers mxSigV4Headers = getMxSigV4Headers(authorizationHeader, amzDate, canonicalQueryString, awsRegionString);
			return mxSigV4Headers.getMendixObject();
		
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), ":", e.getStackTrace());
			throw new MendixRuntimeException(e);
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetSigV4Headers";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(GetSigV4Headers.class);
	private static final String DATE_TIME_FORMAT = "yyyyMMdd'T'HHmmss'Z'";
	private static final String DATE_FORMAT = "yyyyMMdd";
	private static final String SCHEME = "AWS4";
	private static final String ALGORITHM = "HMAC-SHA256";
	private static final String TERMINATOR = "aws4_request";
	private static final String ENDPOINT_URL = "amazonaws.com";
	private static final String PAYLOAD_HASH = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
	private static final String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";
	private static final String HMAC_SHA256 = "HmacSHA256";
	private static final String SHA256 = "SHA-256";
	private static final String UTF8 = "UTF-8";
	private static final String HEADER_HOST = "host";
	private static final String HEADER_X_AMZ_DATE = "x-amz-date";
	private static final String HEADER_X_AMZ_CONTENT_SHA256 = "x-amz-content-sha256";
	private static final String HEADER_X_AMZ_SECURITY_TOKEN = "x-amz-security-token";
	private static final String HEADER_AUTHORIZATION = "Authorization";
	
	
	private static Date getDate() {
		Date now = new Date();
		return now;
	}
	
	private static SimpleDateFormat getDFormat(String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		format.setTimeZone(new SimpleTimeZone(0, "UTC"));
		return format;
	}
	
	private static String getAmzDate(Date now) {
		SimpleDateFormat dateTimeFormat = getDFormat(DATE_TIME_FORMAT);
		String amzDate = dateTimeFormat.format(now);
		return amzDate;
	}
	
	private static String getDateStamp(Date now) {
		SimpleDateFormat dateStampFormat = getDFormat(DATE_FORMAT);
		String dateStamp = dateStampFormat.format(now);
		return dateStamp;
	}
	
	private String getEndpointURL() {
		if (SigV4Builder.getEndpointURL() == null || SigV4Builder.getEndpointURL().isBlank()) {
			String endpointURL = ENDPOINT_URL;
			return endpointURL;
		} 			
		String endpointURL = SigV4Builder.getEndpointURL();
		return endpointURL;
	}
	
	private String getSubdomain() {
		if (SigV4Builder.getSubDomain() == null || SigV4Builder.getSubDomain().isBlank()) {
			String subDomain = SigV4Builder.getServiceName();
			return subDomain;
		}
		String subDomain = SigV4Builder.getSubDomain();
		return subDomain;
	}
	
	private String getHost(String awsRegionString) {
		String host = String.format("%s.%s.%s", getSubdomain(), awsRegionString, getEndpointURL());
		if(SigV4Builder.getURIPrefix() != null && !SigV4Builder.getURIPrefix().isBlank()) {
			host = SigV4Builder.getURIPrefix() + "." + host;
		}
		return host;
	}
	
	private String getPayloadHash() {
		if(SigV4Builder.getRequestBody()!=null) {
			String payloadHash = !UNSIGNED_PAYLOAD.equals(SigV4Builder.getRequestBody()) ? toHex(hash(SigV4Builder.getRequestBody())) : SigV4Builder.getRequestBody();
			return payloadHash;
		}
		String payloadHash = PAYLOAD_HASH;
		return payloadHash;
	}
	
	private Map<String, String> getHeaders(String amzDate, String awsRegionString) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(HEADER_HOST, getHost(awsRegionString));
		headers.put(HEADER_X_AMZ_DATE, amzDate);
		headers.put(HEADER_X_AMZ_CONTENT_SHA256, getPayloadHash());
		
		String securityToken = getSecurityToken();
		if (securityToken != null) {
			headers.put(HEADER_X_AMZ_SECURITY_TOKEN, securityToken);
		}
	
		for (SigV4Parameter sigV4Header : Headers) {
			headers.put(sigV4Header.getKey(getContext()), sigV4Header.getValue(getContext()));
		}
		return headers;
	}

	private Map<String, String> getQueryParameters() {
		Map<String, String> queryParameters = new HashMap<String, String>();
		for (SigV4Parameter sigV4QueryParameter : QueryParameters) {
			queryParameters.put(sigV4QueryParameter.getKey(getContext()), sigV4QueryParameter.getValue(getContext()));
		}
		return queryParameters;
	}
	
	private String getCanonicalRequest(Map<String, String> headers, String canonicalQueryString, String signedHeaders) {
		
		String canonicalRequest = String.format("%s\n%s\n%s\n%s\n%s\n%s",
				SigV4Builder.getHTTPMethod().toString(),
				SigV4Builder.getPath(),
				canonicalQueryString,
				getCanonicalizedHeaderString(headers),
				signedHeaders,
				getPayloadHash());
		
		LOGGER.trace("--------- Canonical request --------");
		LOGGER.trace(canonicalRequest);
		LOGGER.trace("------------------------------------");
		
		return canonicalRequest;
	}
	
	private String getStringToSign(Map<String, String> headers, String canonicalQueryString, String signedHeaders, String amzDate, String credentialScope) {
		String stringToSign = String.format("%s-%s\n%s\n%s\n%s",
				SCHEME,
				ALGORITHM,
				amzDate,
				credentialScope,
				toHex(hash(getCanonicalRequest(headers, canonicalQueryString, signedHeaders))));
		
		LOGGER.trace("--------- String to sign -----------");
		LOGGER.trace(stringToSign);
		LOGGER.trace("------------------------------------");
		
		return stringToSign;
	}
	
	private String getCredentialScope(String dateStamp, String awsRegionString) {
		String credentialScope = String.format("%s/%s/%s/%s",
				dateStamp,
				awsRegionString,
				SigV4Builder.getServiceName(),
				TERMINATOR);
		
		return credentialScope;
	}
	
	private String getAuthorizationHeader(String credentialScope, String signedHeaders, String signature) {
		String authorizationHeader = String.format("%s-%s Credential=%s/%s, SignedHeaders=%s, Signature=%s",
				SCHEME,
				ALGORITHM,
				Credentials.getAccessKey(),
				credentialScope,
				signedHeaders,
				signature);
		
		return authorizationHeader;
	}
	
	private String getUrl(String canonicalQueryString, String awsRegionString) {
		String url;
		if(SigV4Builder.getURIPrefix()==null || SigV4Builder.getURIPrefix().isBlank()) {
			url = String.format("https://%s.%s.%s", getSubdomain(), awsRegionString, getEndpointURL());
		}
		else {
			url = String.format("https://%s.%s.%s.%s",SigV4Builder.getURIPrefix(), getSubdomain(), awsRegionString, getEndpointURL());
		}
		
		if (SigV4Builder.getPath() != null && !SigV4Builder.getPath().equals("/") && !SigV4Builder.getPath().isBlank()) {
			url += SigV4Builder.getPath();
		}
		if (canonicalQueryString != null && !canonicalQueryString.isBlank()) {
			url += ("?" + canonicalQueryString);
		}
		
		return url;
	}
	
	private SigV4Headers getMxSigV4Headers(String authorizationHeader, String amzDate, String canonicalQueryString, String awsRegionString) {
		SigV4Headers sigV4SignedHeaders = new SigV4Headers(getContext());
		
		sigV4SignedHeaders.setEndpointUrl(getUrl(canonicalQueryString, awsRegionString));
		sigV4SignedHeaders.setHeader_Authorization(authorizationHeader);
		sigV4SignedHeaders.setHeader_X_Amz_Date(amzDate);
		sigV4SignedHeaders.setHeader_Host(getHost(awsRegionString));
		sigV4SignedHeaders.setHeader_X_Amz_Content_Sha256(getPayloadHash());
		
		return sigV4SignedHeaders;
	}

	private String getSecurityToken() {
		switch (Credentials.getMendixObject().getType()){
		// Check if session credentials are used to retrieve session token. 
		case TemporaryCredentials.entityName: {
			TemporaryCredentials temporaryCreds = (TemporaryCredentials)Credentials;
			if (temporaryCreds.getToken() == null) {
				throw new MendixRuntimeException("Session Credentials do not contain a Session Token");
			}
			return temporaryCreds.getToken();
		}
		// If static credentials are used, nothing is returned. 
		default:
			return null;
		}
	}

	private String getCanonicalizedQueryString() {
		Map<String, String> parameters = getQueryParameters();
		if ( parameters == null || parameters.isEmpty() ) {
			return "";
		}
		SortedMap<String, String> sorted = new TreeMap<String, String>();
		Iterator<Map.Entry<String, String>> pairs = parameters.entrySet().iterator();
		while (pairs.hasNext()) {
			Map.Entry<String, String> pair = pairs.next();
			String key = pair.getKey();
			String value = pair.getValue();
			sorted.put(urlEncode(key, false), urlEncode(value, false));
		}
		StringBuilder builder = new StringBuilder();
		pairs = sorted.entrySet().iterator();
		while (pairs.hasNext()) {
			Map.Entry<String, String> pair = pairs.next();
			builder.append(pair.getKey());
			builder.append("=");
			builder.append(pair.getValue());
			if (pairs.hasNext()) {
				builder.append("&");
			}
		}
		return builder.toString();
	}

	private String getCanonicalizeHeaderNames(Map<String, String> headers) {
		List<String> sortedHeaders = new ArrayList<String>();
		sortedHeaders.addAll(headers.keySet());
		Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);
		StringBuilder buffer = new StringBuilder();
		for (String header : sortedHeaders) {
			if (buffer.length() > 0) buffer.append(";");
			buffer.append(header.toLowerCase());
		}
		return buffer.toString();
	}

	private static String getCanonicalizedHeaderString(Map<String, String> headers) {
		if ( headers == null || headers.isEmpty() ) {
			return "";
		}
		List<String> sortedHeaders = new ArrayList<String>();
		sortedHeaders.addAll(headers.keySet());
		Collections.sort(sortedHeaders, String.CASE_INSENSITIVE_ORDER);
		StringBuilder buffer = new StringBuilder();
		for (String key : sortedHeaders) {
			buffer.append(key.toLowerCase().replaceAll("\\s+", " ") + ":" + headers.get(key).replaceAll("\\s+", " "));
			buffer.append("\n");
		}
		
		LOGGER.trace("The cannonical headers are "+ buffer.toString());
		return buffer.toString();
	}

	private static byte[] hash(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance(SHA256);
			md.update(text.getBytes(UTF8));
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException("Unable to compute hash while signing request: " + e.getMessage(), e);
		}
	}

	private static byte[] sign(String stringData, byte[] key, String algorithm) {
		try {
			byte[] data = stringData.getBytes(UTF8);
			Mac mac = Mac.getInstance(algorithm);
			mac.init(new SecretKeySpec(key, algorithm));
			return mac.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException("Unable to calculate a request signature: " + e.getMessage(), e);
		}
	}

	private static String getSignature(String scheme,
			String awsSecretKey,
			String dateStamp,
			String region,
			String service,
			String stringToSign) {
		byte[] kSecret = (scheme + awsSecretKey).getBytes();
		byte[] kDate = sign(dateStamp, kSecret, HMAC_SHA256);
		byte[] kRegion = sign(region, kDate, HMAC_SHA256);
		byte[] kService = sign(service, kRegion, HMAC_SHA256);
		byte[] kSigning = sign(TERMINATOR, kService, HMAC_SHA256);
		byte[] signature = sign(stringToSign, kSigning, HMAC_SHA256);
		return toHex(signature);
	}

	private static String toHex(byte[] data) {
		StringBuilder sb = new StringBuilder(data.length * 2);
		for (int i = 0; i < data.length; i++) {
			String hex = Integer.toHexString(data[i]);
			if (hex.length() == 1) {
				sb.append("0");
			} else if (hex.length() == 8) {
				hex = hex.substring(6);
			}
			sb.append(hex);
		}
		return sb.toString().toLowerCase(Locale.getDefault());
	}

	private static String urlEncode(String url, boolean keepPathSlash) {
		String encoded;
		try {
			encoded = URLEncoder.encode(url, UTF8).replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 encoding is not supported.", e);
		}
		if ( keepPathSlash ) {
			encoded = encoded.replace("%2F", "/");
		}
		return encoded;
	}
	// END EXTRA CODE
}
