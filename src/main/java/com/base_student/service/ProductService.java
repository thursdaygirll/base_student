package com.base_student.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.base_student.dto.ProductDto;
import com.base_student.model.ProductModel;
import com.base_student.respository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductModel::toDto).toList();
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id)
                .map(ProductModel::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found with id: " + id));
    }

    public ProductDto save(ProductDto dto) {
        ProductModel saved = productRepository.save(dto.toModel());
        return saved.toDto();
    }

    public ProductDto update(Long id, ProductDto dto) {
        productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found with id: " + id));
        dto.setId(id);
        ProductModel updated = productRepository.save(dto.toModel());
        return updated.toDto();
    }

    public void delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found with id: " + id));
        productRepository.deleteById(id);
    }
}
