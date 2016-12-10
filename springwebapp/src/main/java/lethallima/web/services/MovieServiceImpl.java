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

/**
 * Created by LethalLima on 12/4/16.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Collection<Movie> getAllMovies() {
        ResponseEntity<Resources<Movie>> responseEntity = restTemplate
                .exchange("http://localhost:8081/movies", HttpMethod.GET,
                        null, new ParameterizedTypeReference<Resources<Movie>>() {});

        return responseEntity.getBody().getContent();
    }

    @Override
    public Movie getMovieById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8081/movies/{id}", Movie.class, id);
    }

}
