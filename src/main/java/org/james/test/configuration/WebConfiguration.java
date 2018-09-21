package org.james.test.configuration;

import org.james.test.filter.HttpServletRequestReplacedFilter;
import org.james.test.interceptor.CustomHandlerInterceptor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.addUrlPatterns("/oo/xx/*");
		filter.setFilter(new HttpServletRequestReplacedFilter());

		return filter;
	}

	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer placeholderConfigurer = new MyPropertyPlaceholderConfigurer();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:application.properties");
		placeholderConfigurer.setLocation(resource);
		
		return placeholderConfigurer;
	}

}
