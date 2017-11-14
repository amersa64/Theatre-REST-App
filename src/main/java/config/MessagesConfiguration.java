package config;

import javax.validation.constraints.NotNull;

public class MessagesConfiguration {
	
	@NotNull //From @Valid, to consider configuration valid, hello should not be null
	private String hello;
	
	public String getHello() {
		return hello;
	}
	
	public void setHello(String hello) {
		this.hello = hello;
	}

}
