package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;


/**
 * Handles requests for the application home page.
 */
@RestController @CrossOrigin(origins = "*")
public class RouterFunctionConfig {
    /*
    @Bean
    public RouterFunction<?> index() {
        return route(GET("/hello"),
                request -> ok().body(just("Hello World!"), String.class))
                .andRoute(GET("/bye"),
                request -> ok().body(just("See ya!"), String.class));
    } */
    @GetMapping("/test")
    public Map<?,?> hello(){
        System.out.println("React & Boot 서버 연결");
        var map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        return map;
    }
}