package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Gateway {
	public static void main(String[] args) {
		SpringApplication.run(Gateway.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(
			RouteLocatorBuilder builder,
			@Value("${bookshop.service.url}") String authorServiceUrl,
			@Value("${book.service.url}") String bookServiceUrl
	) {
		return builder.routes()
				.route("authors-route", route -> route
						.path("/api/bookshops/**")
						.uri(authorServiceUrl) 
				)
				// Route for Books
				.route("books-route", route -> route
						.path("/api/books/**")  // Match `/api/books` and `/api/books/{id}`
						.uri(bookServiceUrl)   // Forward to the Book service
				)
				.build();
	}
}
