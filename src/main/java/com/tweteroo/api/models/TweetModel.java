package com.tweteroo.api.models;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tweets")
public class TweetModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 280, nullable = false)
  private String text;

  @ManyToOne
  @JoinColumn(name = "userId")
  private UserModel user;

  public TweetModel(TweetDTO dto) {
    this.text = dto.getText();
  }

  public TweetModel(TweetDTO dto, UserModel user) {
    this.text = dto.getText();
    this.user = user;
  }
}
