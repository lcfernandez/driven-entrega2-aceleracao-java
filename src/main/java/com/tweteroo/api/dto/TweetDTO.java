package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
  @NotNull(message = "userId is mandatory!")
  private Long userId;

  @NotBlank(message = "text is mandatory!")
  @Size(max = 280, message = "Maximun length for text is 280 characters!")
  private String text;
}
