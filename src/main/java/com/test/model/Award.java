package com.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "award")
public class Award implements Serializable {

  @Id
  @Column(name = "award_id")
  private Long awardId;

  @Column(name = "award_name")
  private String awardName;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  @JsonBackReference
  private Movie movie;
}
