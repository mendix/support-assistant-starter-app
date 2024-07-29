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
import amazonbedrockconnector.impl.MxIngestionJob;
import amazonbedrockconnector.impl.MxLogger;
import software.amazon.awssdk.services.bedrockagent.BedrockAgentClient;
import software.amazon.awssdk.services.bedrockagent.model.GetIngestionJobRequest;

public class GetIngestionJob extends CustomJavaAction<IMendixObject>
{
	/** @deprecated use Credentials.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Credentials;
	private final awsauthentication.proxies.Credentials Credentials;
	private final awsauthentication.proxies.ENUM_Region ENUM_Region;
	/** @deprecated use GetIngestionJobRequest.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __GetIngestionJobRequest;
	private final amazonbedrockconnector.proxies.GetIngestionJobRequest GetIngestionJobRequest;

	public GetIngestionJob(
		IContext context,
		IMendixObject _credentials,
		java.lang.String _eNUM_Region,
		IMendixObject _getIngestionJobRequest
	)
	{
		super(context);
		this.__Credentials = _credentials;
		this.Credentials = _credentials == null ? null : awsauthentication.proxies.Credentials.initialize(getContext(), _credentials);
		this.ENUM_Region = _eNUM_Region == null ? null : awsauthentication.proxies.ENUM_Region.valueOf(_eNUM_Region);
		this.__GetIngestionJobRequest = _getIngestionJobRequest;
		this.GetIngestionJobRequest = _getIngestionJobRequest == null ? null : amazonbedrockconnector.proxies.GetIngestionJobRequest.initialize(getContext(), _getIngestionJobRequest);
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			// Validating JA input parameters
			requireNonNull(Credentials, "AWS Credentials are required");
			requireNonNull(GetIngestionJobRequest, "GetIngestionJobResponse is required");
			requireNonNull(ENUM_Region, "AWS Region is required");
			
			validateRequest();

			BedrockAgentClient BRclient = AmazonBedrockClient.getBedrockAgentClient(Credentials, ENUM_Region, GetIngestionJobRequest);
			
			software.amazon.awssdk.services.bedrockagent.model.GetIngestionJobRequest awsRequest = getAwsRequest();
			LOGGER.info("AWS request: " + awsRequest);
			
			software.amazon.awssdk.services.bedrockagent.model.GetIngestionJobResponse awsResponse = BRclient.getIngestionJob(awsRequest);
			LOGGER.info("AWS response: " + awsResponse);
			
			return MxIngestionJob.getMxResponse(awsResponse, getContext()).getMendixObject();
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
		return "GetIngestionJob";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(GetIngestionJob.class);
	
	private void validateRequest() {
		if (GetIngestionJobRequest.getDataSourceId() == null || GetIngestionJobRequest.getDataSourceId().isBlank()) {
			throw new IllegalArgumentException("DataSourceId is required. Please provide the data source id of the model you want to invoke.");
		}
		
		if (GetIngestionJobRequest.getKnowledgeBaseId() == null || GetIngestionJobRequest.getKnowledgeBaseId().isBlank()) {
			throw new IllegalArgumentException("KnowledgeBaseId is required. Please provide the knowledge base id of the knowledge base you want to invoke.");
		}

		if (GetIngestionJobRequest.getIngestionJobId() == null || GetIngestionJobRequest.getIngestionJobId().isBlank()) {
			throw new IllegalArgumentException("IngestionJobId is required. Please provide the ingestion id of the job that you want to retrieve the status of.");
		}
	}

	private GetIngestionJobRequest getAwsRequest() {
		return software.amazon.awssdk.services.bedrockagent.model.GetIngestionJobRequest.builder()
		.dataSourceId(GetIngestionJobRequest.getDataSourceId())
		.ingestionJobId(GetIngestionJobRequest.getIngestionJobId())
		.knowledgeBaseId(GetIngestionJobRequest.getKnowledgeBaseId())
		.build();
	}

	// END EXTRA CODE
}
