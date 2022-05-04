package com.NaSSIB.spring.SpringDemo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.NaSSIB.spring.SpringDemo.entity.Viewers;
import com.NaSSIB.spring.SpringDemo.service.ViewerServImpl;

@RestController
public class ViewerCtrl {
  @Autowired
  ViewerServImpl viewerServ;

  @RequestMapping(method = RequestMethod.GET, value = "/viewers")
  public Iterable<Viewers> getAllViewers() {
    try {
      return viewerServ.getViewers();
    } catch (Exception e) {
      System.out.println("could not get viewers");
      // TODO Auto-generated catch block

      e.printStackTrace();
      return null;
    }
  }

}
