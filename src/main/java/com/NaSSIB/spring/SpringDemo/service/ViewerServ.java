package com.NaSSIB.spring.SpringDemo.service;

import com.NaSSIB.spring.SpringDemo.entity.Viewers;

public interface ViewerServ {
  // rest service
  public Iterable<Viewers> getViewers();

  void addViewer(Viewers v);

  void addViewers(Iterable<Viewers> v);
}
