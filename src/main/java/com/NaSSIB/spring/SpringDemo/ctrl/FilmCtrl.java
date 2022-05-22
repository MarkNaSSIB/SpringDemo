package com.NaSSIB.spring.SpringDemo.ctrl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.service.FilmService;

@RestController
public class FilmCtrl {

  private static final Logger log = LoggerFactory.getLogger(FilmCtrl.class);

  @Autowired
  FilmService filmService;

  // requestmap for films, returns all films
  @RequestMapping(method = RequestMethod.GET, value = "/films")
  Iterable<Films> getAllFilms() {
    log.debug("Getting all films");
    return filmService.getFilms();
    // FilmResponse filmResp = new FilmResponse();
    // filmResp.setFilmList((List<Films>) filmService.getFilms());
  }

  // requestmap for films, returns from filmMaker param
  @RequestMapping(method = RequestMethod.GET, value = "/films/m")
  Iterable<Films> getFilmByCreator(
      @RequestParam(name = "filmMaker", required = true) String filmMaker) {
    log.debug("Getting films from: " + filmMaker);
    return filmService.getFilmsByCreator(filmMaker);
  }

  // requestmap for films, returns from filmTitle param
  @RequestMapping(method = RequestMethod.GET, value = "/films/t")
  Iterable<Films> getFilmByTitle(
      @RequestParam(name = "filmTitle", required = true) String filmTitle) {
    log.debug("Getting film: " + filmTitle);
    return filmService.getFilmsByTitle(filmTitle);
  }

  // requestmap for films with id, returns one film
  @RequestMapping(method = RequestMethod.GET, value = "/films/{id}")
  Optional<Films> getFilmDetails(@PathVariable("id") Integer identity) {

    try {
      log.debug("Getting film: " + identity);
      return filmService.getAFilm(identity);
    } finally {
      // bad practice
    }
  }

  // requestmap to add new film utilizing POST method
  @RequestMapping(method = RequestMethod.POST, value = "/films")
  public void addFilm(@RequestBody Films newFilm) {
    log.debug("Adding film: " + newFilm);
    filmService.addFilm(newFilm);
  }

  // delete map for film id
  @DeleteMapping("films/{id}")
  public HttpStatus delete(@PathVariable("id") Integer identity) {
    try {
      filmService.delete(identity);
      return HttpStatus.OK;
    } catch (Exception e) {
      log.error("could not delete entry");
      return null;
    }
  }

}
