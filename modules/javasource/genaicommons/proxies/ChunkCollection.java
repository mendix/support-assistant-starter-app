// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * A collection of chunks.
 */
public class ChunkCollection implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject chunkCollectionMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.ChunkCollection";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		ChunkCollection_Chunk("GenAICommons.ChunkCollection_Chunk");

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

	public ChunkCollection(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected ChunkCollection(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject chunkCollectionMendixObject)
	{
		if (chunkCollectionMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, chunkCollectionMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.chunkCollectionMendixObject = chunkCollectionMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.ChunkCollection initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new genaicommons.proxies.ChunkCollection(context, mendixObject);
	}

	public static genaicommons.proxies.ChunkCollection load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.ChunkCollection.initialize(context, mendixObject);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of ChunkCollection_Chunk
	 */
	public final java.util.List<genaicommons.proxies.Chunk> getChunkCollection_Chunk() throws com.mendix.core.CoreException
	{
		return getChunkCollection_Chunk(getContext());
	}

	/**
	 * @param context
	 * @return value of ChunkCollection_Chunk
	 * @throws com.mendix.core.CoreException
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<genaicommons.proxies.Chunk> getChunkCollection_Chunk(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<genaicommons.proxies.Chunk> result = new java.util.ArrayList<>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.ChunkCollection_Chunk.toString());
		if (valueObject == null) {
			return result;
		}
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject)) {
			result.add(genaicommons.proxies.Chunk.initialize(context, mendixObject));
		}
		return result;
	}

	/**
	 * Set value of ChunkCollection_Chunk
	 * @param chunkcollection_chunk
	 */
	public final void setChunkCollection_Chunk(java.util.List<genaicommons.proxies.Chunk> chunkcollection_chunk)
	{
		setChunkCollection_Chunk(getContext(), chunkcollection_chunk);
	}

	/**
	 * Set value of ChunkCollection_Chunk
	 * @param context
	 * @param chunkcollection_chunk
	 */
	public final void setChunkCollection_Chunk(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<genaicommons.proxies.Chunk> chunkcollection_chunk)
	{
		var identifiers = chunkcollection_chunk
			.stream()
			.map(proxyObject -> proxyObject.getMendixObject().getId())
			.collect(java.util.stream.Collectors.toList());
		
		getMendixObject().setValue(context, MemberNames.ChunkCollection_Chunk.toString(), identifiers);
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return chunkCollectionMendixObject;
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
			return true;
		}
		if (obj != null && getClass().equals(obj.getClass()))
		{
			final genaicommons.proxies.ChunkCollection that = (genaicommons.proxies.ChunkCollection) obj;
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
