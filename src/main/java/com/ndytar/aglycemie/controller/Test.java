package com.ndytar.aglycemie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
 @RestController
public class Test {
 @GetMapping("test")
Map<String, String> test(){return Map.of("test","test api") ;
}
}
