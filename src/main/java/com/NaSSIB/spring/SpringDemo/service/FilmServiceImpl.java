package com.NaSSIB.spring.SpringDemo.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.repo.IFilmsRepo;

@Service
public class FilmServiceImpl implements IFilmService {
  private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);
  @Autowired
  IFilmsRepo filmsRepo;

  // get all films
  @Override
  public Iterable<Films> getFilms() {
    log.debug("getting all films");
    return filmsRepo.findAll();
  }

  // get films with matching filmCreator
  @Override
  public Iterable<Films> getFilmsByCreator(String filmMaker) {
    return filmsRepo.findByFilmCreator(filmMaker);
  }

  // get films with matching filmTitle
  @Override
  public Iterable<Films> getFilmsByTitle(String filmTitle) {
    return filmsRepo.findByFilmTitle(filmTitle);
  }


  // get film by id
  @Override
  public Optional<Films> getAFilm(int identity) {
    // match request id to set of films

    Optional<Films> film1 = filmsRepo.findById(Integer.valueOf(identity));

    if (film1.isPresent()) {
      // System.out.println(film1.toString()); //for debugging
      return film1;
    } else {
      log.error("cannot find film with id: " + identity);
      return null;
    }

  }

  // add film to database [in progress]
  @Override
  public void addFilm(Films f) {
    log.debug("saving film: " + f);
    filmsRepo.save(f);
  }

  // deletes film by id
  @Override
  public void delete(Integer identity) {
    filmsRepo.deleteById(identity);

  }


}
