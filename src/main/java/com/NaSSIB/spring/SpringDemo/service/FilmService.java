package com.NaSSIB.spring.SpringDemo.service;

import java.util.List;
import java.util.Optional;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.model.Viewers;

public interface FilmService {

  Iterable<Films> getFilms();

  Iterable<Films> getFilmsByTitle(String filmTitle);

  Iterable<Films> getFilmsByCreator(String filmMaker);

  void addFilm(Films f);

  Optional<Films> getAFilm(int identity);

  List<Viewers> getViewers();
}
