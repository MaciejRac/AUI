package pl.gda.jp.rdl.categories_bookshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CategoriesBookshopsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CategoriesBookshopsApplication.class, args);
		System.out.println("Categories application working");
	}
	@Bean
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}
}
