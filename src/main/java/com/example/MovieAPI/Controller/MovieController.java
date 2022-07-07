package com.example.MovieAPI.Controller;

import com.example.MovieAPI.Model.Movie;
import com.example.MovieAPI.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("/addMovie")
    public void postMovie(@RequestBody Movie movie){
        movieService.postMovie(movie);
    }

    @PutMapping("/updateMovie/{movieID}")
    public void updateMovie(@PathVariable("movieID") Long id,
                            @RequestParam(required = false) String title,
                            @RequestParam(required = false) Integer rating){
        movieService.updateMovie(id,title,rating);
    }

    @DeleteMapping("/deleteMovie/{movieID}")
    public void deleteMovie(@PathVariable("movieID") Long id){
        movieService.deleteMovie(id);
    }
}
