package org.james.test.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (propertyName.equalsIgnoreCase("test.content")) {
			System.out.println("当前即将过滤的内容[" + propertyName + "]=[" + propertyValue + "]");
			propertyValue = propertyValue + "加密";
		}

		return super.convertProperty(propertyName, propertyValue);
	}

}
