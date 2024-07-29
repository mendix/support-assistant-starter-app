// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pgvectorknowledgebase.actions;

import java.util.ArrayList;
import java.util.stream.Collectors;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import genaicommons.proxies.KnowledgeBaseChunk;
import pgvectorknowledgebase.impl.ChunkUtils;
import pgvectorknowledgebase.impl.MxLogger;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Use this operation to retrieve chunks from the knowledge base. This operation returns a list of KnowledgeBaseChunks
 * Additional selection and filtering can be done by specifying the optional input parameters:
 * -Offset: number of records to skip (for batching purposes)
 * -MaxNumberOfResults: limit of the amount of records returned
 * -MetadataCollection: when provided, this operation only returns chunks that are conform with all of the metadata key/value pairs in the list.
 * -MxObject: This is the (original) Mendix object that the chunks in the knowledge base represent. Only chunks related to this Mendix object are retrieved.
 * 
 * The Connection entity passed must be of type PgVectorKnowledgebaseConnection and must contain the KnowledgeBaseName string attribute filled and a DatabaseConfiguration associated with the connection details to a PostgreSQL database server with the PgVector extension installed. This DatabaseConfiguration entity is typically configured at runtime or in after-startup logic. By providing the KnowledgeBaseName on the Connection, you determine the knowledge base. 
 */
public class KnowledgeBaseChunkList_Retrieve extends CustomJavaAction<java.util.List<IMendixObject>>
{
	/** @deprecated use Connection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Connection;
	private final genaicommons.proxies.Connection Connection;
	private final IMendixObject MxObject;
	/** @deprecated use MetadataCollection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __MetadataCollection;
	private final genaicommons.proxies.MetadataCollection MetadataCollection;
	private final java.lang.Long MaxNumberOfResults;
	private final java.lang.Long Offset;

	public KnowledgeBaseChunkList_Retrieve(
		IContext context,
		IMendixObject _connection,
		IMendixObject _mxObject,
		IMendixObject _metadataCollection,
		java.lang.Long _maxNumberOfResults,
		java.lang.Long _offset
	)
	{
		super(context);
		this.__Connection = _connection;
		this.Connection = _connection == null ? null : genaicommons.proxies.Connection.initialize(getContext(), _connection);
		this.MxObject = _mxObject;
		this.__MetadataCollection = _metadataCollection;
		this.MetadataCollection = _metadataCollection == null ? null : genaicommons.proxies.MetadataCollection.initialize(getContext(), _metadataCollection);
		this.MaxNumberOfResults = _maxNumberOfResults;
		this.Offset = _offset;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			java.util.List<KnowledgeBaseChunk> chunkList = new ArrayList<>();
			if (MxObject == null) {
				LOGGER.info("No MxObject was passed, retrieve will be executed without MendixIDs specified.");
			}
			else {
				ChunkUtils.addChunkWithMxObjectID(getContext(), MxObject, chunkList);
			}
			java.util.List<KnowledgeBaseChunk> knowledgeBaseChunkList = pgvectorknowledgebase.proxies.microflows.Microflows.knowledgeBaseChunkList_Retrieve_ByMxObjectIDs( getContext(), MaxNumberOfResults, Offset, MetadataCollection, Connection, chunkList);
			java.util.List<IMendixObject> returnList = knowledgeBaseChunkList.stream().map(o -> o.getMendixObject()).collect(Collectors.toList());
			return returnList;
		} catch (Error e) {
			LOGGER.error(e, "Something went wrong while retrieving chunks from the knowledge base.");
			return null;
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
		return "KnowledgeBaseChunkList_Retrieve";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(KnowledgeBaseChunkList_Retrieve.class);
	// END EXTRA CODE
}
