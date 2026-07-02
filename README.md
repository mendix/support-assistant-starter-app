## Introduction

This starter app contains [Agent Commons](https://marketplace.mendix.com/link/component/240371) and all other dependencies needed to create agents. It is set up with a Support Agent template to show how it works. It allows developers and prompt engineers to collaborate and build agentic systems.
 

## First-time Support Agent setup
To experience full functionality using Mendix Cloud GenAI resources, you need to obtain and import [keys for Mendix Cloud GenAI resources](http://genai.home.mendix.com/) (Text Generation model and a Knowledge base).

For (Azure) OpenAI and Amazon Bedrock text generation & embeddings models, you can hook up a [PostgreSQL database as a knowledge base](https://docs.mendix.com/appstore/modules/genai/pgvector-setup/) using the included PgVectorKnowledgeBase module.


### 1a. Configure the LLM
Make sure the encryption key is set, run the app & login as an administrator.

To use Mendix Cloud GenAI you need to obtain and import [keys for Mendix Cloud GenAI resources](http://genai.home.mendix.com/). You will need to import two key, one for a text generation resource and one for a knowledge base.

To use Amazon Bedrock models, configure your credentials (see [AWS Authentication](https://docs.mendix.com/appstore/modules/aws/aws-authentication/)) before starting the application. Only the AWS region and whether to use static credentials can be selected at runtime (check out which models are available in which region, see [AWS Model Support](https://docs.aws.amazon.com/bedrock/latest/userguide/models-regions.html)).

To use (Azure) OpenAI models, configure access to OpenAI or Azure OpenAI at runtime (see [OpenAI Configuration](https://docs.mendix.com/appstore/modules/genai/reference-guide/external-connectors/openai/#configuration) for details).

You can also configure [Mistral](https://docs.mendix.com/appstore/modules/genai/reference-guide/external-connectors/mistral/#mistral-configuration) or [Google Gemini](https://docs.mendix.com/appstore/modules/genai/reference-guide/external-connectors/gemini/#gemini-configuration) models.

 
### 1b. Configure the PgVector Knowledge Base (optional, but recommended for Amazon Bedrock or (Azure) OpenAI models)
To experience the full set of the GenAI functionalities that are currently possible in a Mendix app, connecting to a knowledge base is needed. If you use Mendix Cloud, this is part of 1a.

For (Azure) OpenAI and Amazon Bedrock, the connection to your PostgreSQL server needs to be configured at runtime, for more information, see [PgVector Knowledge Base](https://docs.mendix.com/appstore/modules/genai/pgvector/).

### 2. Configure the App settings (optional, but recommended)
In the app settings, you can select which knowledge base (configured in step 1a (Mendix Cloud) or 1b (PgVector)) to use within in the app.

### 3. Agent configuration
The app contains a pre-configured support agent. Click on the in-use version in the version dropdown and select a text generation model from step 1a, you want to use. You can also create make changes to your agent by creating a new version. In order for the version to be used in the app, you need to [set it as in-use](https://docs.mendix.com/appstore/modules/genai/genai-for-mx/agent-commons/#creating-a-version).

### 4. Populate the Knowledge Base
This is a one-time manual initialization action that must be executed, if applicable, after the knowledge base has been configured in steps 2 and 3. That way the knowledge base is in sync with the Mendix app data and the support agent can search through historical tickets and reference guides.

### 5. Defining new Agents

1. Use the demo user switcher to login as demo_administrator.
2. On the Admin homepage, go to Agent configuration.
3. Create and edit agents at runtime. Write the prompts, use variable placeholders, add microflows as tools and connect knowledge bases to define the tasks and capabilities of the agents.
4. Configure the deployed model (LLM) that the agent should use and connect the agent to it.
5. Create various versions of the agents and test in an isolated setup to rapidly iterate, compare and evaluate the agentic behavior
6. Set a version as "in use" to allow it to be called from the actual logic in the app.
7. Use the user switcher to login as a demo_user account and try out the agent in the app!
8. Monitor your token consumption or comprehend AI traces with the demo_administrator role.
