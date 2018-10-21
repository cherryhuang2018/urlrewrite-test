package com.kcc;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

public class UrlRewriteFilterConfig extends UrlRewriteFilter {

	private Resource resource;

	public UrlRewriteFilterConfig(Resource config) {
		this.resource = config;
	}

	protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
		try {
			Conf conf = new Conf(filterConfig.getServletContext(), resource.getInputStream(), resource.getFilename(),
					"");
			checkConf(conf);
		} catch (IOException ex) {
			throw new ServletException("Unable to load URL rewrite configuration file from " + this.resource, ex);
		}
	}
}
