// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * A tool call object may be generated by the model in certain scenarios, such as a function call pattern. This entity is only applicable for messages with role `assistant`.
 */
public class ToolCall implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject toolCallMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.ToolCall";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Arguments("Arguments"),
		ToolType("ToolType"),
		ToolCallId("ToolCallId");

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

	public ToolCall(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected ToolCall(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject toolCallMendixObject)
	{
		if (toolCallMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, toolCallMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.toolCallMendixObject = toolCallMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.ToolCall initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new genaicommons.proxies.ToolCall(context, mendixObject);
	}

	public static genaicommons.proxies.ToolCall load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.ToolCall.initialize(context, mendixObject);
	}

	/**
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of Arguments
	 */
	public final java.lang.String getArguments()
	{
		return getArguments(getContext());
	}

	/**
	 * @param context
	 * @return value of Arguments
	 */
	public final java.lang.String getArguments(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Arguments.toString());
	}

	/**
	 * Set value of Arguments
	 * @param arguments
	 */
	public final void setArguments(java.lang.String arguments)
	{
		setArguments(getContext(), arguments);
	}

	/**
	 * Set value of Arguments
	 * @param context
	 * @param arguments
	 */
	public final void setArguments(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String arguments)
	{
		getMendixObject().setValue(context, MemberNames.Arguments.toString(), arguments);
	}

	/**
	 * @return value of ToolType
	 */
	public final java.lang.String getToolType()
	{
		return getToolType(getContext());
	}

	/**
	 * @param context
	 * @return value of ToolType
	 */
	public final java.lang.String getToolType(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ToolType.toString());
	}

	/**
	 * Set value of ToolType
	 * @param tooltype
	 */
	public final void setToolType(java.lang.String tooltype)
	{
		setToolType(getContext(), tooltype);
	}

	/**
	 * Set value of ToolType
	 * @param context
	 * @param tooltype
	 */
	public final void setToolType(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String tooltype)
	{
		getMendixObject().setValue(context, MemberNames.ToolType.toString(), tooltype);
	}

	/**
	 * @return value of ToolCallId
	 */
	public final java.lang.String getToolCallId()
	{
		return getToolCallId(getContext());
	}

	/**
	 * @param context
	 * @return value of ToolCallId
	 */
	public final java.lang.String getToolCallId(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.ToolCallId.toString());
	}

	/**
	 * Set value of ToolCallId
	 * @param toolcallid
	 */
	public final void setToolCallId(java.lang.String toolcallid)
	{
		setToolCallId(getContext(), toolcallid);
	}

	/**
	 * Set value of ToolCallId
	 * @param context
	 * @param toolcallid
	 */
	public final void setToolCallId(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String toolcallid)
	{
		getMendixObject().setValue(context, MemberNames.ToolCallId.toString(), toolcallid);
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return toolCallMendixObject;
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
			final genaicommons.proxies.ToolCall that = (genaicommons.proxies.ToolCall) obj;
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
