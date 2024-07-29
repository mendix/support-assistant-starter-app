// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * A chat completions request object.
 */
public class Request implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject requestMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.Request";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		SystemPrompt("SystemPrompt"),
		MaxTokens("MaxTokens"),
		Temperature("Temperature"),
		TopP("TopP"),
		ToolChoice("ToolChoice"),
		Request_Message("GenAICommons.Request_Message"),
		Request_ToolCollection("GenAICommons.Request_ToolCollection"),
		Request_StopSequence("GenAICommons.Request_StopSequence");

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

	public Request(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected Request(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject requestMendixObject)
	{
		if (requestMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, requestMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.requestMendixObject = requestMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.Request initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new genaicommons.proxies.Request(context, mendixObject);
	}

	public static genaicommons.proxies.Request load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.Request.initialize(context, mendixObject);
	}

	/**
	 * @return value of SystemPrompt
	 */
	public final java.lang.String getSystemPrompt()
	{
		return getSystemPrompt(getContext());
	}

	/**
	 * @param context
	 * @return value of SystemPrompt
	 */
	public final java.lang.String getSystemPrompt(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.SystemPrompt.toString());
	}

	/**
	 * Set value of SystemPrompt
	 * @param systemprompt
	 */
	public final void setSystemPrompt(java.lang.String systemprompt)
	{
		setSystemPrompt(getContext(), systemprompt);
	}

	/**
	 * Set value of SystemPrompt
	 * @param context
	 * @param systemprompt
	 */
	public final void setSystemPrompt(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String systemprompt)
	{
		getMendixObject().setValue(context, MemberNames.SystemPrompt.toString(), systemprompt);
	}

	/**
	 * @return value of MaxTokens
	 */
	public final java.lang.Integer getMaxTokens()
	{
		return getMaxTokens(getContext());
	}

	/**
	 * @param context
	 * @return value of MaxTokens
	 */
	public final java.lang.Integer getMaxTokens(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.MaxTokens.toString());
	}

	/**
	 * Set value of MaxTokens
	 * @param maxtokens
	 */
	public final void setMaxTokens(java.lang.Integer maxtokens)
	{
		setMaxTokens(getContext(), maxtokens);
	}

	/**
	 * Set value of MaxTokens
	 * @param context
	 * @param maxtokens
	 */
	public final void setMaxTokens(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer maxtokens)
	{
		getMendixObject().setValue(context, MemberNames.MaxTokens.toString(), maxtokens);
	}

	/**
	 * @return value of Temperature
	 */
	public final java.math.BigDecimal getTemperature()
	{
		return getTemperature(getContext());
	}

	/**
	 * @param context
	 * @return value of Temperature
	 */
	public final java.math.BigDecimal getTemperature(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.Temperature.toString());
	}

	/**
	 * Set value of Temperature
	 * @param temperature
	 */
	public final void setTemperature(java.math.BigDecimal temperature)
	{
		setTemperature(getContext(), temperature);
	}

	/**
	 * Set value of Temperature
	 * @param context
	 * @param temperature
	 */
	public final void setTemperature(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal temperature)
	{
		getMendixObject().setValue(context, MemberNames.Temperature.toString(), temperature);
	}

	/**
	 * @return value of TopP
	 */
	public final java.math.BigDecimal getTopP()
	{
		return getTopP(getContext());
	}

	/**
	 * @param context
	 * @return value of TopP
	 */
	public final java.math.BigDecimal getTopP(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.math.BigDecimal) getMendixObject().getValue(context, MemberNames.TopP.toString());
	}

	/**
	 * Set value of TopP
	 * @param topp
	 */
	public final void setTopP(java.math.BigDecimal topp)
	{
		setTopP(getContext(), topp);
	}

	/**
	 * Set value of TopP
	 * @param context
	 * @param topp
	 */
	public final void setTopP(com.mendix.systemwideinterfaces.core.IContext context, java.math.BigDecimal topp)
	{
		getMendixObject().setValue(context, MemberNames.TopP.toString(), topp);
	}

	/**
	 * Get value of ToolChoice
	 * @param toolchoice
	 */
	public final genaicommons.proxies.ENUM_ToolChoice getToolChoice()
	{
		return getToolChoice(getContext());
	}

	/**
	 * @param context
	 * @return value of ToolChoice
	 */
	public final genaicommons.proxies.ENUM_ToolChoice getToolChoice(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.ToolChoice.toString());
		if (obj == null) {
			return null;
		}
		return genaicommons.proxies.ENUM_ToolChoice.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of ToolChoice
	 * @param toolchoice
	 */
	public final void setToolChoice(genaicommons.proxies.ENUM_ToolChoice toolchoice)
	{
		setToolChoice(getContext(), toolchoice);
	}

	/**
	 * Set value of ToolChoice
	 * @param context
	 * @param toolchoice
	 */
	public final void setToolChoice(com.mendix.systemwideinterfaces.core.IContext context, genaicommons.proxies.ENUM_ToolChoice toolchoice)
	{
		if (toolchoice != null) {
			getMendixObject().setValue(context, MemberNames.ToolChoice.toString(), toolchoice.toString());
		} else {
			getMendixObject().setValue(context, MemberNames.ToolChoice.toString(), null);
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Request_Message
	 */
	public final java.util.List<genaicommons.proxies.Message> getRequest_Message() throws com.mendix.core.CoreException
	{
		return getRequest_Message(getContext());
	}

	/**
	 * @param context
	 * @return value of Request_Message
	 * @throws com.mendix.core.CoreException
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<genaicommons.proxies.Message> getRequest_Message(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<genaicommons.proxies.Message> result = new java.util.ArrayList<>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.Request_Message.toString());
		if (valueObject == null) {
			return result;
		}
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject)) {
			result.add(genaicommons.proxies.Message.initialize(context, mendixObject));
		}
		return result;
	}

	/**
	 * Set value of Request_Message
	 * @param request_message
	 */
	public final void setRequest_Message(java.util.List<genaicommons.proxies.Message> request_message)
	{
		setRequest_Message(getContext(), request_message);
	}

	/**
	 * Set value of Request_Message
	 * @param context
	 * @param request_message
	 */
	public final void setRequest_Message(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<genaicommons.proxies.Message> request_message)
	{
		var identifiers = request_message
			.stream()
			.map(proxyObject -> proxyObject.getMendixObject().getId())
			.collect(java.util.stream.Collectors.toList());
		
		getMendixObject().setValue(context, MemberNames.Request_Message.toString(), identifiers);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Request_ToolCollection
	 */
	public final genaicommons.proxies.ToolCollection getRequest_ToolCollection() throws com.mendix.core.CoreException
	{
		return getRequest_ToolCollection(getContext());
	}

	/**
	 * @param context
	 * @return value of Request_ToolCollection
	 * @throws com.mendix.core.CoreException
	 */
	public final genaicommons.proxies.ToolCollection getRequest_ToolCollection(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		genaicommons.proxies.ToolCollection result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Request_ToolCollection.toString());
		if (identifier != null) {
			result = genaicommons.proxies.ToolCollection.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of Request_ToolCollection
	 * @param request_toolcollection
	 */
	public final void setRequest_ToolCollection(genaicommons.proxies.ToolCollection request_toolcollection)
	{
		setRequest_ToolCollection(getContext(), request_toolcollection);
	}

	/**
	 * Set value of Request_ToolCollection
	 * @param context
	 * @param request_toolcollection
	 */
	public final void setRequest_ToolCollection(com.mendix.systemwideinterfaces.core.IContext context, genaicommons.proxies.ToolCollection request_toolcollection)
	{
		if (request_toolcollection == null) {
			getMendixObject().setValue(context, MemberNames.Request_ToolCollection.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.Request_ToolCollection.toString(), request_toolcollection.getMendixObject().getId());
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Request_StopSequence
	 */
	public final java.util.List<genaicommons.proxies.StopSequence> getRequest_StopSequence() throws com.mendix.core.CoreException
	{
		return getRequest_StopSequence(getContext());
	}

	/**
	 * @param context
	 * @return value of Request_StopSequence
	 * @throws com.mendix.core.CoreException
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<genaicommons.proxies.StopSequence> getRequest_StopSequence(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<genaicommons.proxies.StopSequence> result = new java.util.ArrayList<>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.Request_StopSequence.toString());
		if (valueObject == null) {
			return result;
		}
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject)) {
			result.add(genaicommons.proxies.StopSequence.initialize(context, mendixObject));
		}
		return result;
	}

	/**
	 * Set value of Request_StopSequence
	 * @param request_stopsequence
	 */
	public final void setRequest_StopSequence(java.util.List<genaicommons.proxies.StopSequence> request_stopsequence)
	{
		setRequest_StopSequence(getContext(), request_stopsequence);
	}

	/**
	 * Set value of Request_StopSequence
	 * @param context
	 * @param request_stopsequence
	 */
	public final void setRequest_StopSequence(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<genaicommons.proxies.StopSequence> request_stopsequence)
	{
		var identifiers = request_stopsequence
			.stream()
			.map(proxyObject -> proxyObject.getMendixObject().getId())
			.collect(java.util.stream.Collectors.toList());
		
		getMendixObject().setValue(context, MemberNames.Request_StopSequence.toString(), identifiers);
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return requestMendixObject;
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
			final genaicommons.proxies.Request that = (genaicommons.proxies.Request) obj;
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
