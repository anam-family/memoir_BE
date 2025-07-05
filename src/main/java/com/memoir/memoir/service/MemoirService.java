package com.memoir.memoir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memoir.memoir.entity.Memoir;
import com.memoir.memoir.repository.MemoirRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoirService {
    
    private final MemoirRepository memoirRepository;
    
    @Transactional(readOnly = true)
    public List<Memoir> findAll() {
        return memoirRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Memoir> findById(Long id) {
        return memoirRepository.findById(id);
    }
    
    @Transactional
    public Memoir save(Memoir memoir) {
        return memoirRepository.save(memoir);
    }
    
    @Transactional
    public void deleteById(Long id) {
        memoirRepository.deleteById(id);
    }
    
    @Transactional
    public Memoir update(Memoir memoir) {
        return memoirRepository.save(memoir);
    }
} 