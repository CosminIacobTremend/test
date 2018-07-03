package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity(name = "genre")
@Data
public class Genre implements Serializable {

  public Genre() {
    this.movies = new HashSet<>();
  }

  @Id
  @Column(name = "genre_id")
  private Long genreId;
  @Column(name = "genre_name", unique = true)
  private String genreName;

  @ManyToMany(mappedBy = "genres")
  @JsonIgnoreProperties("genres")
  private Set<Movie> movies;
}
