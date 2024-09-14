package com.aws.api.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

@EnableAutoConfiguration
@EnableWebFlux
public class RequestHandler {

    public Mono<String> publish(String message) {

    }

}
