// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * An optional collection of metadata.
 */
public class MetadataCollection implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject metadataCollectionMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.MetadataCollection";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		MetadataCollection_Metadata("GenAICommons.MetadataCollection_Metadata");

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

	public MetadataCollection(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected MetadataCollection(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject metadataCollectionMendixObject)
	{
		if (metadataCollectionMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, metadataCollectionMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.metadataCollectionMendixObject = metadataCollectionMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.MetadataCollection initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new genaicommons.proxies.MetadataCollection(context, mendixObject);
	}

	public static genaicommons.proxies.MetadataCollection load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.MetadataCollection.initialize(context, mendixObject);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of MetadataCollection_Metadata
	 */
	public final java.util.List<genaicommons.proxies.Metadata> getMetadataCollection_Metadata() throws com.mendix.core.CoreException
	{
		return getMetadataCollection_Metadata(getContext());
	}

	/**
	 * @param context
	 * @return value of MetadataCollection_Metadata
	 * @throws com.mendix.core.CoreException
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<genaicommons.proxies.Metadata> getMetadataCollection_Metadata(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<genaicommons.proxies.Metadata> result = new java.util.ArrayList<>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.MetadataCollection_Metadata.toString());
		if (valueObject == null) {
			return result;
		}
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject)) {
			result.add(genaicommons.proxies.Metadata.initialize(context, mendixObject));
		}
		return result;
	}

	/**
	 * Set value of MetadataCollection_Metadata
	 * @param metadatacollection_metadata
	 */
	public final void setMetadataCollection_Metadata(java.util.List<genaicommons.proxies.Metadata> metadatacollection_metadata)
	{
		setMetadataCollection_Metadata(getContext(), metadatacollection_metadata);
	}

	/**
	 * Set value of MetadataCollection_Metadata
	 * @param context
	 * @param metadatacollection_metadata
	 */
	public final void setMetadataCollection_Metadata(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<genaicommons.proxies.Metadata> metadatacollection_metadata)
	{
		var identifiers = metadatacollection_metadata
			.stream()
			.map(proxyObject -> proxyObject.getMendixObject().getId())
			.collect(java.util.stream.Collectors.toList());
		
		getMendixObject().setValue(context, MemberNames.MetadataCollection_Metadata.toString(), identifiers);
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return metadataCollectionMendixObject;
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
			final genaicommons.proxies.MetadataCollection that = (genaicommons.proxies.MetadataCollection) obj;
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
