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
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import pgvectorknowledgebase.impl.ChunkUtils;
import pgvectorknowledgebase.impl.MxLogger;
import pgvectorknowledgebase.proxies.Chunk;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Use this operation to delete existing chunks and corresponding labels in a knowledge base based on the MxObjectID. 
 * MxObjectList is the list of (original) Mendix objects that the chunks in the knowledge base represent. Only chunks related to these Mendix objects are to be deleted.
 * By providing the KnowledgeBaseName parameter, you determine the knowledge base.
 * The DatabaseConfiguration that is passed must contain the connection details to a PostgreSQL database server with the PgVector extension installed. This entity is typically configured at runtime or in after-startup logic.
 */
public class ChunkList_Delete_ByMxObjectList extends CustomJavaAction<java.lang.Boolean>
{
	/** @deprecated use DatabaseConfiguration.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __DatabaseConfiguration;
	private final pgvectorknowledgebase.proxies.DatabaseConfiguration DatabaseConfiguration;
	private final java.lang.String KnowledgeBaseName;
	private final java.util.List<IMendixObject> MxObjectList;

	public ChunkList_Delete_ByMxObjectList(
		IContext context,
		IMendixObject _databaseConfiguration,
		java.lang.String _knowledgeBaseName,
		java.util.List<IMendixObject> _mxObjectList
	)
	{
		super(context);
		this.__DatabaseConfiguration = _databaseConfiguration;
		this.DatabaseConfiguration = _databaseConfiguration == null ? null : pgvectorknowledgebase.proxies.DatabaseConfiguration.initialize(getContext(), _databaseConfiguration);
		this.KnowledgeBaseName = _knowledgeBaseName;
		this.MxObjectList = _mxObjectList;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			if (MxObjectList.isEmpty()) {
				LOGGER.warn("Empty list was passed, nothing was deleted");
			}
			java.util.List<Chunk> chunkList = new ArrayList<>();
			MxObjectList.forEach(o -> ChunkUtils.addChunkWithMxObjectID(getContext(), o, chunkList));
			return pgvectorknowledgebase.proxies.microflows.Microflows.chunkList_Delete_FromKnowledgeBase(
					getContext(), DatabaseConfiguration, KnowledgeBaseName, chunkList);
		} catch (Error e) {
			LOGGER.error(e.getMessage());
			return false;
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
		return "ChunkList_Delete_ByMxObjectList";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(Chunk_Create.class);
	// END EXTRA CODE
}
