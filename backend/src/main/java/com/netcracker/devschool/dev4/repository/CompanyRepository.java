package com.netcracker.devschool.dev4.repository;

import com.netcracker.devschool.dev4.entity.company.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {

    CompanyEntity findById(int id);

    CompanyEntity findByName(String name);

}
