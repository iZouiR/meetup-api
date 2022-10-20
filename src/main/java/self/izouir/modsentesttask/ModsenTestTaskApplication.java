package self.izouir.modsentesttask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Meetup API", version = "1.0", description = "Modsen Test Task API"))
public class ModsenTestTaskApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ModsenTestTaskApplication.class, args);
    }

}
