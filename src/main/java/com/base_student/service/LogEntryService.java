package com.base_student.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.base_student.dto.LogEntryDto;
import com.base_student.model.LogEntryModel;
import com.base_student.respository.LogRepository;

@Service
public class LogEntryService {

    private final LogRepository logRepository;

    public LogEntryService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogEntryDto> findAll() {
        return logRepository.findAll().stream().map(LogEntryModel::toDto).toList();
    }

    public LogEntryDto findById(Long id) {
        return logRepository.findById(id)
                .map(LogEntryModel::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Log entry not found with id: " + id));
    }

    public LogEntryDto save(LogEntryDto dto) {
        LogEntryModel saved = logRepository.save(dto.toModel());
        return saved.toDto();
    }

    public LogEntryDto update(Long id, LogEntryDto dto) {
        logRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Log entry not found with id: " + id));
        dto.setId(id);
        LogEntryModel updated = logRepository.save(dto.toModel());
        return updated.toDto();
    }

    public void delete(Long id) {
        logRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Log entry not found with id: " + id));
        logRepository.deleteById(id);
    }
}
