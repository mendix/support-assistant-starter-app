// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package genaicommons.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Adds a new KnowledgeBaseChunk to the ChunkCollection to create the input for embeddings or knowledge base operations.
 * Optionally, add a MetadataCollection for more advanced filtering.
 * 
 * Please check the documentation for each parameter for more detailed information on how to use this operation in your project.
 */
public class ChunkCollection_AddKnowledgeBaseChunk extends CustomJavaAction<IMendixObject>
{
	/** @deprecated use ChunkCollection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __ChunkCollection;
	private final genaicommons.proxies.ChunkCollection ChunkCollection;
	private final java.lang.String InputText;
	private final java.lang.String HumanReadableID;
	private final IMendixObject MxObject;
	/** @deprecated use MetadataCollection.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __MetadataCollection;
	private final genaicommons.proxies.MetadataCollection MetadataCollection;

	public ChunkCollection_AddKnowledgeBaseChunk(
		IContext context,
		IMendixObject _chunkCollection,
		java.lang.String _inputText,
		java.lang.String _humanReadableID,
		IMendixObject _mxObject,
		IMendixObject _metadataCollection
	)
	{
		super(context);
		this.__ChunkCollection = _chunkCollection;
		this.ChunkCollection = _chunkCollection == null ? null : genaicommons.proxies.ChunkCollection.initialize(getContext(), _chunkCollection);
		this.InputText = _inputText;
		this.HumanReadableID = _humanReadableID;
		this.MxObject = _mxObject;
		this.__MetadataCollection = _metadataCollection;
		this.MetadataCollection = _metadataCollection == null ? null : genaicommons.proxies.MetadataCollection.initialize(getContext(), _metadataCollection);
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		throw new com.mendix.systemwideinterfaces.MendixRuntimeException("Java action was not implemented");
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ChunkCollection_AddKnowledgeBaseChunk";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
