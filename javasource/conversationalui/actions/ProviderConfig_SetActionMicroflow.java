// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package conversationalui.actions;

import static java.util.Objects.requireNonNull;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import conversationalui.impl.MxLogger;
import conversationalui.impl.ProviderConfigImpl;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * ProviderConfig_SetActionMicroflow can be used to set a custom ActionMicroflow for your ProviderConfig that will be executed once a new message is sent.
 * The ActionMicroflow is expected to have an Input of ConversationalUI.ChatContext and returns a Boolean.
 */
public class ProviderConfig_SetActionMicroflow extends CustomJavaAction<java.lang.Void>
{
	/** @deprecated use ProviderConfig.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __ProviderConfig;
	private final conversationalui.proxies.ProviderConfig ProviderConfig;
	private final java.lang.String ActionMicroflow;

	public ProviderConfig_SetActionMicroflow(
		IContext context,
		IMendixObject _providerConfig,
		java.lang.String _actionMicroflow
	)
	{
		super(context);
		this.__ProviderConfig = _providerConfig;
		this.ProviderConfig = _providerConfig == null ? null : conversationalui.proxies.ProviderConfig.initialize(getContext(), _providerConfig);
		this.ActionMicroflow = _actionMicroflow;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE

		try {
			requireNonNull(ProviderConfig, "ProviderConfig is required.");
			requireNonNull(ActionMicroflow, "ActionMicroflow is required.");
			ProviderConfigImpl.validateActionMicroflow(ActionMicroflow);
			
			ProviderConfig.setActionMicroflow(ActionMicroflow);	
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
		return "ProviderConfig_SetActionMicroflow";
	}

	// BEGIN EXTRA CODE
	
	private static final MxLogger LOGGER = new MxLogger(ProviderConfig_SetActionMicroflow.class);
	
	// END EXTRA CODE
}
