package mx.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(final UserRepository repository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.err.println(repository.findAll());
			}

		};
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public ObjectMapper jacksonObjectMapper() {
	    return new ObjectMapper().setPropertyNamingStrategy(
	            PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}
	
}
