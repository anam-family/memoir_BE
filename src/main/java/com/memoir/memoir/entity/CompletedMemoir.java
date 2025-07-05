package com.memoir.memoir.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "completed_memoir")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "완성된 자서전 엔티티")
public class CompletedMemoir {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "완성된 자서전 ID", example = "1")
    private Long id;
    
    @Column(nullable = false)
    @Schema(description = "이름", example = "홍길동", required = true)
    private String name;
    
    @Column(nullable = false)
    @Schema(description = "생년월일", example = "1990-01-01", required = true)
    private LocalDate birthDate;
    
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    @Schema(description = "완성된 자서전 내용 (최대 30만자)", 
            example = "어린 시절부터 지금까지의 인생 여정을 담은 완성된 자서전 내용입니다...")
    private String content;
    
    @Column(name = "created_at", nullable = false)
    @Schema(description = "생성일시")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    @Schema(description = "수정일시")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
} 