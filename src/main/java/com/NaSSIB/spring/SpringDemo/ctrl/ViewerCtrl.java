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


    log.debug("Getting viewr: " + identity);
    return viewerServ.getAViewer(identity);

  }

  @RequestMapping(method = RequestMethod.GET, value = "/viewers/a")
  Iterable<Viewers> getViewerByS(
      @RequestParam(name = "activity", required = true) String activity) {

    log.debug("Getting viewrs: " + activity);
    return viewerServ.findByStatus(activity);

  }

  // requestmap to add new film utilizing POST method
  @RequestMapping(method = RequestMethod.POST, value = "/viewers")
  public void addViewer(@RequestBody Viewers newView) {
    log.debug("Adding viewer: " + newView);
    viewerServ.addViewer(newView);
  }

  @DeleteMapping("viewers/{id}")
  public HttpStatus delete(@PathVariable("id") Integer identity) {
    try {
      viewerServ.deleteViewer(identity);
      return HttpStatus.OK;
    } catch (Exception e) {
      log.error("could not delete entry");
      return null;
    }

  }
}
