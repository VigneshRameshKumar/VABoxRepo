package com.jetbrains.marco.photozclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jetbrains.marco.photozclone"})
public class PhotozCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotozCloneApplication.class, args);
	}

}
