package com.stephen.resourceservice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class ResourceController {

  @GetMapping("/public")
  public String publicEndpoint() {
    return "PUBLIC endpoint";
  }

  @GetMapping("/me")
  public String meEndpoint(Authentication authentication) {
    String username = authentication.getName();
    String roles = authentication.getAuthorities().stream()
      .map(GrantedAuthority::getAuthority)
      .collect(Collectors.joining(", "));
    return "Hello " + username + ", your roles are: " + roles;
  }

  @GetMapping("/admin")
  public String adminEndpoint() {
    return "ADMIN endpoint";
  }

  @GetMapping("/user")
  public String userEndpoint() {
    return "USER endpoint";
  }

}