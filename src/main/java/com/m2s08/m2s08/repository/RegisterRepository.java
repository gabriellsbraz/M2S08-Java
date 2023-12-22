package com.m2s08.m2s08.repository;

import com.m2s08.m2s08.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
}