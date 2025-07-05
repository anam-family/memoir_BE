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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memoir.memoir.entity.CompletedMemoir;
import com.memoir.memoir.service.CompletedMemoirService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/completed-memoir")
@CrossOrigin(origins = "*")
@Tag(name = "완성된 자서전 API", description = "완성된 자서전 데이터를 관리하는 API")
public class CompletedMemoirController {
    
    private final CompletedMemoirService completedMemoirService;
    
    @Operation(summary = "완성된 자서전 목록 조회", description = "모든 완성된 자서전 데이터를 최신순으로 조회합니다.")
    @ApiResponse(responseCode = "200", description = "완성된 자서전 목록 조회 성공")
    @GetMapping("")
    public ResponseEntity<List<CompletedMemoir>> list() {
        List<CompletedMemoir> completedMemoirs = completedMemoirService.findAll();
        return ResponseEntity.ok(completedMemoirs);
    }
    
    @Operation(
        summary = "완성된 자서전 생성", 
        description = "새로운 완성된 자서전을 생성합니다. 최대 30만자까지 저장 가능합니다."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "완성된 자서전 생성 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (텍스트 길이 초과 등)")
    })
    @PostMapping("")
    public ResponseEntity<?> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "완성된 자서전 생성 정보",
                required = true,
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CompletedMemoir.class),
                    examples = {
                        @ExampleObject(
                            name = "완성된 자서전 예시",
                            summary = "완성된 자서전 생성 예시",
                            description = "이름, 생년월일, 완성된 자서전 내용을 포함한 예시",
                            value = """
                                {
                                    "name": "홍길동",
                                    "birthDate": "1990-01-01",
                                                                         "content": "어린 시절부터 지금까지의 나의 인생 여정...\\n\\n[여기에 GPT가 생성한 완성된 자서전 내용이 들어갑니다. 최대 30만자까지 가능합니다.]"
                                }
                                """
                        )
                    }
                )
            ) @RequestBody CompletedMemoir completedMemoir) {
        
        // 텍스트 길이 검증
        if (!completedMemoirService.isValidContentLength(completedMemoir.getContent())) {
            return ResponseEntity.badRequest()
                .body("텍스트 길이가 30만자를 초과합니다. 현재 길이: " + completedMemoir.getContent().length());
        }
        
        CompletedMemoir savedCompletedMemoir = completedMemoirService.save(completedMemoir);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompletedMemoir);
    }
    
    @Operation(summary = "완성된 자서전 상세 조회", description = "ID로 특정 완성된 자서전을 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "완성된 자서전 조회 성공"),
        @ApiResponse(responseCode = "404", description = "완성된 자서전을 찾을 수 없음")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CompletedMemoir> detail(
            @Parameter(description = "완성된 자서전 ID") @PathVariable Long id) {
        return completedMemoirService.findById(id)
                .map(completedMemoir -> ResponseEntity.ok(completedMemoir))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "완성된 자서전 수정", description = "기존 완성된 자서전을 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "완성된 자서전 수정 성공"),
        @ApiResponse(responseCode = "404", description = "완성된 자서전을 찾을 수 없음"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 (텍스트 길이 초과 등)")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Parameter(description = "완성된 자서전 ID") @PathVariable Long id, 
            @RequestBody CompletedMemoir completedMemoir) {
        
        return completedMemoirService.findById(id)
                .map(existingCompletedMemoir -> {
                    // 텍스트 길이 검증
                    if (!completedMemoirService.isValidContentLength(completedMemoir.getContent())) {
                        return ResponseEntity.badRequest()
                            .body("텍스트 길이가 30만자를 초과합니다. 현재 길이: " + completedMemoir.getContent().length());
                    }
                    
                    completedMemoir.setId(id);
                    CompletedMemoir updatedCompletedMemoir = completedMemoirService.update(completedMemoir);
                    return ResponseEntity.ok(updatedCompletedMemoir);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "완성된 자서전 삭제", description = "특정 완성된 자서전을 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "완성된 자서전 삭제 성공"),
        @ApiResponse(responseCode = "404", description = "완성된 자서전을 찾을 수 없음")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "완성된 자서전 ID") @PathVariable Long id) {
        return completedMemoirService.findById(id)
                .map(completedMemoir -> {
                    completedMemoirService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "이름으로 완성된 자서전 검색", description = "이름으로 완성된 자서전을 검색합니다.")
    @GetMapping("/search")
    public ResponseEntity<List<CompletedMemoir>> searchByName(
            @Parameter(description = "검색할 이름") @RequestParam String name) {
        List<CompletedMemoir> results = completedMemoirService.findByName(name);
        return ResponseEntity.ok(results);
    }
} 