package com.NaSSIB.spring.SpringDemo.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private static final Logger log = LoggerFactory.getLogger(ViewerServImpl.class);

  // instantiate rest template bean
  @Autowired
  RestTemplate restTempl;

  @Autowired
  IViewersRepo viewerRepo;

  @Override
  public Iterable<Viewers> getViewers() {

    if (viewerRepo.count() != 0) {
      // if viewers exist in repo
      log.debug("found viewers in DB: " + viewerRepo.count());
      return viewerRepo.findAll();
    } else {
      // get viewers from api
      // Iterator<Viewers> iterate;
      // api uri for viewers
      String VIEWER_URI = "https://gorest.co.in/public/v2/users";
      List<Viewers> viewerList;
      log.debug("getting viewers");

      // generate response entity
      ResponseEntity<List<Viewers>> viewersListResponse = restTempl.exchange(VIEWER_URI,
          HttpMethod.GET, null, new ParameterizedTypeReference<List<Viewers>>() {});

      // List<Viewers> viewerList = restTempl.getForObject(VIEWER_URI, List.class);
      if (viewersListResponse.getStatusCode() == HttpStatus.OK) {
        // viewer adding works
        viewerList = viewersListResponse.getBody();
        viewerList.forEach(v -> addViewer(v));
        // iterate = viewerList.iterator();
        log.debug("added viewers to db");
        return getViewers();
      } else {
        // not in repo and api failed
        log.error("bad http response, could not get viewers");
        return null;
      }
    }
  }

  // add a viewer to db
  @Override
  public void addViewer(Viewers v) {
    log.debug("saving viewer: " + v);
    viewerRepo.save(v);
  }

  // add a collection of viewers to db
  @Override
  public void addViewers(Iterable<Viewers> v) {
    viewerRepo.saveAll(v);
  }

  // returns a viewer by id
  public Optional<Viewers> getAViewer(Integer identity) {
    Optional<Viewers> viewr = viewerRepo.findById(Integer.valueOf(identity));

    if (viewr.isPresent()) {
      // System.out.println(film1.toString()); //for debugging
      return viewr;
    } else {
      log.error("cannot find film with id: " + identity);
      return null;
    }

  }

  // finds viewer by status
  @Override
  public Iterable<Viewers> findByStatus(String activity) {
    log.debug("getting status: " + activity);
    viewerRepo.findByStatus(activity);
    return null;
  }

  // deletes a viewer by id
  public void deleteViewer(Integer identity) {
    viewerRepo.deleteById(identity);

  }

  // updates existing viewer
  public void updateViewer(Viewers existView) {
    log.debug("updating viewer: " + existView);
    viewerRepo.save(existView);
  }



}
