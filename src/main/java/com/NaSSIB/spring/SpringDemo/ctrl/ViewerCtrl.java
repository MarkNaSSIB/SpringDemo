package com.NaSSIB.spring.SpringDemo.ctrl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringDemo.entity.Viewers;
import com.NaSSIB.spring.SpringDemo.service.ViewerServImpl;

@RestController
public class ViewerCtrl {
  @Autowired
  ViewerServImpl viewerServ;


  private static final Logger log = LoggerFactory.getLogger(ViewerCtrl.class);

  // requestmap to get all viewers
  @GetMapping("/viewers")
  public Iterable<Viewers> getAllViewers() {
    try {
      log.debug("getting all viewrs");
      return viewerServ.getViewers();
    } catch (Exception e) {
      log.error("could not get viewers");

      e.printStackTrace();
      return null;
    }
  }

  // requestmap for viewers with id, returns one viewer
  @GetMapping("/viewers/{id}")
  Optional<Viewers> getAViewer(@PathVariable("id") Integer identity) {


    log.debug("Getting viewr: " + identity);
    return viewerServ.getAViewer(identity);

  }

  // requestmap to get all viewers by activity
  @GetMapping("/viewers/a")
  Iterable<Viewers> getViewerByS(
      @RequestParam(name = "activity", required = true) String activity) {

    log.debug("Getting viewrs: " + activity);
    return viewerServ.findByStatus(activity);

  }

  // requestmap to add new viewer utilizing POST method
  @PostMapping("/viewers")
  public void addViewer(@RequestBody Viewers newView) {
    log.debug("Adding viewer: " + newView);
    viewerServ.addViewer(newView);
  }

  // requestmap for updating viewer utilizing PUT
  @PutMapping("/viewers")
  public void updateViewer(@RequestBody Viewers newView) {
    log.debug("updating viewer: " + newView);
    viewerServ.updateViewer(newView);
  }

  // requestmap to delete viewer by ID
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
