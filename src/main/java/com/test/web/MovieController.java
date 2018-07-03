package com.test.web;

import com.test.conf.UserDetailsImpl;
import com.test.dto.Response;
import com.test.model.Movie;
import com.test.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

  @Autowired
  private MovieService movieService;

  @RequestMapping(path = "/movies", method = RequestMethod.GET)
  public Response<Movie> getMovies(
      @RequestParam(name = "movie_name", required = false) String movieNameLike,
      @RequestParam(name = "genre", required = false) String genreName,
      @AuthenticationPrincipal UserDetailsImpl user) {

    return movieService.getMoviesByNameAndGenre(movieNameLike, genreName);
  }

}
