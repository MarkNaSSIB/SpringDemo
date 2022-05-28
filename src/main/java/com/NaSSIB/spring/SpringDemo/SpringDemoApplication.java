package com.NaSSIB.spring.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDemoApplication.class, args);
  }

  // public void run(String... args) throws Exception {
  // Optional<Films> film1 = filmsRepo.findById(Integer.valueOf(1));
  //
  // }

}
