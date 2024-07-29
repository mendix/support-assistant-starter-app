// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package amazonbedrockconnector.actions;

import static java.util.Objects.requireNonNull;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import amazonbedrockconnector.impl.AmazonBedrockClient;
import amazonbedrockconnector.impl.MxLogger;
import amazonbedrockconnector.proxies.InvokeModelResponse;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;

public class InvokeModel extends CustomJavaAction<IMendixObject>
{
	/** @deprecated use Credentials.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Credentials;
	private final awsauthentication.proxies.Credentials Credentials;
	private final awsauthentication.proxies.ENUM_Region Region;
	/** @deprecated use InvokeModelRequest.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __InvokeModelRequest;
	private final amazonbedrockconnector.proxies.InvokeModelRequest InvokeModelRequest;

	public InvokeModel(
		IContext context,
		IMendixObject _credentials,
		java.lang.String _region,
		IMendixObject _invokeModelRequest
	)
	{
		super(context);
		this.__Credentials = _credentials;
		this.Credentials = _credentials == null ? null : awsauthentication.proxies.Credentials.initialize(getContext(), _credentials);
		this.Region = _region == null ? null : awsauthentication.proxies.ENUM_Region.valueOf(_region);
		this.__InvokeModelRequest = _invokeModelRequest;
		this.InvokeModelRequest = _invokeModelRequest == null ? null : amazonbedrockconnector.proxies.InvokeModelRequest.initialize(getContext(), _invokeModelRequest);
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			// Validating JA input parameters
			requireNonNull(Credentials, "AWS Credentials are required");
			requireNonNull(InvokeModelRequest, "InvokeModelGenericRequest is required");
			requireNonNull(Region, "AWS Region is required");
			
			validateRequest();
			
			BedrockRuntimeClient client = AmazonBedrockClient.getBedrockRuntimeClient(Credentials, Region, InvokeModelRequest);
			
			software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest awsRequest = getAwsRequest();
			LOGGER.info("AWS request: " + awsRequest);
			
			software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse awsResponse = client.invokeModel(awsRequest);
			LOGGER.info("AWS response: " + awsResponse);
			
			InvokeModelResponse mxResponse = getMxResponse(awsResponse);
			
			return mxResponse.getMendixObject();
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
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
		return "InvokeModel";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(InvokeModel.class);
	
	private void validateRequest() {
		if (InvokeModelRequest.getModelID() == null|| InvokeModelRequest.getModelID().isBlank()) {
			throw new IllegalArgumentException("ModelId is required. Please provide the model id of the model you want to invoke.");
		}
		
		if (InvokeModelRequest.getRequestBody() == null || InvokeModelRequest.getRequestBody().isBlank()) {
			throw new IllegalArgumentException("RequestBody is required. Please provide a valid request body of the model you want to invoke.");
		}
	}
	
	private software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest getAwsRequest() {
		return software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest.builder()
		.body(software.amazon.awssdk.core.SdkBytes.fromUtf8String(InvokeModelRequest.getRequestBody()))
		.modelId(InvokeModelRequest.getModelID())
		.build();
	}
	
	private InvokeModelResponse getMxResponse(software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse awsResponse) {
		var mxResponse = new InvokeModelResponse(getContext());
		
		mxResponse.setResponseBody(awsResponse.body().asUtf8String());
		
		return mxResponse;
	}
	
	// END EXTRA CODE
}
