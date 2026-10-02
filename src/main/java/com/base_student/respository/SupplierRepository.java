package com.base_student.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base_student.model.SupplierModel;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
}
