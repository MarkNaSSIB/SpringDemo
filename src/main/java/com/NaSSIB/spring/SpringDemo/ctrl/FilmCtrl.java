package com.NaSSIB.spring.SpringDemo.ctrl;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringDemo.model.Film;
import com.NaSSIB.spring.SpringDemo.service.FilmService;

@RestController
public class FilmCtrl {

  @Autowired
  FilmService filmService;

  // do not create variables like this
  // Set<Film> filmSet = filmService.getFilms();

  // requestmap for films, returns all films with optional category
  @RequestMapping(method = RequestMethod.GET, value = "/films")
  Set<Film> getFilmSet(@RequestParam(name = "filmMaker", required = false) String filmMaker) {

    System.out.println("request param: " + filmMaker);
    if (filmMaker == null || filmMaker.isEmpty()) {
      return filmService.getFilms();
    } else {
      return filmService.getFilms(filmMaker);
    }
  }

  // requestmap for films with id, returns one film
  @RequestMapping(method = RequestMethod.GET, value = "/films/{id}")
  Set<Film> getFilmDetails(@PathVariable("id") int identity) {

    return filmService.getAFilm(identity);

  }

  // requestmap to add new film utilizing POST method
  @RequestMapping(method = RequestMethod.POST, value = "/films")
  public void addFilm(@RequestBody Film newFilm) {
    // todo move to service layer
    Set<Film> filmSet = filmService.getFilms();
    filmSet.add(newFilm);
  }

}
