// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * This entity represents a discrete piece of knowledge that can be used in embed and store operations.
 */
public class KnowledgeBaseChunk extends genaicommons.proxies.Chunk
{
	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.KnowledgeBaseChunk";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		ChunkID("ChunkID"),
		HumanReadableID("HumanReadableID"),
		MxObjectID("MxObjectID"),
		MxEntity("MxEntity"),
		Similarity("Similarity"),
		InputText("InputText"),
		EmbeddingVector("EmbeddingVector"),
		_Index("_Index"),
		KnowledgeBaseChunk_MetadataCollection("GenAICommons.KnowledgeBaseChunk_MetadataCollection");

		private final java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public KnowledgeBaseChunk(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected KnowledgeBaseChunk(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject knowledgeBaseChunkMendixObject)
	{
		super(context, knowledgeBaseChunkMendixObject);
		if (!com.mendix.core.Core.isSubClassOf(entityName, knowledgeBaseChunkMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.KnowledgeBaseChunk initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		if (com.mendix.core.Core.isSubClassOf("MyFirstTicketBot.TicketChunk", mendixObject.getType())) {
			return myfirstticketbot.proxies.TicketChunk.initialize(context, mendixObject);
		}
		return new genaicommons.proxies.KnowledgeBaseChunk(context, mendixObject);
	}

	public static genaicommons.proxies.KnowledgeBaseChunk load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.KnowledgeBaseChunk.initialize(context, mendixObject);
	}

	/**
	 * @return value of ChunkID
	 */
	public final java.lang.String getChunkID()
	{
		return getChunkID(getContext());
	}

	/**
	 * @param context
	 * @return value of ChunkID
	 */
	public final java.lang.String getChunkID(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ChunkID.toString());
	}

	/**
	 * Set value of ChunkID
	 * @param chunkid
	 */
	public final void setChunkID(java.lang.String chunkid)
	{
		setChunkID(getContext(), chunkid);
	}

	/**
	 * Set value of ChunkID
	 * @param context
	 * @param chunkid
	 */
	public final void setChunkID(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String chunkid)
	{
		getMendixObject().setValue(context, MemberNames.ChunkID.toString(), chunkid);
	}

	/**
	 * @return value of HumanReadableID
	 */
	public final java.lang.String getHumanReadableID()
	{
		return getHumanReadableID(getContext());
	}

	/**
	 * @param context
	 * @return value of HumanReadableID
	 */
	public final java.lang.String getHumanReadableID(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.HumanReadableID.toString());
	}

	/**
	 * Set value of HumanReadableID
	 * @param humanreadableid
	 */
	public final void setHumanReadableID(java.lang.String humanreadableid)
	{
		setHumanReadableID(getContext(), humanreadableid);
	}

	/**
	 * Set value of HumanReadableID
	 * @param context
	 * @param humanreadableid
	 */
	public final void setHumanReadableID(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String humanreadableid)
	{
		getMendixObject().setValue(context, MemberNames.HumanReadableID.toString(), humanreadableid);
	}

	/**
	 * @return value of MxObjectID
	 */
	public final java.lang.String getMxObjectID()
	{
		return getMxObjectID(getContext());
	}

	/**
	 * @param context
	 * @return value of MxObjectID
	 */
	public final java.lang.String getMxObjectID(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.MxObjectID.toString());
	}

	/**
	 * Set value of MxObjectID
	 * @param mxobjectid
	 */
	public final void setMxObjectID(java.lang.String mxobjectid)
	{
		setMxObjectID(getContext(), mxobjectid);
	}

	/**
	 * Set value of MxObjectID
	 * @param context
	 * @param mxobjectid
	 */
	public final void setMxObjectID(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String mxobjectid)
	{
		getMendixObject().setValue(context, MemberNames.MxObjectID.toString(), mxobjectid);
	}

	/**
	 * @return value of MxEntity
	 */
	public final java.lang.String getMxEntity()
	{
		return getMxEntity(getContext());
	}

	/**
	 * @param context
	 * @return value of MxEntity
	 */
	public final java.lang.String getMxEntity(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.MxEntity.toString());
	}

	/**
	 * Set value of MxEntity
	 * @param mxentity
	 */
	public final void setMxEntity(java.lang.String mxentity)
	{
		setMxEntity(getContext(), mxentity);
	}

	/**
	 * Set value of MxEntity
	 * @param context
	 * @param mxentity
	 */
	public final void setMxEntity(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String mxentity)
	{
		getMendixObject().setValue(context, MemberNames.MxEntity.toString(), mxentity);
	}

	/**
	 * @return value of Similarity
	 */
	public final java.math.BigDecimal getSimilarity()
	{
		return getSimilarity(getContext());
	}

	/**
	 * @param context
	 * @return value of Similarity
	 */
	public final java.math.BigDecimal getSimilarity(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Similarity.toString());
	}

	/**
	 * Set value of Similarity
	 * @param similarity
	 */
	public final void setSimilarity(java.math.BigDecimal similarity)
	{
		setSimilarity(getContext(), similarity);
	}

	/**
	 * Set value of Similarity
	 * @param context
	 * @param similarity
	 */
	public final void setSimilarity(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal similarity)
	{
		getMendixObject().setValue(context, MemberNames.Similarity.toString(), similarity);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of KnowledgeBaseChunk_MetadataCollection
	 */
	public final genaicommons.proxies.MetadataCollection getKnowledgeBaseChunk_MetadataCollection() throws com.mendix.core.CoreException
	{
		return getKnowledgeBaseChunk_MetadataCollection(getContext());
	}

	/**
	 * @param context
	 * @return value of KnowledgeBaseChunk_MetadataCollection
	 * @throws com.mendix.core.CoreException
	 */
	public final genaicommons.proxies.MetadataCollection getKnowledgeBaseChunk_MetadataCollection(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		genaicommons.proxies.MetadataCollection result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.KnowledgeBaseChunk_MetadataCollection.toString());
		if (identifier != null) {
			result = genaicommons.proxies.MetadataCollection.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of KnowledgeBaseChunk_MetadataCollection
	 * @param knowledgebasechunk_metadatacollection
	 */
	public final void setKnowledgeBaseChunk_MetadataCollection(genaicommons.proxies.MetadataCollection knowledgebasechunk_metadatacollection)
	{
		setKnowledgeBaseChunk_MetadataCollection(getContext(), knowledgebasechunk_metadatacollection);
	}

	/**
	 * Set value of KnowledgeBaseChunk_MetadataCollection
	 * @param context
	 * @param knowledgebasechunk_metadatacollection
	 */
	public final void setKnowledgeBaseChunk_MetadataCollection(com.mendix.systemwideinterfaces.core.IContext context, genaicommons.proxies.MetadataCollection knowledgebasechunk_metadatacollection)
	{
		if (knowledgebasechunk_metadatacollection == null) {
			getMendixObject().setValue(context, MemberNames.KnowledgeBaseChunk_MetadataCollection.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.KnowledgeBaseChunk_MetadataCollection.toString(), knowledgebasechunk_metadatacollection.getMendixObject().getId());
		}
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
			return true;
		}
		if (obj != null && getClass().equals(obj.getClass()))
		{
			final genaicommons.proxies.KnowledgeBaseChunk that = (genaicommons.proxies.KnowledgeBaseChunk) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

  /**
   * Gives full name ("Module.Entity" name) of the type of the entity.
   *
   * @return the name
   */
	public static java.lang.String getType()
	{
		return entityName;
	}
}
