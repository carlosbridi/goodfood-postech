package com.good.food.driver.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@Api(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HelloWorldController {

  @GetMapping(path = "/hello-world")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> helloWolrd() {
      return ResponseEntity.ok().body("Hello world!!");
    }

}
