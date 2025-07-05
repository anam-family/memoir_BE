package com.memoir.memoir.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "홈", description = "서버 상태 확인 API")
public class HomeController {
    
    @Operation(summary = "서버 상태 확인", description = "API 서버가 정상 작동하는지 확인합니다.")
    @ApiResponse(responseCode = "200", description = "서버 정상 작동")
    @GetMapping("/")
    public String home() {
        return "자서전 API 서버가 정상적으로 작동 중입니다.";
    }
} 