package com.example.MovieAPI.Model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    Integer rating;
    LocalDate releaseDate;

    public Movie() {
    }

    public Movie(Long id, String title, Integer rating, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public Movie(String title, Integer rating, LocalDate releaseDate) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
