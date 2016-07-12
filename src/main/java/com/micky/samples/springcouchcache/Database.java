package com.micky.samples.springcouchcache;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CustomConversions;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.micky.samples.springcouchcache.data.CustomCouchConverters;

@Configuration
@EnableCaching
@EnableCouchbaseRepositories(basePackages = { "com.micky.samples.springcouchcache.data" })
public class Database extends AbstractCouchbaseConfiguration {

	@Value("${couch.hostname}")
	private String hostname;

	@Value("${couch.bucket}")
	private String mainBucket;

	@Value("${couch.password}")
	private String password;


	@Override
	protected String getBucketName() {
		return mainBucket;
	}

	@Override
	protected String getBucketPassword() {
		return password;
	}

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList(hostname);
	}
	
	
	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(CustomCouchConverters.getConvertersToRegister());
	}
	
}
