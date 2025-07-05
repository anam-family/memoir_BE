package com.memoir.memoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memoir.memoir.entity.Memoir;

@Repository
public interface MemoirRepository extends JpaRepository<Memoir, Long> {
} 