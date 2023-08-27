package com.archneo.ecommerce.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                description = "ECommerce API Description",
                version = "v1.0.0",
                title = "ECommerce API",
                contact = @Contact(
                        name = "Shubhanjan Banerjee",
                        email = "shubhanjan.banerjee@cognizant.com",
                        url = "https://www.cognizant.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {@Server(url = "https://www.cognizant.com")}
)
public interface ApiDocumentationConfig {

}