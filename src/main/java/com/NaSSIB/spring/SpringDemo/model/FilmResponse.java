package com.NaSSIB.spring.SpringDemo.model;

import java.util.List;
import com.NaSSIB.spring.SpringDemo.entity.Films;

public class FilmResponse {

  List<Films> filmList;

  public List<Films> getFilmList() {
    return filmList;
  }

  public void setFilmList(List<Films> filmList) {
    this.filmList = filmList;
  }

  @Override
  public String toString() {
    return "FilmResponse [filmList=" + filmList + ", toString()=" + super.toString() + "]";
  }

}
