package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "actors")
public class Actor implements Serializable {

  public Actor() {
    this.movies = new ArrayList<>();
  }

  @Id
  @Column(name = "actor_id")
  private Long actorId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @ManyToMany(mappedBy = "actors")
  @JsonIgnoreProperties("actors")
  private List<Movie> movies;
}
