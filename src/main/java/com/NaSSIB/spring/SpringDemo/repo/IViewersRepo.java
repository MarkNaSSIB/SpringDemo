package com.NaSSIB.spring.SpringDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.NaSSIB.spring.SpringDemo.entity.Viewers;

@Repository
public interface IViewersRepo extends CrudRepository<Viewers, Integer> {

  public Iterable<Viewers> findAll();

}
