package com.memoir.memoir.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "memoir")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "자서전 엔티티")
public class Memoir {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "자서전 ID", example = "1")
    private Long id;
    
    @Column(nullable = false)
    @Schema(description = "이름", example = "홍길동", required = true)
    private String name;
    
    @Column(nullable = false)
    @Schema(description = "생년월일", example = "1990-01-01", required = true)
    private LocalDate birthDate;
    
    // 질문-답변 쌍 30개 - TEXT 타입으로 변경
    @Column(columnDefinition = "TEXT")
    @Schema(description = "첫 번째 질문", example = "어린 시절 가장 기억에 남는 순간은?")
    private String question1Question;
    @Column(columnDefinition = "TEXT")
    @Schema(description = "첫 번째 답변", example = "할머니와 함께 보낸 여름휴가가 가장 기억에 남습니다.")
    private String question1Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question2Question;
    @Column(columnDefinition = "TEXT")
    private String question2Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question3Question;
    @Column(columnDefinition = "TEXT")
    private String question3Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question4Question;
    @Column(columnDefinition = "TEXT")
    private String question4Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question5Question;
    @Column(columnDefinition = "TEXT")
    private String question5Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question6Question;
    @Column(columnDefinition = "TEXT")
    private String question6Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question7Question;
    @Column(columnDefinition = "TEXT")
    private String question7Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question8Question;
    @Column(columnDefinition = "TEXT")
    private String question8Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question9Question;
    @Column(columnDefinition = "TEXT")
    private String question9Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question10Question;
    @Column(columnDefinition = "TEXT")
    private String question10Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question11Question;
    @Column(columnDefinition = "TEXT")
    private String question11Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question12Question;
    @Column(columnDefinition = "TEXT")
    private String question12Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question13Question;
    @Column(columnDefinition = "TEXT")
    private String question13Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question14Question;
    @Column(columnDefinition = "TEXT")
    private String question14Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question15Question;
    @Column(columnDefinition = "TEXT")
    private String question15Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question16Question;
    @Column(columnDefinition = "TEXT")
    private String question16Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question17Question;
    @Column(columnDefinition = "TEXT")
    private String question17Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question18Question;
    @Column(columnDefinition = "TEXT")
    private String question18Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question19Question;
    @Column(columnDefinition = "TEXT")
    private String question19Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question20Question;
    @Column(columnDefinition = "TEXT")
    private String question20Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question21Question;
    @Column(columnDefinition = "TEXT")
    private String question21Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question22Question;
    @Column(columnDefinition = "TEXT")
    private String question22Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question23Question;
    @Column(columnDefinition = "TEXT")
    private String question23Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question24Question;
    @Column(columnDefinition = "TEXT")
    private String question24Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question25Question;
    @Column(columnDefinition = "TEXT")
    private String question25Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question26Question;
    @Column(columnDefinition = "TEXT")
    private String question26Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question27Question;
    @Column(columnDefinition = "TEXT")
    private String question27Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question28Question;
    @Column(columnDefinition = "TEXT")
    private String question28Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question29Question;
    @Column(columnDefinition = "TEXT")
    private String question29Answer;
    
    @Column(columnDefinition = "TEXT")
    private String question30Question;
    @Column(columnDefinition = "TEXT")
    private String question30Answer;
} 