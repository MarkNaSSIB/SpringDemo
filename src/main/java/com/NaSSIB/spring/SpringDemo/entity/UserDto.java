package com.NaSSIB.spring.SpringDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class UserDto {

  @NonNull
  @Column
  private String firstName;

  @NonNull
  @Column
  private String lastName;

  @NonNull
  @Column
  private String password;

  private String matchingPassword;

  @Column
  @NonNull
  private String email;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMatchingPassword() {
    return matchingPassword;
  }

  public void setMatchingPassword(String matchingPassword) {
    this.matchingPassword = matchingPassword;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // standard getters and setters
}
