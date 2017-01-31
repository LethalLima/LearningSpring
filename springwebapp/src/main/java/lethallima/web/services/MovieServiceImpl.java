package lethallima.web.services;

import lethallima.web.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LethalLima on 12/4/16.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private RestTemplate restTemplate;

    private final static String moviesURL = "http://localhost:8081/movies";

    @Override
    public Collection<Movie> getAllMovies() {
        ResponseEntity<Resources<Movie>> responseEntity = restTemplate
                .exchange(moviesURL, HttpMethod.GET,
                        null, new ParameterizedTypeReference<Resources<Movie>>() {});

        return responseEntity.getBody().getContent();
    }

    @Override
    public Movie getMovieById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject("http://localhost:8081/movies/{id}", Movie.class, id);
    }

}
