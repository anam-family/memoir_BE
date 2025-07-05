package com.memoir.memoir.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memoir.memoir.entity.CompletedMemoir;

@Repository
public interface CompletedMemoirRepository extends JpaRepository<CompletedMemoir, Long> {
    
    // 이름으로 검색
    List<CompletedMemoir> findByNameContaining(String name);
    
    // 이름과 생년월일로 검색
    Optional<CompletedMemoir> findByNameAndBirthDate(String name, java.time.LocalDate birthDate);
    
    // 생성일시 기준 내림차순 정렬
    List<CompletedMemoir> findAllByOrderByCreatedAtDesc();
} 