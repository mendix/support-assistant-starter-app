// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package amazonbedrockconnector.actions;

import static amazonbedrockconnector.impl.MxLogger.getStackTrace;
import static java.util.Objects.requireNonNull;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IDataType;
import com.mendix.systemwideinterfaces.core.IDataType.DataTypeEnum;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import amazonbedrockconnector.impl.AmazonBedrockClient;
import amazonbedrockconnector.impl.MxCitation;
import amazonbedrockconnector.impl.MxRetrievedReference;
import amazonbedrockconnector.proxies.AbstractTrace;
import amazonbedrockconnector.proxies.ActionGroupInvocationInput;
import amazonbedrockconnector.proxies.ENUM_CreationMode;
import amazonbedrockconnector.proxies.ENUM_InvocationType;
import amazonbedrockconnector.proxies.ENUM_ObservationType;
import amazonbedrockconnector.proxies.ENUM_PromptType;
import amazonbedrockconnector.proxies.ENUM_RepromptSource;
import amazonbedrockconnector.proxies.ENUM_TraceType;
import amazonbedrockconnector.proxies.InvocationInput;
import amazonbedrockconnector.proxies.InvocationInputParameter;
import amazonbedrockconnector.proxies.InvokeAgentCitation;
import amazonbedrockconnector.proxies.InvokeAgentResponse;
import amazonbedrockconnector.proxies.KnowledgeBaseLookupInput;
import amazonbedrockconnector.proxies.Observation;
import amazonbedrockconnector.proxies.ObservationRetrievedReference;
import amazonbedrockconnector.proxies.OrchestrationModelInvocationInput;
import amazonbedrockconnector.proxies.Parameter;
import amazonbedrockconnector.proxies.PostProcessingModelInvocationInput;
import amazonbedrockconnector.proxies.PostProcessingModelInvocationOutput;
import amazonbedrockconnector.proxies.PreProcessingModelInvocationInput;
import amazonbedrockconnector.proxies.PreProcessingModelInvocationOutput;
import amazonbedrockconnector.proxies.PromptSessionAttribute;
import amazonbedrockconnector.proxies.Rationale;
import amazonbedrockconnector.proxies.RepromptResponse;
import amazonbedrockconnector.proxies.RequestBodyContent;
import amazonbedrockconnector.proxies.RequestBodyContentParameter;
import amazonbedrockconnector.proxies.SessionAttribute;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.core.async.SdkPublisher;
import software.amazon.awssdk.services.bedrockagentruntime.BedrockAgentRuntimeAsyncClient;
import software.amazon.awssdk.services.bedrockagentruntime.model.Citation;
import software.amazon.awssdk.services.bedrockagentruntime.model.CreationMode;
import software.amazon.awssdk.services.bedrockagentruntime.model.FailureTrace;
import software.amazon.awssdk.services.bedrockagentruntime.model.InvokeAgentResponseHandler;
import software.amazon.awssdk.services.bedrockagentruntime.model.ModelInvocationInput;
import software.amazon.awssdk.services.bedrockagentruntime.model.PayloadPart;
import software.amazon.awssdk.services.bedrockagentruntime.model.ResponseStream;
import software.amazon.awssdk.services.bedrockagentruntime.model.SessionState;
import software.amazon.awssdk.services.bedrockagentruntime.model.Trace;
import software.amazon.awssdk.services.bedrockagentruntime.model.TracePart;

/**
 * The Amazon Bedrock InvokeAgent action allows you to send a prompt for an agent to process and respond to.
 * 
 * The following parameters are required:
 * - ENUM_Region (Enumeration)
 * - InvokeAgentRequest (Object)
 * - Credentials (Object)
 * 
 * - ResponseHandlerMicroflow (Microflow)
 * Allowed Format: 1 Parameter of type: InvokeAgentResponse
 * 
 * -ErrorHandlerMicroflow (Microflow)
 * Allowed Format: 1 Parameter of type: String (will hold the error description)
 * 
 * This action doesn't have a return value. 
 * This operation runs asynchronously and will end immediately after the request was sent. 
 * Once a response was returned the ResponseHandlerMicroflow will be called and should be used to further process the InvokeAgentResponse.
 * If an error occurs in asynchronous process the ErrorHandlerMicroflow will be called and should be used to implement custom error handling. 
 * 
 * See also: https://docs.aws.amazon.com/bedrock/latest/APIReference/API_agent-runtime_InvokeAgent.html
 */
