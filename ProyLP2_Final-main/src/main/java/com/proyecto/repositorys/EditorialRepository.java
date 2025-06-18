package com.proyecto.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.EditorialEntity;

@Repository
public interface EditorialRepository extends JpaRepository<EditorialEntity,Integer>{
    
}
