package com.netcraker.dragun.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/fapi")
public class TestController {
    @GetMapping
    public HashMap<String, String> getTest() {

        return new HashMap<>();
    }

}
