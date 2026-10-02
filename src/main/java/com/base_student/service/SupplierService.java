package com.base_student.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.base_student.dto.SupplierDto;
import com.base_student.model.SupplierModel;
import com.base_student.respository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDto> findAll() {
        return supplierRepository.findAll().stream().map(SupplierModel::toDto).toList();
    }

    public SupplierDto findById(Long id) {
        return supplierRepository.findById(id)
                .map(SupplierModel::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Supplier not found with id: " + id));
    }

    public SupplierDto save(SupplierDto dto) {
        SupplierModel saved = supplierRepository.save(dto.toModel());
        return saved.toDto();
    }

    public SupplierDto update(Long id, SupplierDto dto) {
        supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Supplier not found with id: " + id));
        dto.setId(id);
        SupplierModel updated = supplierRepository.save(dto.toModel());
        return updated.toDto();
    }

    public void delete(Long id) {
        supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Supplier not found with id: " + id));
        supplierRepository.deleteById(id);
    }
}
