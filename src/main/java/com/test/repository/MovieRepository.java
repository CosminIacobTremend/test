package com.test.repository;

import com.test.model.Genre;
import com.test.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  List<Movie> findMoviesByMovieNameContaining(String movieNameLike);
  List<Movie> findMoviesByGenresContaining(Genre genre);
  List<Movie> findMoviesByMovieNameContainingAndGenresContains(String movieNameLike, Genre genre);



}
