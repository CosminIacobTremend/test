package com.test.repository;

import com.test.model.Genre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

  Optional<Genre> findGenreByGenreNameEquals(String genreName);
}