public class InvokeAgent extends CustomJavaAction<java.lang.Void>
{
	/** @deprecated use InvokeAgentRequest.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __InvokeAgentRequest;
	private final amazonbedrockconnector.proxies.InvokeAgentRequest InvokeAgentRequest;
	private final awsauthentication.proxies.ENUM_Region ENUM_Region;
	/** @deprecated use Credentials.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Credentials;
	private final awsauthentication.proxies.Credentials Credentials;
	private final java.lang.String ResponseHandlerMicroflow;
	private final java.lang.String ErrorHandlerMicroflow;

	public InvokeAgent(
		IContext context,
		IMendixObject _invokeAgentRequest,
		java.lang.String _eNUM_Region,
		IMendixObject _credentials,
		java.lang.String _responseHandlerMicroflow,
		java.lang.String _errorHandlerMicroflow
	)
	{
		super(context);
		this.__InvokeAgentRequest = _invokeAgentRequest;
		this.InvokeAgentRequest = _invokeAgentRequest == null ? null : amazonbedrockconnector.proxies.InvokeAgentRequest.initialize(getContext(), _invokeAgentRequest);
		this.ENUM_Region = _eNUM_Region == null ? null : awsauthentication.proxies.ENUM_Region.valueOf(_eNUM_Region);
		this.__Credentials = _credentials;
		this.Credentials = _credentials == null ? null : awsauthentication.proxies.Credentials.initialize(getContext(), _credentials);
		this.ResponseHandlerMicroflow = _responseHandlerMicroflow;
		this.ErrorHandlerMicroflow = _errorHandlerMicroflow;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			requireNonNull(InvokeAgentRequest, "InvokeAgentRequest is required.");
			requireNonNull(ENUM_Region, "AWS Region is required.");
			requireNonNull(Credentials, "AWS Credentials are required.");
			requireNonNull(ResponseHandlerMicroflow, "ResponseHandlerMicroflow is required.");
			requireNonNull(ErrorHandlerMicroflow, "ErrorHandlerMicroflow is required");

			validateRequest();
			
			BedrockAgentRuntimeAsyncClient client = AmazonBedrockClient.getBedrockAgentRuntimeAsyncClient(Credentials, ENUM_Region, InvokeAgentRequest);
			
			software.amazon.awssdk.services.bedrockagentruntime.model.InvokeAgentRequest awsRequest = createAwsRequest();
			LOGGER.debug("AWS Request:", awsRequest);
			
			InvokeAgentResponseHandler handler = new MyInvokeAgentResponseHandler(getContext(), InvokeAgentRequest, 
					ResponseHandlerMicroflow, getParameterName(ResponseHandlerMicroflow), 
					ErrorHandlerMicroflow, getParameterName(ErrorHandlerMicroflow));
			
			LOGGER.debug("Creating future");
			CompletableFuture<Void> future = client.invokeAgent(awsRequest, handler);
			
			future.thenRun(() -> {
				LOGGER.debug("Operation completed succesfully.");
				})
			      .exceptionally(e -> {
			          LOGGER.debug("Future completed exceptionally: ",e.getMessage());
			          return null;
			      });

			return null;
			
		} catch (Exception e) {
			LOGGER.error("Exception occurred: ", e.getMessage());
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
		return "InvokeAgent";
	}

	// BEGIN EXTRA CODE
	private static final amazonbedrockconnector.impl.MxLogger LOGGER = new amazonbedrockconnector.impl.MxLogger(InvokeAgent.class);
	private static final String INVOKE_AGENT_RESPONSE_NAME = InvokeAgentResponse.getType();
	
	private void validateRequest() throws Exception {
		
		// Validation of InvokeAgentRequest attributes
		if (InvokeAgentRequest.getAgentAliasId() == null || InvokeAgentRequest.getAgentAliasId().isBlank()) {
			throw new IllegalArgumentException("The AgentAliasId cannot be empty.");
		}
		
		if (InvokeAgentRequest.getAgentId() == null || InvokeAgentRequest.getAgentId().isBlank()) {
			throw new IllegalArgumentException("The AgentId cannot be empty.");
		}
		
		// Validate that the agent exists
		software.amazon.awssdk.services.bedrockagent.model.GetAgentRequest awsRequest = software.amazon.awssdk.services.bedrockagent.model.GetAgentRequest.builder()
				.agentId(this.InvokeAgentRequest.getAgentId())
				.build();
		software.amazon.awssdk.services.bedrockagent.BedrockAgentClient client = AmazonBedrockClient.getBedrockAgentClient(Credentials, ENUM_Region, InvokeAgentRequest);
		client.getAgent(awsRequest);
		
		if (InvokeAgentRequest.getSessionId() == null || InvokeAgentRequest.getSessionId().isBlank()) {
			throw new IllegalArgumentException("The SessionId cannot be empty.");
		}
		
		if (InvokeAgentRequest.getInputText() == null || InvokeAgentRequest.getInputText().isBlank()) {
			throw new IllegalArgumentException("The InputText cannot be empty");
		}
		
		//If present, validate SessionState object for empty keys/values of (Prompt)SessionAttributes
		amazonbedrockconnector.proxies.SessionState mxSessionState = InvokeAgentRequest.getSessionState_InvokeAgentRequest();
		if (mxSessionState != null) {
			var mxSessionAttributes = getMxSessionAttributes(mxSessionState);
			var mxPromptSessionAttributes = getMxPromptSessionAttributes(mxSessionState);
			
			if ((mxSessionAttributes == null || mxSessionAttributes.isEmpty()) && (mxPromptSessionAttributes == null || mxPromptSessionAttributes.isEmpty())) {
				throw new IllegalArgumentException("If a SessionState object is part of the request, at least one SessionAttribute or PromptSessionAttribute object must be included");
			}
			
			if (mxSessionAttributes != null && !mxSessionAttributes.isEmpty()) {
				List<SessionAttribute> blankAttributes =  mxSessionAttributes.stream()
						.filter(mxAttr -> mxAttr.getKey() == null || mxAttr.getKey().isBlank() || mxAttr.getValue() == null || mxAttr.getValue().isBlank())
						.collect(Collectors.toList());
				if (blankAttributes != null && !blankAttributes.isEmpty()) {
					throw new IllegalArgumentException("The Key and Value attributes of SessionAttribute objects are required.");
				}
			}
			
			if (mxPromptSessionAttributes != null && !mxPromptSessionAttributes.isEmpty()) {
				List<PromptSessionAttribute> blankAttributes =  mxPromptSessionAttributes.stream()
						.filter(mxAttr -> mxAttr.getKey() == null || mxAttr.getKey().isBlank() || mxAttr.getValue() == null || mxAttr.getValue().isBlank())
						.collect(Collectors.toList());
				if (blankAttributes != null && !blankAttributes.isEmpty()) {
					throw new IllegalArgumentException("The Key and Value attributes of PromptSessionAttribute objects are required.");
				}
			}
		}
		
		// Validation of the ResponseHandlerMicroflow: Must have InvokeAgentResponse as parameter.
		Map<String, IDataType> responseParams = Core.getInputParameters(ResponseHandlerMicroflow);
		if (responseParams.size() != 1) {
			throw new IllegalArgumentException("The Microflow passed for response handling must have exactly one parameter of type " + INVOKE_AGENT_RESPONSE_NAME);
		}
		
		IDataType responseParamType = responseParams.values().iterator().next();
		if (responseParamType.getType() != DataTypeEnum.Object || !responseParamType.getObjectType().equals(INVOKE_AGENT_RESPONSE_NAME)) {
			throw new IllegalArgumentException("The Microflow passed for response handling must have exactly one parameter of type " + INVOKE_AGENT_RESPONSE_NAME);
		}
		
		// Validation of the ErrorHandlerMicroflow: Must have a String parameter
		Map<String, IDataType> errorParams = Core.getInputParameters(ErrorHandlerMicroflow);
		if (errorParams.size() != 1) {
			throw new IllegalArgumentException("The Microflow passed for error handling must have exactly one parameter of type String");
		}
		
		IDataType errorParamType = errorParams.values().iterator().next();
		if (errorParamType.getType() != DataTypeEnum.String) {
			throw new IllegalArgumentException("The Microflow passed for error handling must have exactly one parameter of type String");
		}
		
	}
	
	private String getParameterName(String microflowName) {
		return Core.getInputParameters(microflowName).keySet().iterator().next();
	}
	
	private software.amazon.awssdk.services.bedrockagentruntime.model.InvokeAgentRequest createAwsRequest() throws Exception {
		
		var builder = software.amazon.awssdk.services.bedrockagentruntime.model.InvokeAgentRequest.builder();
		
		builder
			.agentAliasId(InvokeAgentRequest.getAgentAliasId())
			.agentId(InvokeAgentRequest.getAgentId())
			.sessionId(InvokeAgentRequest.getSessionId())
			.inputText(InvokeAgentRequest.getInputText())
			.enableTrace(InvokeAgentRequest.getEnableTrace())
			.endSession(InvokeAgentRequest.getEndSession());
		
		if (InvokeAgentRequest.getSessionState_InvokeAgentRequest() != null) {
			builder.sessionState(createAwsSessionState());
		}
		
		return builder.build();
		
	}
	
	private SessionState createAwsSessionState() throws Exception {
		
		var mxSessionState = InvokeAgentRequest.getSessionState_InvokeAgentRequest();
		
		var mxSessionAttributes = getMxSessionAttributes(mxSessionState);
		var mxPromptSessionAttributes = getMxPromptSessionAttributes(mxSessionState);
		
		var builder = SessionState.builder();
		
		if (mxSessionAttributes != null && !mxSessionAttributes.isEmpty()) {
			builder.sessionAttributes(createAwsSessionAttributes(mxSessionAttributes));
		}
		
		if (mxPromptSessionAttributes != null && !mxPromptSessionAttributes.isEmpty()) {
			builder.promptSessionAttributes(createAwsPromptSessionAttributes(mxPromptSessionAttributes));
		}
		
		return builder.build();
		
	}
	
	private List<SessionAttribute> getMxSessionAttributes(amazonbedrockconnector.proxies.SessionState mxSessionState) {
		return Core.retrieveByPath(getContext(), mxSessionState.getMendixObject(), SessionAttribute.MemberNames.SessionAttribute_SessionState.toString()).stream()
				.map(mxObj -> SessionAttribute.initialize(getContext(), mxObj))
				.collect(Collectors.toList());
	}
	
	private List<PromptSessionAttribute> getMxPromptSessionAttributes(amazonbedrockconnector.proxies.SessionState mxSessionState) {
		return Core.retrieveByPath(getContext(), mxSessionState.getMendixObject(), PromptSessionAttribute.MemberNames.PromptSessionAttribute_SessionState.toString()).stream()
				.map(mxObj -> PromptSessionAttribute.initialize(getContext(), mxObj))
				.collect(Collectors.toList());
	}
	
	private static Map<String, String> createAwsSessionAttributes(List<SessionAttribute> mxSessionAttributes) {
		Map<String, String> awsSessionAttributes = new HashMap<>();
		
		mxSessionAttributes.stream()
			.forEach(mxSessionAttribute -> awsSessionAttributes.put(mxSessionAttribute.getKey(), mxSessionAttribute.getValue()));
		
		return awsSessionAttributes;	
	}
	
	private static Map<String, String> createAwsPromptSessionAttributes(List<PromptSessionAttribute> mxPromptSessionAttributes) {
		Map<String, String> awsPromptSessionAttributes = new HashMap<>();
		
		mxPromptSessionAttributes.stream()
			.forEach(mxPromptSessionAttribute -> awsPromptSessionAttributes.put(mxPromptSessionAttribute.getKey(), mxPromptSessionAttribute.getValue()));
		
		return awsPromptSessionAttributes;
	}
	
	// Concrete InvokeAgentResponseHandler class
		private static class MyInvokeAgentResponseHandler implements InvokeAgentResponseHandler{
			
			private IContext context;
	        private ResponseStreamVisitor visitor;
	      
	        // Name of the ResponseHandler Microflow
	        private String responseMicroflowName;
	        
	        // Name of the InvokeAgentResponse parameter of the ResponseHandlerMicroflow
	        private String responseParameterName;
	        
	        // Name of the ErrorHandlerMicroflow
	        private String errorMicroflowName;
	        
	        // Name of the String parameter of the ErrorHandlerMicroflow
	        private String errorParameterName;
					
			public MyInvokeAgentResponseHandler(IContext context, amazonbedrockconnector.proxies.InvokeAgentRequest mxRequest, String responseMicroflowName, String responseParameterName, String errorMicroflowName, String errorParameterName){
				this.context = context;
				this.responseMicroflowName = responseMicroflowName;
				this.responseParameterName = responseParameterName;
				this.errorMicroflowName = errorMicroflowName;
				this.errorParameterName = errorParameterName;
				visitor = new ResponseStreamVisitor(context, this);
				LOGGER.debug("Creating handler");
			}
			
		    @Override
		    public void complete() {
		    	try {
		    		LOGGER.debug("Asynchronous operation completed!");
			        LOGGER.debug("Response is:" + visitor.getResponse());
			        
			        // Call ResponseHandlerMicroflow provided by Mendix Maker
			        Core.microflowCall(responseMicroflowName)
			        	.inTransaction(true)
			        	.withParam(responseParameterName, visitor.getResponse().getMendixObject())
			        	.execute(context);
				} catch (Exception e) {
					LOGGER.error("Exception ocurred in ResponseHandler complete() method: ", e.getMessage());
					throw e;
				}
		        
		    }

			@Override
			public void exceptionOccurred(Throwable t) {
				try {
					LOGGER.debug("Exception occurred: ", t.toString());
					LOGGER.debug("Stacktrace:", getStackTrace(t));
					
					// Call ErrorHandlerMicroflow provided by Mendix Maker
					Core.microflowCall(errorMicroflowName)
						.inTransaction(true)
						.withParam(errorParameterName, t.toString())
						.execute(context);
					
				} catch (Exception e) {
					LOGGER.error("Exception ocurred in ResponseHandler exceptionOcurred() method: ", e.getMessage());
					throw e;
				}
				
			}

	        @Override
	        public void onEventStream(SdkPublisher<ResponseStream> responseStream) {
	        	try {
	        		LOGGER.debug("Event streamed: ", responseStream.toString());
		            responseStream.subscribe(event -> {
		                LOGGER.debug("Event received: ", event);
		                event.accept(visitor);
		            });
				} catch (Exception e) {
					LOGGER.error("Exception ocurred in ResponseHandler onEventStream() method", e.getMessage());
					throw e;
				}
	        }

			@Override
			public void responseReceived(software.amazon.awssdk.services.bedrockagentruntime.model.InvokeAgentResponse response) {
				LOGGER.debug("Response received: ",response.toString());
			}		

		};
		
		// Concrete Visitor class
		private static class ResponseStreamVisitor implements InvokeAgentResponseHandler.Visitor {
			
			private final IContext context;
			
			private final InvokeAgentResponse response;
			
			private final MyInvokeAgentResponseHandler handler;
							
		    public ResponseStreamVisitor(IContext context, MyInvokeAgentResponseHandler handler) {
		    	this.context = context;
		    	this.response  = new InvokeAgentResponse(context);
		    	this.response.setOutputText("");
		    	this.handler = handler;
		    }

	    	@Override
		    public void visitChunk(PayloadPart event) {
	    		try {
	    			 SdkBytes sdkBytes = event.bytes();
	 		        ByteBuffer byteBuffer = sdkBytes.asByteBuffer();

	 		        String payloadContent;
	 		        if (byteBuffer.hasArray()) {
	 		            payloadContent = new String(byteBuffer.array(), StandardCharsets.UTF_8);
	 		        } else {
	 		            byte[] bytes = new byte[byteBuffer.remaining()];
	 		            byteBuffer.get(bytes);
	 		            payloadContent = new String(bytes, StandardCharsets.UTF_8);
	 		        }

	 		        LOGGER.debug("Chunk event received with content: ", payloadContent);
	 		        response.setOutputText(response.getOutputText() + payloadContent);
	 		        
	 		        // Creating Citation objects
	 		        if (event.attribution() != null && event.attribution().hasCitations()) {
	 		        	event.attribution().citations().forEach(awsCitation -> {
	 			        	InvokeAgentCitation mxCitation = createMxCitation(awsCitation, context);
	 			        	mxCitation.setInvokeAgentCitation_InvokeAgentResponse(response);
	 			        });
	 				}
				} catch (Exception e) {
					LOGGER.error("Excepting ocurred while handling Chunk Event: ", e.getMessage());
					this.handler.exceptionOccurred(e);
					throw e;
				}
		       
		        
		    }

		    @Override
		    public void visitTrace(TracePart event) {
		    	try {
		    		LOGGER.debug("Trace event received: ", event.toString());
			        amazonbedrockconnector.proxies.TracePart mxTracePart = createMxTracePart(event, context);
			        mxTracePart.setTracePart_InvokeAgentResponse(response);
				} catch (Exception e) {
					LOGGER.error("Excepting ocurred while handling Trace Event: ", e.getMessage());
					this.handler.exceptionOccurred(e);
					throw e;
				}
		        
		    }

		    @Override
		    public void visitDefault(ResponseStream event) {
		        LOGGER.trace("Default event received." );
		    }
		    
		    public InvokeAgentResponse getResponse() {
		    	return response;
		    }
		}
		
		private static amazonbedrockconnector.proxies.TracePart createMxTracePart(TracePart awsTracePart, IContext context) {
			LOGGER.debug("Creating MX TracePart...");
			LOGGER.debug("AWS TracePart type:" , awsTracePart.trace().type());
			amazonbedrockconnector.proxies.TracePart mxTracePart = new amazonbedrockconnector.proxies.TracePart(context);
			mxTracePart.setAgentAliasId(awsTracePart.agentAliasId());
			mxTracePart.setAgentid(awsTracePart.agentId());
			mxTracePart.setSessionId(awsTracePart.sessionId());
			
			if (awsTracePart.trace() != null) {
				AbstractTrace mxTrace = createMxTrace(awsTracePart.trace(), context);
				LOGGER.debug("Created MxTrace: ", mxTrace);
				if (mxTrace != null) {
					mxTracePart.setAbstractTrace_TracePart(mxTrace);
				}
			}
			
			LOGGER.debug("Created MX TracePart: ", mxTracePart);
			return mxTracePart;
		}
		
		private static InvokeAgentCitation createMxCitation(Citation awsCitation, IContext context) {
			
			amazonbedrockconnector.proxies.InvokeAgentCitation mxCitation = new amazonbedrockconnector.proxies.InvokeAgentCitation(context);
			MxCitation.setMxCitations(awsCitation, mxCitation, context);
			return mxCitation;
		}
		
		private static AbstractTrace createMxTrace(Trace awsTrace, IContext context) {
			switch (awsTrace.type()) {
			case FAILURE_TRACE: {
				return awsTrace.failureTrace() != null ? createMxFailureTrace(awsTrace.failureTrace(), context) : null;
			}
			case PRE_PROCESSING_TRACE: {
				if (awsTrace.preProcessingTrace() != null) {
					switch (awsTrace.preProcessingTrace().type()) {		
					case MODEL_INVOCATION_INPUT: {
						return awsTrace.preProcessingTrace().modelInvocationInput() != null ? createMxPreProcessingModelInvocationInput(awsTrace.preProcessingTrace().modelInvocationInput(), context) : null;

					}
					case MODEL_INVOCATION_OUTPUT: {
						return awsTrace.preProcessingTrace().modelInvocationOutput() != null ? createMxPreProcessingModelInvocationOutput(awsTrace.preProcessingTrace().modelInvocationOutput(), context) : null;
					}
					default:
						LOGGER.debug("Unknown PreProcessingTrace.Type returned: ", awsTrace.preProcessingTrace().type());
						return null;
					}
				}
				return null;
			}
			case ORCHESTRATION_TRACE: {
				if (awsTrace.orchestrationTrace() != null) {
					switch (awsTrace.orchestrationTrace().type()) {
					case INVOCATION_INPUT: {
						return awsTrace.orchestrationTrace().invocationInput() != null ? createMxInvocationInput(awsTrace.orchestrationTrace().invocationInput(), context) : null;
					}
					case MODEL_INVOCATION_INPUT: {
						return awsTrace.orchestrationTrace().modelInvocationInput() != null ? createMxOrchestrationModelInvocationInput(awsTrace.orchestrationTrace().modelInvocationInput(), context) : null;
					}
					case RATIONALE: {
						return awsTrace.orchestrationTrace().rationale() != null ? createMxRationale(awsTrace.orchestrationTrace().rationale(), context) : null;
					}
					case OBSERVATION: {
						return awsTrace.orchestrationTrace().observation() != null ? createMxObservation(awsTrace.orchestrationTrace().observation(), context) : null;
					}
					default:
						LOGGER.debug("Unknown OrchestrationTrace.Type returned: ", awsTrace.orchestrationTrace().type());
						return null;
					}
				}
				return null;
			}
			case POST_PROCESSING_TRACE: {
				if (awsTrace.preProcessingTrace() != null) {
					switch (awsTrace.postProcessingTrace().type()) {
					case MODEL_INVOCATION_INPUT: {
						return awsTrace.postProcessingTrace().modelInvocationInput() != null ? createMxPostProcessingModelInvocationInput(awsTrace.postProcessingTrace().modelInvocationInput(), context) : null;
					}
					case MODEL_INVOCATION_OUTPUT: {
						return awsTrace.postProcessingTrace().modelInvocationOutput() != null ? createMxPostProcessingModelInvocationOutput(awsTrace.postProcessingTrace().modelInvocationOutput(), context) : null;
					}
					default:
						LOGGER.debug("Unknown PostProcessingTrace.Type returned: ", awsTrace.postProcessingTrace().type());
						return null;
					}
				}
				return null;
			}
			default:
				LOGGER.debug("Unknown Trace.Type returned: ", awsTrace.type());
				return null;
			}
		}
		
		// Reused across types for specializations of ModelInvocationInput
		private static void setMxModelInvocationInput(amazonbedrockconnector.proxies.ModelInvocationInput mxModelInvocationInput, ModelInvocationInput awsModelInvocationInput) {
			mxModelInvocationInput.setTraceId(awsModelInvocationInput.traceId());
			mxModelInvocationInput.setOverrideLambda(awsModelInvocationInput.overrideLambda());
			mxModelInvocationInput.setParserMode(setMxCreationMode(awsModelInvocationInput.parserMode()));
			mxModelInvocationInput.setPromptCreationMode(setMxCreationMode(awsModelInvocationInput.promptCreationMode()));
			mxModelInvocationInput.setText(awsModelInvocationInput.text());
			mxModelInvocationInput.setPromptType(ENUM_PromptType.valueOf(awsModelInvocationInput.type().toString()));
		}
		
		private static ENUM_CreationMode setMxCreationMode(CreationMode awsCreationMode) {
			if (awsCreationMode == null) {
				return null;
			}
			switch (awsCreationMode) {
			case DEFAULT: {
				return ENUM_CreationMode._DEFAULT;
			}
			case OVERRIDDEN: {
				return ENUM_CreationMode.OVERRIDDEN;
			}
			case UNKNOWN_TO_SDK_VERSION: {
				LOGGER.debug("UnknownToSDKVersion ENUM_CreationMode value returned");
				return ENUM_CreationMode.UNKNOWN_TO_SDK_VERSION;
			}
			default:
				return null;
			}
		}
		
		// Creating the FailureTrace type object
		private static amazonbedrockconnector.proxies.FailureTrace createMxFailureTrace(FailureTrace awsFailureTrace, IContext context) {	
			amazonbedrockconnector.proxies.FailureTrace mxFailureTrace = new amazonbedrockconnector.proxies.FailureTrace(context);
			mxFailureTrace.setTraceType(ENUM_TraceType.FAILURE_TRACE);
			mxFailureTrace.setFailureReason(awsFailureTrace.failureReason());
			mxFailureTrace.setTraceId(awsFailureTrace.traceId());
			return mxFailureTrace;
		}
		
		// Creating the PreProcessingTrace type objects
		private static PreProcessingModelInvocationInput createMxPreProcessingModelInvocationInput(ModelInvocationInput awsModelInvocationInput, IContext context) {
			PreProcessingModelInvocationInput mxPreProcessingModelInvocationInput = new PreProcessingModelInvocationInput(context);
			mxPreProcessingModelInvocationInput.setTraceType(ENUM_TraceType.PRE_PROCESSING_TRACE);
			setMxModelInvocationInput(mxPreProcessingModelInvocationInput, awsModelInvocationInput);
			return mxPreProcessingModelInvocationInput;
		}
		
		private static PreProcessingModelInvocationOutput createMxPreProcessingModelInvocationOutput(software.amazon.awssdk.services.bedrockagentruntime.model.PreProcessingModelInvocationOutput awsPreProcessingModelInvocationOutput, IContext context) {
			PreProcessingModelInvocationOutput mxPreProcessingModelInvocationOutput = new PreProcessingModelInvocationOutput(context);
			mxPreProcessingModelInvocationOutput.setTraceType(ENUM_TraceType.PRE_PROCESSING_TRACE);
			mxPreProcessingModelInvocationOutput.setTraceId(awsPreProcessingModelInvocationOutput.traceId());
			
			if (awsPreProcessingModelInvocationOutput.parsedResponse() != null) {
				mxPreProcessingModelInvocationOutput.setIsValid(awsPreProcessingModelInvocationOutput.parsedResponse().isValid());
				mxPreProcessingModelInvocationOutput.setRationale(awsPreProcessingModelInvocationOutput.parsedResponse().rationale());
			}
			
			return mxPreProcessingModelInvocationOutput;
		}
		
		// Creating the PostProcessingTrace type objects
		private static PostProcessingModelInvocationInput createMxPostProcessingModelInvocationInput(ModelInvocationInput awsModelInvocationInput, IContext context) {
			PostProcessingModelInvocationInput mxPostProcessingModelInvocationInput = new PostProcessingModelInvocationInput(context);
			mxPostProcessingModelInvocationInput.setTraceType(ENUM_TraceType.POST_PROCESSING_TRACE);
			setMxModelInvocationInput(mxPostProcessingModelInvocationInput, awsModelInvocationInput);
			return mxPostProcessingModelInvocationInput;
		}
		
		private static PostProcessingModelInvocationOutput createMxPostProcessingModelInvocationOutput(software.amazon.awssdk.services.bedrockagentruntime.model.PostProcessingModelInvocationOutput awsPostProcessingTraceModelInvocationOutput, IContext context) {
			PostProcessingModelInvocationOutput mxPostProcessingTraceModelInvocationOutput = new PostProcessingModelInvocationOutput(context);
			mxPostProcessingTraceModelInvocationOutput.setTraceType(ENUM_TraceType.POST_PROCESSING_TRACE);
			mxPostProcessingTraceModelInvocationOutput.setTraceId(awsPostProcessingTraceModelInvocationOutput.traceId());
			
			if (awsPostProcessingTraceModelInvocationOutput.parsedResponse() != null) {
				mxPostProcessingTraceModelInvocationOutput.setParsedResponse(awsPostProcessingTraceModelInvocationOutput.parsedResponse().text());
			}
			
			return mxPostProcessingTraceModelInvocationOutput;
		}
	
		// Creating the OrchestrationTrace type objects
		private static InvocationInput createMxInvocationInput(software.amazon.awssdk.services.bedrockagentruntime.model.InvocationInput awsInvocationInput, IContext context) {
			InvocationInput mxInvocationInput = new InvocationInput(context);
			mxInvocationInput.setTraceId(awsInvocationInput.traceId());
			mxInvocationInput.setTraceType(ENUM_TraceType.ORCHESTRATION_TRACE);
			mxInvocationInput.setInvocationType(ENUM_InvocationType.valueOf(awsInvocationInput.invocationType().toString()));
			
			//Create KnowledgeBaseLookupInput
			if (awsInvocationInput.knowledgeBaseLookupInput() != null) {
				KnowledgeBaseLookupInput mxKnowledgeBaseLookupInput = new KnowledgeBaseLookupInput(context);
				software.amazon.awssdk.services.bedrockagentruntime.model.KnowledgeBaseLookupInput awsKnowledgeBaseLookupInput = awsInvocationInput.knowledgeBaseLookupInput();
				mxKnowledgeBaseLookupInput.setKnowledgeBaseId(awsKnowledgeBaseLookupInput.knowledgeBaseId());
				mxKnowledgeBaseLookupInput.setText(awsKnowledgeBaseLookupInput.text());
				mxInvocationInput.setKnowledgeBaseLookupInput_InvocationInput(mxKnowledgeBaseLookupInput);
			}
			
			// Create ActionGroupInvocationInput
			if (awsInvocationInput.actionGroupInvocationInput() != null) {
				ActionGroupInvocationInput mxActionGroupInvocationInput = new ActionGroupInvocationInput(context);
				software.amazon.awssdk.services.bedrockagentruntime.model.ActionGroupInvocationInput awsActionGroupInvocationInput = awsInvocationInput.actionGroupInvocationInput();
				mxActionGroupInvocationInput.setActionGroupName(awsActionGroupInvocationInput.actionGroupName());
				mxActionGroupInvocationInput.setApiPath(awsActionGroupInvocationInput.apiPath());
				mxActionGroupInvocationInput.setVerb(awsActionGroupInvocationInput.verb());
				
				// Create InvocationInputParameters
				if (awsActionGroupInvocationInput.hasParameters()) {
					awsActionGroupInvocationInput.parameters().forEach(awsParameter -> {
						InvocationInputParameter mxParameter = new InvocationInputParameter(context);
						setMxParameter(mxParameter, awsParameter);
						mxParameter.setInvocationInputParameter_ActionGroupInvocationInput(mxActionGroupInvocationInput);
					});
					
					// Create RequestBodyContent 
					if (awsActionGroupInvocationInput.requestBody() != null && awsActionGroupInvocationInput.requestBody().hasContent()) {
						Map<String, List<software.amazon.awssdk.services.bedrockagentruntime.model.Parameter>> awsContentMap = awsActionGroupInvocationInput.requestBody().content();
						awsContentMap.forEach((str, params) -> {
							RequestBodyContent mxRequestBodyContent = new RequestBodyContent(context);
							mxRequestBodyContent.setContentKey(str);
							
							// Create RequestBodyContentParameters
							params.forEach(awsParameter -> {
								RequestBodyContentParameter mxParameter = new RequestBodyContentParameter(context);
								setMxParameter(mxParameter, awsParameter);
								mxParameter.setRequestBodyContentParameter_RequestBodyContent(mxRequestBodyContent);
							});
							
							mxRequestBodyContent.setRequestBodyContent_ActionGroupInvocationInput(mxActionGroupInvocationInput);
						});
					}
				}
				
				// Associate with Invocation Input
				mxInvocationInput.setActionGroupInvocationInput_InvocationInput(mxActionGroupInvocationInput);
				
			}
			
			return mxInvocationInput;
		}
		
		// Reusable method for MxParameter objects
		private static void setMxParameter(Parameter mxParameter, software.amazon.awssdk.services.bedrockagentruntime.model.Parameter awsParameter) {
			mxParameter.setName(awsParameter.name());
			mxParameter.set_Type(awsParameter.type());
			mxParameter.setValue(awsParameter.value());
		}
		
		private static OrchestrationModelInvocationInput createMxOrchestrationModelInvocationInput(ModelInvocationInput awsModelInvocationInput, IContext context) {
			OrchestrationModelInvocationInput mxOrchestrationModelInvocationInput = new OrchestrationModelInvocationInput(context);
			mxOrchestrationModelInvocationInput.setTraceType(ENUM_TraceType.ORCHESTRATION_TRACE);
			setMxModelInvocationInput(mxOrchestrationModelInvocationInput, awsModelInvocationInput);
			return mxOrchestrationModelInvocationInput;
		}
		
		private static Rationale createMxRationale(software.amazon.awssdk.services.bedrockagentruntime.model.Rationale awsRationale, IContext context) {
			Rationale mxRationale = new Rationale(context);
			mxRationale.setTraceType(ENUM_TraceType.ORCHESTRATION_TRACE);
			mxRationale.setTraceId(awsRationale.traceId());
			mxRationale.setText(awsRationale.text());
			return mxRationale;
		}
		
		private static Observation createMxObservation(software.amazon.awssdk.services.bedrockagentruntime.model.Observation awsObservation, IContext context) {
			Observation mxObservation = new Observation(context);
			mxObservation.setTraceType(ENUM_TraceType.ORCHESTRATION_TRACE);
			mxObservation.setTraceId(awsObservation.traceId());
			
			if (awsObservation.actionGroupInvocationOutput() != null) {
				mxObservation.setActionGroupInvocationOutput(awsObservation.actionGroupInvocationOutput().text());
			}
			
			if (awsObservation.finalResponse() != null) {
				mxObservation.setFinalResponse(awsObservation.finalResponse().text());
			}
			
			mxObservation.setObservationType(ENUM_ObservationType.valueOf(awsObservation.type().toString()));
			
			// Create RepromptResponse
			if (awsObservation.repromptResponse() != null) {
				RepromptResponse mxRepromptResponse = new RepromptResponse(context);
				software.amazon.awssdk.services.bedrockagentruntime.model.RepromptResponse awsRepromptResponse = awsObservation.repromptResponse();
				mxRepromptResponse.setRepromptSource(ENUM_RepromptSource.valueOf(awsRepromptResponse.source().toString()));
				mxRepromptResponse.setText(awsRepromptResponse.text());
				mxObservation.setRepromptResponse_Observation(mxRepromptResponse);
			}
			
			// Create ObservationRetrievedReferences
			if (awsObservation.knowledgeBaseLookupOutput() != null && awsObservation.knowledgeBaseLookupOutput().hasRetrievedReferences()) {
					awsObservation.knowledgeBaseLookupOutput().retrievedReferences().forEach(awsReference -> {
						ObservationRetrievedReference mxReference = new ObservationRetrievedReference(context);
						MxRetrievedReference.setMxRetrievedReference(mxReference, awsReference, context);
						mxReference.setObservationRetrievedReference_Observation(mxObservation);
					});
			}
			
			return mxObservation;
		}
	
	
	
	// END EXTRA CODE
}
