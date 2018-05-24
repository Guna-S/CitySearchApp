package com.hid.citysearch;

import com.hid.citysearch.domain.City;
import com.hid.citysearch.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class CitySearchAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CitySearchAppApplication.class, args);
	}


	@Autowired
	private CityRepository cityRepository;

	@Resource
	@Value("${city.input}")
	private org.springframework.core.io.Resource resource;

	@Override
	public void run(final String... args) throws Exception {

		Files
				.readAllLines(Paths.get(resource.getURI()), StandardCharsets.UTF_8)
				.stream()
				.map(name -> City.builder().name(name).build())
				.forEach(cityRepository::save);
	}
}
