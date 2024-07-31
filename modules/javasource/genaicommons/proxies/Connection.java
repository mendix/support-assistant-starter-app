// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package genaicommons.proxies;

/**
 * The Connection entitiy is a required input parameter for all operations.
 */
public class Connection implements com.mendix.systemwideinterfaces.core.IEntityProxy
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject connectionMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "GenAICommons.Connection";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Model("Model");

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

	public Connection(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected Connection(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject connectionMendixObject)
	{
		if (connectionMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, connectionMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.connectionMendixObject = connectionMendixObject;
		this.context = context;
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static genaicommons.proxies.Connection initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		if (com.mendix.core.Core.isSubClassOf("AmazonBedrockConnector.AmazonBedrockConnection", mendixObject.getType())) {
			return amazonbedrockconnector.proxies.AmazonBedrockConnection.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("OpenAIConnector.OpenAIConnection", mendixObject.getType())) {
			return openaiconnector.proxies.OpenAIConnection.initialize(context, mendixObject);
		}
		if (com.mendix.core.Core.isSubClassOf("PgVectorKnowledgeBase.PgVectorKnowledgeBaseConnection", mendixObject.getType())) {
			return pgvectorknowledgebase.proxies.PgVectorKnowledgeBaseConnection.initialize(context, mendixObject);
		}
		return new genaicommons.proxies.Connection(context, mendixObject);
	}

	public static genaicommons.proxies.Connection load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return genaicommons.proxies.Connection.initialize(context, mendixObject);
	}

	/**
	 * @return value of Model
	 */
	public final java.lang.String getModel()
	{
		return getModel(getContext());
	}

	/**
	 * @param context
	 * @return value of Model
	 */
	public final java.lang.String getModel(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Model.toString());
	}

	/**
	 * Set value of Model
	 * @param model
	 */
	public final void setModel(java.lang.String model)
	{
		setModel(getContext(), model);
	}

	/**
	 * Set value of Model
	 * @param context
	 * @param model
	 */
	public final void setModel(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String model)
	{
		getMendixObject().setValue(context, MemberNames.Model.toString(), model);
	}

	@java.lang.Override
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return connectionMendixObject;
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
			final genaicommons.proxies.Connection that = (genaicommons.proxies.Connection) obj;
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
