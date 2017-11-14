package config;

import javax.validation.Valid;

import com.yammer.dropwizard.config.Configuration;

public class ExampleServiceConfiguration extends Configuration{
	
	@Valid //To consider configuration valid, "messages" section should be valid
	private MessagesConfiguration messages;
	
	public MessagesConfiguration getMessages() {
		return messages;
	}
	
	public void setMessages(MessagesConfiguration messages){
		this.messages = messages;
	}

}
