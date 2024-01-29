package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.repositories.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {
  final TweetRepository tweetRepository;

  TweetController(TweetRepository tweetRepository) {
    this.tweetRepository = tweetRepository;
  }
  
  @GetMapping
  public String getTweets() {
    return "Tweets";
  }
  
  @GetMapping("/user/{id}")
  public String getTweetsByUserId(@PathVariable("id") Long id) {
    return "Tweets - User " + id;
  }

  @PostMapping
  public void createTweet(@RequestBody String body) {
    System.out.println(body);
  }
}
