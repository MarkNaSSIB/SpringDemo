package com.NaSSIB.spring.SpringDemo.service;

import java.util.Optional;
import com.NaSSIB.spring.SpringDemo.entity.Viewers;

public interface IViewerServ {
  // rest service
  public Iterable<Viewers> getViewers();

  public Optional<Viewers> getAViewer(Integer identity);

  void addViewer(Viewers v);

  void addViewers(Iterable<Viewers> v);

  public Iterable<Viewers> findByStatus(String activity);
}
