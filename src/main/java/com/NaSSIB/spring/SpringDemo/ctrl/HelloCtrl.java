/**
 * 
 */
package com.NaSSIB.spring.SpringDemo.ctrl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.NaSSIB.spring.SpringDemo.entity.UserDto;

/**
 * @author sandy
 *
 */

@RestController
public class HelloCtrl {


  @GetMapping("/")
  String home() {
    return "Hello :)";
  }


  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "Quintrix JFS") String name) {
    return String.format("Hello %s!", name);
  }

  @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
  public ModelAndView welcomePage() {

    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security Hello World");
    model.addObject("message", "This is welcome page!");
    model.setViewName("hello");
    return model;

  }

  @RequestMapping(value = "/admin**", method = RequestMethod.GET)
  public ModelAndView adminPage() {

    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security Hello World");
    model.addObject("message", "This is protected page!");
    model.setViewName("admin");

    return model;

  }

  @GetMapping("/registration")
  public String showRegistrationForm(WebRequest request, Model model) {
    UserDto userDto = new UserDto();
    model.addAttribute("user", userDto);
    return "registered";
  }

  @PostMapping("/registration")
  public ModelAndView registerUserAccount(
      @ModelAttribute("user") @Validated UserDto dataTransferObj, HttpServletRequest request,
      Errors errors) {


    return new ModelAndView("successRegister", "user", dataTransferObj);

  }

}
