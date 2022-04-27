/**
 * 
 */
package com.NaSSIB.spring.SpringDemo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sandy
 *
 */

@RestController
public class HelloCtrl {


  @GetMapping("/")
  String home() {
    return "Hello SpringBoot";

  }


  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "Quintrix JFS") String name) {
    return String.format("Hello %s!", name);
  }

}
