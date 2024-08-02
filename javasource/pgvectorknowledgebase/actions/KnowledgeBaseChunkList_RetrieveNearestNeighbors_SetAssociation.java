// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pgvectorknowledgebase.actions;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.meta.IMetaObject;
import com.mendix.webui.CustomJavaAction;
import genaicommons.proxies.KnowledgeBaseChunk;
import pgvectorknowledgebase.impl.ChunkUtils;
import pgvectorknowledgebase.impl.MxLogger;

/**
 * Use this operation to retrieve chunks from the knowledge base and set associations to the related mendix objects (if applicable). The retrieval is based on similarity with respect to the input vector provided.  This operation returns a list of the same type of the TargetChunk input variable. The returned list is sorted on similarity.
 * Additional filtering can be done by specifying the optional input parameters:
 * -MinimumSimilarity (in the range 0-1.0): acts as a cut-off: chunks are not retrieved if they have a similarity below this value.
 * -MaxNumberOfResults: determines the max number of similar chunks that are returned.
 * -MetadataCollection: when provided, this operation only returns chunks that are conform with all of the metadata key/value pairs in the collection.
 * 
 * The Connection entity passed must be of type PgVectorKnowledgebaseConnection and must contain the KnowledgeBaseName string attribute filled and a DatabaseConfiguration associated with the connection details to a PostgreSQL database server with the PgVector extension installed. This DatabaseConfiguration entity is typically configured at runtime or in after-startup logic. By providing the KnowledgeBaseName on the Connection, you determine the knowledge base. 
 * The TargetChunk entity (type parameter) must be a specialization of the Chunk entity from this module. If it contains associations to (specializations of) the related mendix object for which the chunk was created, this will be set by this operation for easy processing afterwards.
 */
public class KnowledgeBaseChunkList_RetrieveNearestNeighbors_SetAssociation extends CustomJavaAction<java.util.List<IMendixObject>>
{
	/** @deprecated use Connection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Connection;
	private final genaicommons.proxies.Connection Connection;
	private final java.lang.String TargetChunk;
	private final java.lang.String Vector;
	/** @deprecated use MetadataCollection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __MetadataCollection;
	private final genaicommons.proxies.MetadataCollection MetadataCollection;
	private final java.lang.Long MaxNumberOfResults;
	private final java.math.BigDecimal MinimumSimilarity;

	public KnowledgeBaseChunkList_RetrieveNearestNeighbors_SetAssociation(
		IContext context,
		IMendixObject _connection,
		java.lang.String _targetChunk,
		java.lang.String _vector,
		IMendixObject _metadataCollection,
		java.lang.Long _maxNumberOfResults,
		java.math.BigDecimal _minimumSimilarity
	)
	{
		super(context);
		this.__Connection = _connection;
		this.Connection = _connection == null ? null : genaicommons.proxies.Connection.initialize(getContext(), _connection);
		this.TargetChunk = _targetChunk;
		this.Vector = _vector;
		this.__MetadataCollection = _metadataCollection;
		this.MetadataCollection = _metadataCollection == null ? null : genaicommons.proxies.MetadataCollection.initialize(getContext(), _metadataCollection);
		this.MaxNumberOfResults = _maxNumberOfResults;
		this.MinimumSimilarity = _minimumSimilarity;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		
		try { 
			IMetaObject targetChunk = Core.getMetaObject(TargetChunk);
			ChunkUtils.validateTargetChunk(targetChunk);
			
			// call a microflow to retrieve chunks
			java.util.List<KnowledgeBaseChunk> chunkList = pgvectorknowledgebase.proxies.microflows.Microflows.knowledgeBaseChunkList_RetrieveNearestNeighbors(
					getContext(), Vector, MinimumSimilarity, MaxNumberOfResults, Connection, MetadataCollection);
			
			//map to target chunks to return
			return ChunkUtils.getTargetChunkList(getContext(), chunkList, targetChunk);
			
		} catch (Exception e) {
			LOGGER.error(e, "Something went wrong while retrieving chunks from the knowledge base and associating the mendix objects to the target chunks.");
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
		return "KnowledgeBaseChunkList_RetrieveNearestNeighbors_SetAssociation";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(KnowledgeBaseChunkList_RetrieveNearestNeighbors_SetAssociation.class);
	// END EXTRA CODE
}
