package com.example.MovieAPI.Config;

import com.example.MovieAPI.Model.Movie;
import com.example.MovieAPI.Repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner (MovieRepository movieRepository){

        return  args -> {
            Movie Interstellar = new Movie(
                    "interstellar",
                    9,
                    LocalDate.of(2014, Month.MARCH,18)
            );

            Movie Dunkirk = new Movie(
                    "Dunkirk",
                    8,
                    LocalDate.of(2017, Month.AUGUST,20)
            );

            movieRepository.saveAll(List.of(Interstellar,Dunkirk));

        };


    }
}
