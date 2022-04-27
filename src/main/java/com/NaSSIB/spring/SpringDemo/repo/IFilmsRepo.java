package com.NaSSIB.spring.SpringDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.NaSSIB.spring.SpringDemo.entity.Films;

@Repository
public interface IFilmsRepo extends CrudRepository<Films, Integer> {
  // methods available by default[without implementation] via CrudRepo
  public Iterable<Films> findByFilmCreator(String filmCreator);
  // how to implement this function and see auto generated functions

}
