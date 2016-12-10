package lethallima.web.controllers;

import lethallima.web.dto.Movie;
import lethallima.web.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by LethalLima on 12/4/16.
 */

@RequestMapping(value = "/movies")
@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }
}
