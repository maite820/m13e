package com.Controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;


public class Controller implements ErrorController {

 private static final String PATH = "/error";

 @RequestMapping(value = PATH)
 public String error() {
  return "customError";
 }

 public String getErrorPath() {
  return PATH;
 }

}
