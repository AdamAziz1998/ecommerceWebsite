package com.eComm.store.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(info =
@Info(
        title = "Ecommerce website",
        version = "0.0",
        description = "Documentation for the Ecommerce website application",
        contact = @Contact(name = "Adam O'Neill", email = "adamaoneill@gmail.com")
)
)
public class APIDocConfig {
}
