package com.NaSSIB.spring.SpringDemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.model.Viewers;
import com.NaSSIB.spring.SpringDemo.repo.IFilmsRepo;

@Service
public class FilmServiceImpl implements FilmService {

  @Autowired
  IFilmsRepo filmsRepo;

  @Autowired
  RestTemplate restTempl;

  // get all films
  @Override
  public Iterable<Films> getFilms() {
    return filmsRepo.findAll();
  }

  @Override
  public List<Viewers> getViewers() {
    String VIEWER_URI = "https://gorest.co.in/public/v2/users";
    List<Viewers> viewerList;
    System.out.println("getting viewers");
    ResponseEntity<List<Viewers>> viewersListResponse = restTempl.exchange(VIEWER_URI,
        HttpMethod.GET, null, new ParameterizedTypeReference<List<Viewers>>() {});

    // List<Viewers> viewerList = restTempl.getForObject(VIEWER_URI, List.class);
    if (viewersListResponse.getStatusCode() == HttpStatus.OK) {
      viewerList = viewersListResponse.getBody();
      return viewerList;
    } else {
      System.out.println("bad http response, could not get viewers");
      return null;
    }


    // method IP
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
      System.out.println("cannot find film");
      return null;
    }

  }

  // add film to database [in progress]
  @Override
  public void addFilm(Films f) {
    filmsRepo.save(f);
  }


}
