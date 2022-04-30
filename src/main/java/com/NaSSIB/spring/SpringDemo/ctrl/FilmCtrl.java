package com.NaSSIB.spring.SpringDemo.ctrl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.model.Viewers;
import com.NaSSIB.spring.SpringDemo.service.FilmService;

@RestController
public class FilmCtrl {

  @Autowired
  FilmService filmService;

  // requestmap for films, returns all films with optional category
  @RequestMapping(method = RequestMethod.GET, value = "/films")
  Iterable<Films> getAllFilms() {
    return filmService.getFilms();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/films/m")
  Iterable<Films> getFilmByCreator(
      @RequestParam(name = "filmMaker", required = true) String filmMaker) {

    System.out.println("request param: " + filmMaker);
    return filmService.getFilmsByCreator(filmMaker);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/films/t")
  Iterable<Films> getFilmByTitle(
      @RequestParam(name = "filmTitle", required = true) String filmTitle) {

    System.out.println("request param: " + filmTitle);
    return filmService.getFilmsByTitle(filmTitle);
  }

  // requestmap for films with id, returns one film
  @RequestMapping(method = RequestMethod.GET, value = "/films/{id}")
  Optional<Films> getFilmDetails(@PathVariable("id") Integer identity) {

    try {
      return filmService.getAFilm(identity);
    } finally {
      // bad practice
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/viewers")
  List<Viewers> getAllViewers() {
    return filmService.getViewers();
  }

  // requestmap to add new film utilizing POST method
  @RequestMapping(method = RequestMethod.POST, value = "/films")
  public void addFilm(@RequestBody Films newFilm) {
    filmService.addFilm(newFilm);
  }

}
