package com.example.MovieAPI.Service;

import com.example.MovieAPI.Model.Movie;
import com.example.MovieAPI.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository repo;

    @Autowired
    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    // GET ALL MOVIES
    public List<Movie> getAllMovies(){
        return repo.findAll();
    }


    public void postMovie(Movie movie) {

        Optional<Movie> movieOptional = repo.findMovieByTitle(movie.getTitle());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("Movie by the title " + movie.getTitle() + " is alredy Present!");
        } else {
            repo.save(movie);
            System.out.println("Movie " + movie.getTitle() + " is saved successfully");
        }

    }


    @Transactional

    public void updateMovie(Long id, String title, Integer rating) {
        Optional<Movie> movieOptional = repo.findById(id);
        if(movieOptional.isEmpty()){
            throw new IllegalStateException("movie with ID " + id + " is not present!");
        } else {
            Movie movie = movieOptional.get();
            if(title!=null && title.length()>0){
                movie.setTitle(title);
                System.out.println("Title updated");
            }

            if(rating!=null && rating>0){
                movie.setRating(rating);
                System.out.println("Rating updated");
            }

        }

    }

    public void deleteMovie(Long id) {

        Optional<Movie> movieOptional = repo.findById(id);
        if(movieOptional.isEmpty()){
            throw new IllegalStateException("movie with ID " + id + " does not exist!");
        } else {
            repo.deleteById(id);
            System.out.println("movie with ID " + id + " successfully deleted!");
        }
    }
}
