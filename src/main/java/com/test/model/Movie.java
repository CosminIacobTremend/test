package com.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "movie")
public class Movie implements Serializable  {

  public Movie() {
    this.genres = new ArrayList<>();
    this.awards = new ArrayList<>();
    this.actors = new ArrayList<>();
  }

  @Id
  @Column(name = "movie_id")
  private Long movieId;
  @Column(name = "movie_name")
  private String movieName;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "movies_actors",
      joinColumns = { @JoinColumn(name = "movie_id") },
      inverseJoinColumns = { @JoinColumn(name = "actor_id") }
  )
  @JsonIgnoreProperties("movies")
  List<Actor> actors;

  @ManyToOne
  @JoinColumn(name = "director_id")
  @JsonBackReference
  public Director director;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "movies_genres",
      joinColumns = { @JoinColumn(name = "movie_id") },
      inverseJoinColumns = { @JoinColumn(name = "genre_id") }
  )
  @JsonIgnoreProperties("movies")
  List<Genre> genres;

  @OneToMany(mappedBy = "movie")
  @JsonManagedReference
  private List<Award> awards;



}
