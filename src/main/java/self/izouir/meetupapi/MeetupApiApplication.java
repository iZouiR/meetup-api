package self.izouir.meetupapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Meetup API", version = "1.0"))
public class MeetupApiApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MeetupApiApplication.class, args);
    }

}
