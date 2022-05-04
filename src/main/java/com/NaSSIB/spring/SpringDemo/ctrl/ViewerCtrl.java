package com.NaSSIB.spring.SpringDemo.ctrl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringDemo.entity.Viewers;
import com.NaSSIB.spring.SpringDemo.service.ViewerServImpl;

@RestController
public class ViewerCtrl {
  @Autowired
  ViewerServImpl viewerServ;


  private static final Logger log = LoggerFactory.getLogger(ViewerCtrl.class);

  @RequestMapping(method = RequestMethod.GET, value = "/viewers")
  public Iterable<Viewers> getAllViewers() {
    try {
      log.debug("getting all viewrs");
      return viewerServ.getViewers();
    } catch (Exception e) {
      log.error("could not get viewers");
      // TODO Auto-generated catch block

      e.printStackTrace();
      return null;
    }
  }

  // requestmap for films with id, returns one film
  @RequestMapping(method = RequestMethod.GET, value = "/viewers/{id}")
  Optional<Viewers> getAViewer(@PathVariable("id") Integer identity) {

    try {
      log.debug("Getting viewr: " + identity);
      return viewerServ.getAViewer(identity);
    } finally {
      // bad practice
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/viewers/a/{activity}")
  Iterable<Viewers> getViewerByS(@PathVariable("activity") String activity) {

    try {
      log.debug("Getting viewrs: " + activity);
      return viewerServ.findByStatus(activity);
    } finally {
      // bad practice
    }
  }

}
