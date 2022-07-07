package com.example.MovieAPI.Repository;

import com.example.MovieAPI.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m where m.title = ?1")
    Optional<Movie> findMovieByTitle(String title);
}
