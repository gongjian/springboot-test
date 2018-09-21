package org.james.test.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@PropertySource(value = { "application.properties"}	)
@ConfigurationProperties(prefix="test")
public class PropertiesConfig {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
