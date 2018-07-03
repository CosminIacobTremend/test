package com.test.service;

import com.test.dto.Response;
import com.test.exception.BadRequestException;
import com.test.exception.ExpectationFailedException;
import com.test.model.Genre;
import com.test.model.Movie;
import com.test.repository.GenreRepository;
import com.test.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private GenreRepository genreRepository;

  @Transactional
  public Response<Movie> getMoviesByNameAndGenre(String movieNameLike, String genreName) {

    if (StringUtils.isEmpty(movieNameLike) && StringUtils.isEmpty(genreName)) {
      throw  new BadRequestException(400, "At least one parameter should be not null");
    }
    List<Movie> movies;
    Genre genre = null;
    if (!StringUtils.isEmpty(genreName)) {
      genre = genreRepository.findGenreByGenreNameEquals(genreName).orElseThrow(() ->
        new ExpectationFailedException(400, "Invalid Genre Name"));
    }
    if (genre == null) {
      movies = movieRepository.findMoviesByMovieNameContaining(movieNameLike);
    } else {
      if (StringUtils.isEmpty(movieNameLike)) {
        movies = movieRepository.findMoviesByGenresContaining(genre);
      } else {
        movies =  movieRepository.findMoviesByMovieNameContainingAndGenresContains(movieNameLike, genre);
      }
    }

    Response<Movie> response = Response.okResponse();
    response.setData(new ArrayList<>(movies));
    response.setRecordsTotal(movies.size());
    return  response;
  }
}
