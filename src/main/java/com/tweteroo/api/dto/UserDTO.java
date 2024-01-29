package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
  @NotBlank
  @Size(max = 100, message = "Maximum length for username is 100 characters!")
  private String username;

  @NotBlank
  private String avatar;
}
