package com.skipthedishes.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SkipthedishesChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkipthedishesChallengeApplication.class, args);
	}
}
