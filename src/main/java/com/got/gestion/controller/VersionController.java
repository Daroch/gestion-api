package com.got.gestion.controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class VersionController {
 
    @GetMapping("/api/version")
    public String version() {
        return "gestion-api v2 · desplegada desde GitHub";
    }
}

