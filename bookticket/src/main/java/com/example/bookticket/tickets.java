package com.example.bookticket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tickets {
    @GetMapping
    @RequestMapping("/booktickets")

    public String getTickets(){
        return "tickets available";
    }
}
