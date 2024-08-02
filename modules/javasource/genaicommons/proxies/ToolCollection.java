// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * This is an optional collection of tools to be sent along with the Request. Using Tool capabilities (e.g. function calling) might not be supported by all AI providers or models. This entity functions as a wrapper entity for files and has no direct attributes.
 */
public class ToolCollection implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject toolCollectionMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.ToolCollection";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		ToolCollection_Tool("GenAICommons.ToolCollection_Tool"),
		ToolCollection_ToolChoice("GenAICommons.ToolCollection_ToolChoice");

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

	public ToolCollection(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected ToolCollection(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject toolCollectionMendixObject)
	{
		if (toolCollectionMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, toolCollectionMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.toolCollectionMendixObject = toolCollectionMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.ToolCollection initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new genaicommons.proxies.ToolCollection(context, mendixObject);
	}

	public static genaicommons.proxies.ToolCollection load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.ToolCollection.initialize(context, mendixObject);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of ToolCollection_Tool
	 */
	public final java.util.List<genaicommons.proxies.Tool> getToolCollection_Tool() throws com.mendix.core.CoreException
	{
		return getToolCollection_Tool(getContext());
	}

	/**
	 * @param context
	 * @return value of ToolCollection_Tool
	 * @throws com.mendix.core.CoreException
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<genaicommons.proxies.Tool> getToolCollection_Tool(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<genaicommons.proxies.Tool> result = new java.util.ArrayList<>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.ToolCollection_Tool.toString());
		if (valueObject == null) {
			return result;
		}
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject)) {
			result.add(genaicommons.proxies.Tool.initialize(context, mendixObject));
		}
		return result;
	}

	/**
	 * Set value of ToolCollection_Tool
	 * @param toolcollection_tool
	 */
	public final void setToolCollection_Tool(java.util.List<genaicommons.proxies.Tool> toolcollection_tool)
	{
		setToolCollection_Tool(getContext(), toolcollection_tool);
	}

	/**
	 * Set value of ToolCollection_Tool
	 * @param context
	 * @param toolcollection_tool
	 */
	public final void setToolCollection_Tool(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<genaicommons.proxies.Tool> toolcollection_tool)
	{
		var identifiers = toolcollection_tool
			.stream()
			.map(proxyObject -> proxyObject.getMendixObject().getId())
			.collect(java.util.stream.Collectors.toList());
		
		getMendixObject().setValue(context, MemberNames.ToolCollection_Tool.toString(), identifiers);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of ToolCollection_ToolChoice
	 */
	public final genaicommons.proxies.Tool getToolCollection_ToolChoice() throws com.mendix.core.CoreException
	{
		return getToolCollection_ToolChoice(getContext());
	}

	/**
	 * @param context
	 * @return value of ToolCollection_ToolChoice
	 * @throws com.mendix.core.CoreException
	 */
	public final genaicommons.proxies.Tool getToolCollection_ToolChoice(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		genaicommons.proxies.Tool result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.ToolCollection_ToolChoice.toString());
		if (identifier != null) {
			result = genaicommons.proxies.Tool.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of ToolCollection_ToolChoice
	 * @param toolcollection_toolchoice
	 */
	public final void setToolCollection_ToolChoice(genaicommons.proxies.Tool toolcollection_toolchoice)
	{
		setToolCollection_ToolChoice(getContext(), toolcollection_toolchoice);
	}

	/**
	 * Set value of ToolCollection_ToolChoice
	 * @param context
	 * @param toolcollection_toolchoice
	 */
	public final void setToolCollection_ToolChoice(com.mendix.systemwideinterfaces.core.IContext context, genaicommons.proxies.Tool toolcollection_toolchoice)
	{
		if (toolcollection_toolchoice == null) {
			getMendixObject().setValue(context, MemberNames.ToolCollection_ToolChoice.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.ToolCollection_ToolChoice.toString(), toolcollection_toolchoice.getMendixObject().getId());
		}
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return toolCollectionMendixObject;
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
			final genaicommons.proxies.ToolCollection that = (genaicommons.proxies.ToolCollection) obj;
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
