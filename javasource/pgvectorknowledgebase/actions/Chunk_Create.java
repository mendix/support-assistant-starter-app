// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pgvectorknowledgebase.actions;

import static java.util.Objects.requireNonNull;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import communitycommons.StringUtils;
import pgvectorknowledgebase.impl.MxLogger;
import pgvectorknowledgebase.proxies.Chunk;

/**
 * This action can be used for instantiating Chunk objects to create the input for the knowledge base based on your own data structure. A ChunkList must be passed to which the new Chunk object will be added.
 * Optionally, use Label_Create to construct a list of Labels for custom filtering during the retrieval.
 * 
 * Please check the documentation for each parameter for more detailed information on how to use this operation in your project.
 */
public class Chunk_Create extends CustomJavaAction<java.lang.Void>
{
	/** @deprecated use com.mendix.utils.ListUtils.map(ChunkList, com.mendix.systemwideinterfaces.core.IEntityProxy::getMendixObject) instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final java.util.List<IMendixObject> __ChunkList;
	private final java.util.List<pgvectorknowledgebase.proxies.Chunk> ChunkList;
	private final java.lang.String HumanReadableID;
	private final java.lang.String Vector;
	private final pgvectorknowledgebase.proxies.ENUM_ChunkType ChunkType;
	private final java.lang.String Key;
	private final java.lang.String Value;
	private final IMendixObject MxObject;
	/** @deprecated use com.mendix.utils.ListUtils.map(LabelList, com.mendix.systemwideinterfaces.core.IEntityProxy::getMendixObject) instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final java.util.List<IMendixObject> __LabelList;
	private final java.util.List<pgvectorknowledgebase.proxies.Label> LabelList;

	public Chunk_Create(
		IContext context,
		java.util.List<IMendixObject> _chunkList,
		java.lang.String _humanReadableID,
		java.lang.String _vector,
		java.lang.String _chunkType,
		java.lang.String _key,
		java.lang.String _value,
		IMendixObject _mxObject,
		java.util.List<IMendixObject> _labelList
	)
	{
		super(context);
		this.__ChunkList = _chunkList;
		this.ChunkList = java.util.Optional.ofNullable(_chunkList)
			.orElse(java.util.Collections.emptyList())
			.stream()
			.map(chunkListElement -> pgvectorknowledgebase.proxies.Chunk.initialize(getContext(), chunkListElement))
			.collect(java.util.stream.Collectors.toList());
		this.HumanReadableID = _humanReadableID;
		this.Vector = _vector;
		this.ChunkType = _chunkType == null ? null : pgvectorknowledgebase.proxies.ENUM_ChunkType.valueOf(_chunkType);
		this.Key = _key;
		this.Value = _value;
		this.MxObject = _mxObject;
		this.__LabelList = _labelList;
		this.LabelList = java.util.Optional.ofNullable(_labelList)
			.orElse(java.util.Collections.emptyList())
			.stream()
			.map(labelListElement -> pgvectorknowledgebase.proxies.Label.initialize(getContext(), labelListElement))
			.collect(java.util.stream.Collectors.toList());
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			requireNonNull(__ChunkList, "ChunkList is required.");
			requireNonNull(ChunkType, "ChunkType is required.");
			Chunk chunk = new Chunk(getContext());
			chunk.setChunkID(getContext(), StringUtils.randomHash());
			chunk.setHumanReadableID(getContext(), HumanReadableID);
			chunk.setVector(getContext(), Vector);
			chunk.setChunkType(getContext(), ChunkType);
			chunk.setKey(getContext(), Key);
			chunk.setValue(getContext(), ChunkType.equals(pgvectorknowledgebase.proxies.ENUM_ChunkType.KeyValue) 
					? Value : null);
			chunk.setMxObjectID(getContext(), MxObject == null ? null : String.valueOf(MxObject.getId().toLong()));
			chunk.setMxEntity(getContext(), MxObject == null ? null : MxObject.getType());
			
			chunk.setChunk_Label(getContext(), LabelList);
			
			__ChunkList.add(chunk.getMendixObject());
			
			return null;
			
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
		return "Chunk_Create";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(Chunk_Create.class);
	// END EXTRA CODE
}
