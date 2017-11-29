package com.netcracker.project.repository;

import com.netcracker.project.entity.company.CompanyEntity;
import com.netcracker.project.entity.university.FacultyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {

}
