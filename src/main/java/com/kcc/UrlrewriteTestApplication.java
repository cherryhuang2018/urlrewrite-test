package com.kcc;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class UrlrewriteTestApplication {

	public static final String REWRITE_FILTER_CONF_PATH = "urlrewrite.xml";

	public static void main(String[] args) {
		SpringApplication.run(UrlrewriteTestApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setContextPath("/ta");
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
		mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
		mapper.setTimeZone(mapper.getSerializationConfig().getDateFormat().getTimeZone());
		return mapper;
	}

	@Bean
	public FilterRegistrationBean<UrlRewriteFilter> rewriteFilterConfig() {
		FilterRegistrationBean<UrlRewriteFilter> registration = new FilterRegistrationBean<>();
		registration.setName("UrlRewriteFilter");

		UrlRewriteFilter overwriteFilter = new UrlRewriteFilterConfig(new ClassPathResource(REWRITE_FILTER_CONF_PATH));
		registration.setFilter(overwriteFilter);

		registration.addInitParameter("confReloadCheckInterval", "-1");
		registration.addInitParameter("statusPath", "/redirect");
		registration.addInitParameter("statusEnabledOnHosts", "*");
		registration.addInitParameter("logLevel", "DEBUG");
		return registration;
	}
}
