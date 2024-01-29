package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {
  final TweetRepository tweetRepository;

  TweetController(TweetRepository tweetRepository) {
    this.tweetRepository = tweetRepository;
  }

  @GetMapping
  public ResponseEntity<Object> getTweets() {
    List<TweetModel> tweets = tweetRepository.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(tweets);
  }
  
  @GetMapping("/user/{id}")
  public String getTweetsByUserId(@PathVariable("id") Long id) {
    return "Tweets - User " + id;
  }
  // public List<TweetModel> getTweetsByUserId(@PathVariable("id") Long id) {
  //   return tweetRepository...;
  // }

  @PostMapping
  public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
    TweetModel tweet = new TweetModel(body);
    tweetRepository.save(tweet);
    return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
  }
}
