package com.zuehlke;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieTicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketServiceApplication.class, args);
	}

	@Bean
	public MovieServiceAdapter movieServiceAdapter(@Value("${endpoint.movie-service}") String url) {
		return new MovieServiceAdapter(url);
	}

	@Bean
	public RatingAdapter ratingAdapter(@Value("${endpoint.movie-rating-service}") String url) {
		return new RatingAdapter(url);
	}
}


