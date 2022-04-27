package com.NaSSIB.spring.SpringDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.NaSSIB.spring.SpringDemo.entity.Films;

@Repository
public interface IFilmsRepo extends CrudRepository<Films, Integer> {
  // methods available by defualt[without implementation] via CrudRepo


}
