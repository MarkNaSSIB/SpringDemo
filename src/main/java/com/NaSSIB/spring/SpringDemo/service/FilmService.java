package com.NaSSIB.spring.SpringDemo.service;

import java.util.Optional;
import com.NaSSIB.spring.SpringDemo.entity.Films;

public interface FilmService {

  Iterable<Films> getFilms();

  Iterable<Films> getFilmsByTitle(String filmTitle);

  Iterable<Films> getFilmsByCreator(String filmMaker);

  void addFilm(Films f);

  Optional<Films> getAFilm(int identity);

  void delete(Integer identity);

  void updateFilm(Films existFilm);

}
