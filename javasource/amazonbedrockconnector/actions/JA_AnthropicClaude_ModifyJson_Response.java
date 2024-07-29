// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package amazonbedrockconnector.actions;

import static java.util.Objects.requireNonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import amazonbedrockconnector.impl.MxLogger;

public class JA_AnthropicClaude_ModifyJson_Response extends CustomJavaAction<java.lang.String>
{
	private final java.lang.String ResponseBody_ToBeModified;

	public JA_AnthropicClaude_ModifyJson_Response(
		IContext context,
		java.lang.String _responseBody_ToBeModified
	)
	{
		super(context);
		this.ResponseBody_ToBeModified = _responseBody_ToBeModified;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			requireNonNull(this.ResponseBody_ToBeModified, "ResponseBody String is required");
			
			// Full response body as received from claude
			ObjectNode root = (ObjectNode) MAPPER.readTree(ResponseBody_ToBeModified);
			
			if (root.has("content")) {
				
				// content node
				ArrayNode contentNode = (ArrayNode) root.get("content");
				
				// Create a Map to separate the text responses from the tool_use response
				Map<String, List<JsonNode>> responseNodeMap = getResponseMap(contentNode);
				
				// Check if any tool_use was returned
				// If not, no modification is needed
				// if yes, clear content node and build it again in the correct structure for the mapping
				List<JsonNode> toolUseList = responseNodeMap.get("tool_use");
				if (toolUseList.size() > 0) {
					// Clear the content node
					contentNode.removeAll();
					
					// Get object with tool_uses in right format for import mapping
					// If also text is returned, it must be written to the content attribute of the message
					ObjectNode toolUseResponseNode = getToolUseResponseNode(toolUseList, responseNodeMap.get("text"));
					//append to content node
					contentNode.add(toolUseResponseNode);
				}

			}
			
			
			return MAPPER.writeValueAsString(root);
			
			
		} catch (Exception e) {
			LOGGER.error("Error occurred while modifying Claude response body: " + e.getMessage());
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
		return "JA_AnthropicClaude_ModifyJson_Response";
	}

	// BEGIN EXTRA CODE
	private static final MxLogger LOGGER = new MxLogger(JA_AnthropicClaude_ModifyJson_Response.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private Map<String, List<JsonNode>> getResponseMap(ArrayNode contentNode) {
		List<JsonNode> toolUseList = new ArrayList<>();
		List<JsonNode> textList = new ArrayList<>();
		Map<String, List<JsonNode>> responseNodeMap = new HashMap<>();
		for (JsonNode content : contentNode) {
			String type = content.get("type").asText();
			if (type.equals("tool_use")) {
				toolUseList.add(content);
			}
			if (type.equals("text")) {
				textList.add(content);
			}
		}
		
		responseNodeMap.put("text", textList);
		responseNodeMap.put("tool_use", toolUseList);
		
		return responseNodeMap;
	}
	
	private ObjectNode getToolUseResponseNode(List<JsonNode> toolUseList, List<JsonNode> textList) {
		ObjectNode toolUseResponseNode = MAPPER.createObjectNode();
		toolUseResponseNode.put("type", "text");
		
		// If present, creating contentString from text response to add to content attribute
		if (textList.size() > 0) {
			String contentString = getContentString(textList);
			toolUseResponseNode.put("text", contentString);
		}
		
		// Getting array with tool_uses in the expected format for GenAI commons mapping
		ArrayNode toolUsesNode = getToolUsesNode(toolUseList);
		toolUseResponseNode.set("toolCall", toolUsesNode);
		
		return toolUseResponseNode;
	}
	
	private String getContentString(List<JsonNode> textList) {
		String contentString = "";
		for (JsonNode text : textList) {
			String textContent = text.get("text").asText();
			contentString = String.format("%s %s", contentString, textContent);
		}
		
		return contentString;
		
	}
	
	private ArrayNode getToolUsesNode(List<JsonNode> toolUseList) {
		ArrayNode toolUsesNode = MAPPER.createArrayNode();
		toolUseList.forEach(toolUse -> {
			ObjectNode toolUseNode = MAPPER.createObjectNode();
			toolUseNode.put("name", toolUse.get("name").asText());
			toolUseNode.put("id", toolUse.get("id").asText());
			
			String arguments = toolUse.get("input").toString();
			toolUseNode.put("arguments", arguments);
			
			toolUsesNode.add(toolUseNode);
		});
		
		return toolUsesNode;
	}
	
	// END EXTRA CODE
}
