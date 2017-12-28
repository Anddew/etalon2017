package com.netcracker.project.repository;

import com.netcracker.project.entity.company.CompanyEntity;
import org.springframework.data.repository.CrudRepository;


public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {
}
