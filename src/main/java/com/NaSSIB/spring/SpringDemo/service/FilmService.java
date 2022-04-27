package com.NaSSIB.spring.SpringDemo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.repo.IFilmsRepo;

@Service
public class FilmService {

  @Autowired
  IFilmsRepo filmsRepo;

  // get all films
  public Iterable<Films> getFilms() {
    return filmsRepo.findAll();
  }

  // get films with matching filmCreator
  public Iterable<Films> getFilmsByCreator(String filmMaker) {
    return filmsRepo.findByFilmCreator(filmMaker);
  }

  // get film by id
  public Optional<Films> getAFilm(int identity) {
    // match request id to set of films

    Optional<Films> film1 = filmsRepo.findById(Integer.valueOf(identity));

    if (film1.isPresent()) {
      // System.out.println(film1.toString()); //for debugging
      return film1;
    } else {
      System.out.println("cannot find film");
      return null;
    }

  }

  // add film to database [in progress]
  public void addFilm(Films f) {
    filmsRepo.save(f);
  }

}
