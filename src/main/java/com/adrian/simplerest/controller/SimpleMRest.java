package com.adrian.simplerest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleMRest {

    @GetMapping("/m1")
    public String m1() {
        return "M1";
    }

    @GetMapping("/m2")
    public String m2() {
        return "M2";
    }

    @GetMapping("/m3")
    public String m3() {
        return "M3";
    }
}
