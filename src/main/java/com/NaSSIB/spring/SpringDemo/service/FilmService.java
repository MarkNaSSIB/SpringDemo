package com.NaSSIB.spring.SpringDemo.service;

import static java.util.stream.Collectors.toSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.NaSSIB.spring.SpringDemo.model.Film;

@Service
public class FilmService {

  // instantiate film objects
  Film film1 = new Film(1, "Star Wars", 121, "May 5 1977", "George Lucas");
  Film film2 = new Film(2, "Inception", 148, "July 16 2010", "Christopher Nolan");
  Film film3 = new Film(3, "Batman Begins", 140, "June 15 2005", "Christopher Nolan");
  Film film4 = new Film(4, "Raiders of the Lost Ark", 115, "June 12 1981", "George Lucas");
  Film film5 = new Film(5, "The Fault in our Stars", 126, "June 6 2014", "John Green");
  Film film6 =
      new Film(6, "Harry Potter and the Philosophers Stone", 152, "November 10 2001", "JK Rowling");
  Film film7 = new Film(7, "Star Wars: Revenge of the Sith", 140, "May 19 2005", "George Lucas");
  Film film8 = new Film(8, "Interstellar", 169, "November 5 2014", "Christopher Nolan");
  Film film9 =
      new Film(9, "Harry Potter and the Half-Blood Prince", 153, "July 15 2009", "JK Rowling");

  // build film hashSet from stream
  Stream<Film> filmStream =
      Stream.of(film1, film2, film3, film4, film5, film6, film7, film8, film9);
  Set<Film> filmSet = filmStream.collect(toSet());

  public Set<Film> getFilms() {
    return filmSet;
  }

  // function bugged will fix later
  public Set<Film> getFilms(String filmMaker) {
    // if (filmMaker == null || filmMaker.isEmpty()) {
    return filmSet.stream().filter(f -> f.getFilmCreator().contains(filmMaker))
        .collect(Collectors.toSet());
    // } else {
    // return filmSet;
    // }
  }

  public Set<Film> getAFilm(int identity) {

    // match request id to set of films
    Stream<Film> resultStream = filmSet.stream().filter(f -> f.getId() == identity);
    Set<Film> resultSet = resultStream.collect(toSet());

    // null checking
    if (resultSet.isEmpty()) {
      // if no id match, return null set
      Set<Film> emptySet = new HashSet<>();
      Film notFilm = new Film(-1, "not a film", -1, "January 1 1970", "na");
      emptySet.add(notFilm);
      return emptySet;
    } else {
      // if id exists, return film
      return resultSet;
    }
  }

  public void addFilm(Film f) {

  }

}