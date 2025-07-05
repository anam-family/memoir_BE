package com.memoir.memoir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.memoir.memoir.entity.CompletedMemoir;
import com.memoir.memoir.repository.CompletedMemoirRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompletedMemoirService {
    
    private final CompletedMemoirRepository completedMemoirRepository;
    
    // 모든 완성된 자서전 조회
    public List<CompletedMemoir> findAll() {
        return completedMemoirRepository.findAllByOrderByCreatedAtDesc();
    }
    
    // ID로 완성된 자서전 조회
    public Optional<CompletedMemoir> findById(Long id) {
        return completedMemoirRepository.findById(id);
    }
    
    // 완성된 자서전 저장
    public CompletedMemoir save(CompletedMemoir completedMemoir) {
        return completedMemoirRepository.save(completedMemoir);
    }
    
    // 완성된 자서전 수정
    public CompletedMemoir update(CompletedMemoir completedMemoir) {
        return completedMemoirRepository.save(completedMemoir);
    }
    
    // 완성된 자서전 삭제
    public void deleteById(Long id) {
        completedMemoirRepository.deleteById(id);
    }
    
    // 이름으로 검색
    public List<CompletedMemoir> findByName(String name) {
        return completedMemoirRepository.findByNameContaining(name);
    }
    
    // 이름과 생년월일로 검색
    public Optional<CompletedMemoir> findByNameAndBirthDate(String name, java.time.LocalDate birthDate) {
        return completedMemoirRepository.findByNameAndBirthDate(name, birthDate);
    }
    
    // 텍스트 길이 검증
    public boolean isValidContentLength(String content) {
        return content != null && content.length() <= 300000; // 30만자 제한
    }
} 