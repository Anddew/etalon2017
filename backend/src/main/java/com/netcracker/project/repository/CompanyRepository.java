package com.netcracker.project.repository;

import com.netcracker.project.entity.company.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {

    CompanyEntity findById(int id);

    CompanyEntity findByName(String name);

}
