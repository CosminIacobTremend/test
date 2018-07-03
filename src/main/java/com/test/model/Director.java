package com.test.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity(name = "director")
@Data
public class Director implements Serializable {

  public Director() {
    this.movies = new ArrayList<>();
  }

  @Id
  @Column(name = "director_id")
  private Long directorId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

  @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Movie> movies;


}
