package com.example.greeting_app.controller;

import com.example.greeting_app.model.Greeting;
import com.example.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.greeting_app.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService=greetingService;
    }

    @PostMapping
    public Greeting saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/personalized")
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName) {
        return "{\"message\": " + greetingService.getPersonalizedGreeting(firstName, lastName) + "\"}";
    }

}
