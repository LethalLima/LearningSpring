package lethallima.web.services;

import lethallima.web.dto.Movie;

import java.util.Collection;

/**
 * Created by LethalLima on 12/4/16.
 */
public interface MovieService {

    Collection<Movie> getAllMovies();

    Movie getMovieById(int id);
}
