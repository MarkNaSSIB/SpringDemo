package com.NaSSIB.spring.SpringDemo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.NaSSIB.spring.SpringDemo.entity.Films;
import com.NaSSIB.spring.SpringDemo.repo.IFilmsRepo;

@SpringBootApplication
public class SpringDemoApplication {

  @Autowired
  IFilmsRepo filmsRepo;

  public static void main(String[] args) {
    SpringApplication.run(SpringDemoApplication.class, args);
  }

  public void run(String... args) throws Exception {
    Optional<Films> film1 = filmsRepo.findById(Integer.valueOf(1));

    if (film1.isPresent()) {
      System.out.println(film1.toString());
    } else {
      System.out.println("cannot find film");
    }

  }

}
