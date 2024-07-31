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
import java.util.List;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import amazonbedrockconnector.genaicommons_impl.ReferenceImpl;
import amazonbedrockconnector.impl.AmazonBedrockClient;
import amazonbedrockconnector.impl.MxLogger;
import amazonbedrockconnector.proxies.KnowledgeBaseTool;
import genaicommons.proxies.Message;
import genaicommons.proxies.Reference;
import genaicommons.proxies.Request;
import genaicommons.proxies.Tool;
import genaicommons.proxies.ToolCollection;
import software.amazon.awssdk.services.bedrockagentruntime.model.KnowledgeBaseRetrieveAndGenerateConfiguration;
import software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateConfiguration;
import software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateInput;
import software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateResponse;
import software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateSessionConfiguration;
import software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateType;

public class RetrieveAndGenerate extends CustomJavaAction<IMendixObject>
{
	/** @deprecated use Credentials.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Credentials;
	private final awsauthentication.proxies.Credentials Credentials;
	/** @deprecated use RetrieveAndGenerateRequest.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __RetrieveAndGenerateRequest;
	private final amazonbedrockconnector.proxies.RetrieveAndGenerateRequest_Extension RetrieveAndGenerateRequest;
	/** @deprecated use AmazonBedrockConnection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __AmazonBedrockConnection;
	private final amazonbedrockconnector.proxies.AmazonBedrockConnection AmazonBedrockConnection;

	public RetrieveAndGenerate(
		IContext context,
		IMendixObject _credentials,
		IMendixObject _retrieveAndGenerateRequest,
		IMendixObject _amazonBedrockConnection
	)
	{
		super(context);
		this.__Credentials = _credentials;
		this.Credentials = _credentials == null ? null : awsauthentication.proxies.Credentials.initialize(getContext(), _credentials);
		this.__RetrieveAndGenerateRequest = _retrieveAndGenerateRequest;
		this.RetrieveAndGenerateRequest = _retrieveAndGenerateRequest == null ? null : amazonbedrockconnector.proxies.RetrieveAndGenerateRequest_Extension.initialize(getContext(), _retrieveAndGenerateRequest);
		this.__AmazonBedrockConnection = _amazonBedrockConnection;
		this.AmazonBedrockConnection = _amazonBedrockConnection == null ? null : amazonbedrockconnector.proxies.AmazonBedrockConnection.initialize(getContext(), _amazonBedrockConnection);
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			requireNonNull(Credentials, "AWS Credentials are required");
			requireNonNull(RetrieveAndGenerateRequest, "RetrieveAndGenerateRequest_Extension object is required");
			requireNonNull(AmazonBedrockConnection, "AmazonBedrockConnection is required");
			
			validateRequest();
			
			var client = AmazonBedrockClient.getBedrockAgentRuntimeClient(Credentials, AmazonBedrockConnection.getRegion(), RetrieveAndGenerateRequest);
			
			software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateRequest awsRequest = getAwsRequest();
			LOGGER.info("AWS request: " + awsRequest);
			
			RetrieveAndGenerateResponse awsResponse = client.retrieveAndGenerate(awsRequest);
			LOGGER.info("AWS response: " + awsResponse);
			
			amazonbedrockconnector.proxies.RetrieveAndGenerateResponse mxResponse = getMxResponse(awsResponse);
			
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
		return "RetrieveAndGenerate";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(RetrieveAndGenerate.class);
	
	private String getInputText(Request commonRequest) throws CoreException {
		List<Message> messages = commonRequest.getRequest_Message();
		
		if (messages.size() == 0) {
			throw new IllegalArgumentException("The request does not contain a Message object. It must contain exactly one Message object with the Content attribute set.");
		}
		
		if (messages.size() > 1) {
			throw new IllegalArgumentException("The request contains more than one Message object. This is not supported for this operation. Exactly one Message object is expected");
		}
		return commonRequest.getRequest_Message().get(0).getContent();
	}
	
	private String getKnowledgeBaseId(Request commonRequest) throws CoreException {
		ToolCollection toolCollection = commonRequest.getRequest_ToolCollection();
		if (toolCollection == null) {
			throw new IllegalArgumentException("The Request does not contain a ToolCollection object. A ToolCollection object pointing to a KnowledgeBaseTool object is required");
		}
		
		List<Tool> tools = toolCollection.getToolCollection_Tool();
		if (tools.size() == 0) {
			throw new IllegalArgumentException("The Request does not contain any Tool objects. Exactly one KnowledgeBaseTool object is required");
		}
		
		if (tools.size() > 1) {
			throw new IllegalArgumentException("The Request contains more than one Tool object. Exactly one KnowledgeBaseTool object is required");
		}
		Tool tool = tools.get(0);
		if (!(tool instanceof KnowledgeBaseTool)) {
			throw new IllegalArgumentException("The provided Tool is not a KnowledgeBaseTool object. Exactly one KnowledgeBaseTool object is required");
		}
		KnowledgeBaseTool kbTool = (KnowledgeBaseTool) tool;
		
		return kbTool.getKnowledgeBaseId();
	}
	
	private void validateRequest() throws Exception {
		
		Request commonRequest = RetrieveAndGenerateRequest.getRetrieveAndGenerateRequest_Extension_Request();
		if (commonRequest == null) {
			throw new IllegalArgumentException("No GenAICommons.Request entity found. A GenAICommons.Request entity is required.");
		}
		
		String inputText = getInputText(commonRequest);
		if (inputText == null || inputText.isBlank()) {
			throw new IllegalArgumentException("The Content attribute of the Message entity is required.");
		}
		
		String knowledgeBaseId = getKnowledgeBaseId(commonRequest);
		if (knowledgeBaseId == null || knowledgeBaseId.isBlank()) {
			throw new IllegalArgumentException("The KnowledgeBaseId attribute of the KnowledgeBaseTool object is required.");
		}
		
		if (RetrieveAndGenerateRequest.getRetrieveAndGenerateType() == null) {
			throw new IllegalArgumentException("The RetrieveAndGenerateType attribute of the RetrieveAndGenerateRequest_Extension object is required.");
		}
		
		if (AmazonBedrockConnection.getModel() == null || AmazonBedrockConnection.getModel().isBlank()) {
			throw new IllegalArgumentException("The Model attribute of the AmazonBedrockConnection is required.");
		}
		
		if (AmazonBedrockConnection.getRegion()== null) {
			throw new IllegalArgumentException("The Region attribute of the AmazonBedrockConnection is required.");
		}
		
	}
	
	private software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateRequest getAwsRequest() throws Exception {
		Request commonRequest = RetrieveAndGenerateRequest.getRetrieveAndGenerateRequest_Extension_Request();
		var awsRequestBuilder = software.amazon.awssdk.services.bedrockagentruntime.model.RetrieveAndGenerateRequest.builder();
		
		awsRequestBuilder
			.input(getInput(commonRequest))
			.retrieveAndGenerateConfiguration(getRetrieveAndGenerateConfiguration(commonRequest));
		
		String sessionId = RetrieveAndGenerateRequest.getSessionId();
		if (sessionId != null && !sessionId.isBlank()) {
			awsRequestBuilder.sessionId(sessionId);
		}
		
		String kmsKeyARN = RetrieveAndGenerateRequest.getKmsKeyARN();
		if (kmsKeyARN != null && !kmsKeyARN.isBlank()) {
			awsRequestBuilder.sessionConfiguration(getSessionConfiguration());
		}
		
		return awsRequestBuilder.build();
	}
	
	private RetrieveAndGenerateInput getInput(Request commonRequest) throws CoreException {
		var builder = RetrieveAndGenerateInput.builder();
		builder.text(getInputText(commonRequest));
		
		return builder.build();
	}
	
	private RetrieveAndGenerateSessionConfiguration getSessionConfiguration() throws Exception {
		var builder = RetrieveAndGenerateSessionConfiguration.builder();
		builder.kmsKeyArn(RetrieveAndGenerateRequest.getKmsKeyARN());
		
		return builder.build();
	}
	
	private RetrieveAndGenerateConfiguration getRetrieveAndGenerateConfiguration(Request commonRequest) throws Exception {
		var builder = RetrieveAndGenerateConfiguration.builder();
		
		builder.type(RetrieveAndGenerateType.valueOf(RetrieveAndGenerateRequest.getRetrieveAndGenerateType().toString()))
			.knowledgeBaseConfiguration(getKnowledgeBaseRetrieveAndGenerateConfiguration(commonRequest));
		
		return builder.build();				
	}
	
	private KnowledgeBaseRetrieveAndGenerateConfiguration getKnowledgeBaseRetrieveAndGenerateConfiguration(Request commonRequest) throws Exception {
		var builder = KnowledgeBaseRetrieveAndGenerateConfiguration.builder();
		
		builder.knowledgeBaseId(getKnowledgeBaseId(commonRequest))
			.modelArn(AmazonBedrockConnection.getModel());
		
		return builder.build();
	}
	
	private amazonbedrockconnector.proxies.RetrieveAndGenerateResponse getMxResponse(RetrieveAndGenerateResponse awsResponse) {
		amazonbedrockconnector.proxies.RetrieveAndGenerateResponse mxResponse = new amazonbedrockconnector.proxies.RetrieveAndGenerateResponse(getContext());
		
		mxResponse.setSessionId(awsResponse.sessionId());
		
		Message responseMsg = new Message(getContext());
		responseMsg.setContent(awsResponse.output().text());
		
		List<Reference> mxReferences = ReferenceImpl.getMxReferences(awsResponse.citations(), getContext());
		responseMsg.setMessage_Reference(mxReferences);
		
		mxResponse.setResponse_Message(responseMsg);
		return mxResponse;
	}
	
	
	
	
	// END EXTRA CODE
}
