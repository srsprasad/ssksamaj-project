package org.ssksamaj.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.ssksamaj.app"})
@EnableJpaRepositories(basePackages = "org.ssksamaj.app.persist")
public class SSKSamajApplicationStarter {
	private static final Logger LOG = LoggerFactory.getLogger(SSKSamajApplicationStarter.class);

	public static void main(String[] args) {
		SpringApplication.run(SSKSamajApplicationStarter.class);
		LOG.info("SSKSamaj Application API's...ready to use");
	}

}
