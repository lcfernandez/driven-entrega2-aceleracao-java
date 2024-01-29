package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
  @NotBlank(message = "username is mandatory!")
  @Size(max = 100, message = "Maximum length for username is 100 characters!")
  private String username;

  @NotBlank(message = "avatar is mandatory!")
  private String avatar;
}
