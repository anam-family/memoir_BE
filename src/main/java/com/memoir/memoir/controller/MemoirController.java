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

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memoir")
@CrossOrigin(origins = "*")
public class MemoirController {
    
    private final MemoirService memoirService;
    
    @GetMapping("")
    public ResponseEntity<List<Memoir>> list() {
        List<Memoir> memoirs = memoirService.findAll();
        return ResponseEntity.ok(memoirs);
    }
    
    @PostMapping("")
    public ResponseEntity<Memoir> create(@RequestBody Memoir memoir) {
        Memoir savedMemoir = memoirService.save(memoir);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMemoir);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Memoir> detail(@PathVariable Long id) {
        return memoirService.findById(id)
                .map(memoir -> ResponseEntity.ok(memoir))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Memoir> update(@PathVariable Long id, @RequestBody Memoir memoir) {
        return memoirService.findById(id)
                .map(existingMemoir -> {
                    memoir.setId(id);
                    Memoir updatedMemoir = memoirService.update(memoir);
                    return ResponseEntity.ok(updatedMemoir);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return memoirService.findById(id)
                .map(memoir -> {
                    memoirService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 