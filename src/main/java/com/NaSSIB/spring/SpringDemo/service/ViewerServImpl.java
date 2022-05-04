package com.NaSSIB.spring.SpringDemo.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.NaSSIB.spring.SpringDemo.entity.Viewers;
import com.NaSSIB.spring.SpringDemo.repo.IViewersRepo;

@Service
public class ViewerServImpl implements ViewerServ {
  // rest service implementation
  @Autowired
  RestTemplate restTempl;

  @Autowired
  IViewersRepo viewerRepo;

  @SuppressWarnings("unchecked")
  @Override
  public Iterable<Viewers> getViewers() {

    if (viewerRepo.count() != 0) {
      // if viewers exist in repo
      System.out.println("found viewers in DB: " + viewerRepo.count());
      return viewerRepo.findAll();
    } else {
      // get viewers from api
      Iterator<Viewers> iterate;
      String VIEWER_URI = "https://gorest.co.in/public/v2/users";
      List<Viewers> viewerList;
      System.out.println("getting viewers");
      ResponseEntity<List<Viewers>> viewersListResponse = restTempl.exchange(VIEWER_URI,
          HttpMethod.GET, null, new ParameterizedTypeReference<List<Viewers>>() {});

      // List<Viewers> viewerList = restTempl.getForObject(VIEWER_URI, List.class);
      if (viewersListResponse.getStatusCode() == HttpStatus.OK) {
        // viewer adding works
        viewerList = viewersListResponse.getBody();
        viewerList.forEach(v -> addViewer(v));
        iterate = viewerList.iterator();
        // addViewers((Iterable<Viewers>) iterate);
        System.out.println("added viewers to db");
        return (Iterable<Viewers>) iterate;
      } else {
        // not in repo and api failed
        System.out.println("bad http response, could not get viewers");
        return null;
      }
    }
  }

  // add a viewer to db
  @Override
  public void addViewer(Viewers v) {
    viewerRepo.save(v);
  }

  // add a collection of viewers to db
  @Override
  public void addViewers(Iterable<Viewers> v) {
    viewerRepo.saveAll(v);
  }



}
