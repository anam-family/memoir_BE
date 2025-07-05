package com.memoir.memoir.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "자서전 API 서버가 정상적으로 작동 중입니다.";
    }
} 