package com.base_student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base_student.dto.LogEntryDto;
import com.base_student.service.LogEntryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/logs")
public class LogEntryController {

    private final LogEntryService logEntryService;

    public LogEntryController(LogEntryService logEntryService) {
        this.logEntryService = logEntryService;
    }

    @GetMapping
    public ResponseEntity<List<LogEntryDto>> findAll() {
        return ResponseEntity.ok(logEntryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogEntryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(logEntryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LogEntryDto> create(@Valid @RequestBody LogEntryDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(logEntryService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogEntryDto> update(@PathVariable Long id, @Valid @RequestBody LogEntryDto dto) {
        return ResponseEntity.ok(logEntryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logEntryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
