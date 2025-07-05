package com.memoir.memoir.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoir.memoir.entity.Memoir;
import com.memoir.memoir.service.MemoirService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memoir")
@CrossOrigin(origins = "*")
@Tag(name = "자서전 API", description = "자서전 데이터를 관리하는 API")
public class MemoirController {
    
    private final MemoirService memoirService;
    
    @Operation(summary = "자서전 목록 조회", description = "모든 자서전 데이터를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "자서전 목록 조회 성공")
    @GetMapping("")
    public ResponseEntity<List<Memoir>> list() {
        List<Memoir> memoirs = memoirService.findAll();
        return ResponseEntity.ok(memoirs);
    }
    
    @Operation(summary = "자서전 생성", description = "새로운 자서전을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "자서전 생성 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping("")
    public ResponseEntity<Memoir> create(@RequestBody Memoir memoir) {
        Memoir savedMemoir = memoirService.save(memoir);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMemoir);
    }
    
    @Operation(summary = "자서전 상세 조회", description = "ID로 특정 자서전을 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "자서전 조회 성공"),
        @ApiResponse(responseCode = "404", description = "자서전을 찾을 수 없음")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Memoir> detail(
            @Parameter(description = "자서전 ID") @PathVariable Long id) {
        return memoirService.findById(id)
                .map(memoir -> ResponseEntity.ok(memoir))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "자서전 수정", description = "기존 자서전을 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "자서전 수정 성공"),
        @ApiResponse(responseCode = "404", description = "자서전을 찾을 수 없음"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Memoir> update(
            @Parameter(description = "자서전 ID") @PathVariable Long id, 
            @RequestBody Memoir memoir) {
        return memoirService.findById(id)
                .map(existingMemoir -> {
                    memoir.setId(id);
                    Memoir updatedMemoir = memoirService.update(memoir);
                    return ResponseEntity.ok(updatedMemoir);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "자서전 삭제", description = "특정 자서전을 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "자서전 삭제 성공"),
        @ApiResponse(responseCode = "404", description = "자서전을 찾을 수 없음")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "자서전 ID") @PathVariable Long id) {
        return memoirService.findById(id)
                .map(memoir -> {
                    memoirService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 