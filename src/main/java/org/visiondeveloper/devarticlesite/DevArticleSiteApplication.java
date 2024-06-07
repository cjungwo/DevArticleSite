package org.visiondeveloper.devarticlesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DevArticleSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevArticleSiteApplication.class, args);
	}

}
