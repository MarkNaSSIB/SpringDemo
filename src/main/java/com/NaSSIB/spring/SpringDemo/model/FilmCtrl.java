package com.NaSSIB.spring.SpringDemo.model;

import static java.util.stream.Collectors.toSet;
import java.util.Set;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmCtrl {


  Film film1 = new Film("Star Wars", 121, "May 5 1977", "George Lucas");
  Film film2 = new Film("Inception", 148, "July 16 2010", "Christopher Nolan");
  Film film3 = new Film("Batman Begins", 140, "June 15 2005", "Christopher Nolan");
  Film film4 = new Film("Raiders of the Lost Ark", 115, "June 12 1981", "George Lucas");
  Film film5 = new Film("The Fault in our Stars", 126, "June 6 2014", "John Green");
  Film film6 =
      new Film("Harry Potter and the Philosophers Stone", 152, "November 10 2001", "JK Rowling");
  Film film7 = new Film("Star Wars: Revenge of the Sith", 140, "May 19 2005", "George Lucas");
  Film film8 = new Film("Interstellar", 169, "November 5 2014", "Christopher Nolan");
  Film film9 =
      new Film("Harry Potter and the Half-Blood Prince", 153, "July 15 2009", "JK Rowling");

  // build film hashSet
  // Set<Film> filmSet = new HashSet<Film>();

  Stream<Film> filmStream =
      Stream.of(film1, film2, film3, film4, film5, film6, film7, film8, film9);
  Set<Film> filmSet = filmStream.collect(toSet());

  @RequestMapping("/films")
  void getFilmSet() {
    System.out.println("All Films: ");
    filmSet.forEach(System.out::println);
    return;

  }


}
