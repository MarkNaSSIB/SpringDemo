package com.NaSSIB.spring.SpringDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

// entity class maps to database table
@Entity
public class Films {

  @Id
  private Integer id;

  private String filmTitle;
  private Integer runTime;
  private String releaseDate;
  private String filmCreator;

  @Override
  public String toString() {
    // return "[Film Title: " + filmTitle + ", release date: " + releaseDate + ", id: " + id + "]";
    return "[Film Title: " + filmTitle + ", by: " + filmCreator + "]";
  }

  public String toShortString() {
    return "[Film Title: " + filmTitle + ", by: " + filmCreator + "]";

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFilmTitle() {
    return filmTitle;
  }

  public void setFilmTitle(String filmTitle) {
    this.filmTitle = filmTitle;
  }

  public Integer getRunTime() {
    return runTime;
  }

  public void setRunTime(Integer runTime) {
    this.runTime = runTime;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getFilmCreator() {
    return filmCreator;
  }

  public void setFilmCreator(String filmCreator) {
    this.filmCreator = filmCreator;
  }
}
