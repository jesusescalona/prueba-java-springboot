package com.prueba.spring.security.login.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prueba.spring.security.login.models.Phone;
import com.prueba.spring.security.login.models.User;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String name;

  private String email;

  @JsonIgnore
  private String password;

  private Collection<Phone> phones;
  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(
      Long id,
      String username,
      String name,
      String email,
      String password,
      Collection<Phone> phones,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
    this.authorities = authorities;
  }

  public UserDetailsImpl(
      Long id2,
      String username2,
      String name2,
      String email2,
      String password2,
      List<Phone> phones2,
      List<? extends GrantedAuthority> authorities2) {
    this.id = id2;
    this.username = username2;
    this.name = name2;
    this.email = email2;
    this.password = password2;
    this.phones = phones2;
    this.authorities = authorities2;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),
        user.getUsername(),
        user.getName(),
        user.getEmail(),
        user.getPassword(),
        user.getPhones(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getName() {
    return name;
  }

  public Collection<Phone> getPhones() {
    return phones;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
