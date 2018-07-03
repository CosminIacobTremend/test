package com.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.Data;

@Entity(name = "api_usage")
@Data
public class ApiUsage {

  @Id
  @Column(name = "api_usage_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "API_SEQ")
  @SequenceGenerator(name = "API_SEQ", sequenceName = "SEQUENCE_API")
  private Long apiUsageId;

  private Timestamp timestamp;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

}
