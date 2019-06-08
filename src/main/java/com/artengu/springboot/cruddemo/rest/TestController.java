package com.artengu.springboot.cruddemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

 //   @RequestMapping("/")
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Team Name: " +   " <br/> Team Type: ";
    }


}
