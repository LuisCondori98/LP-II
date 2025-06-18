package com.proyecto.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.AdministradorEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdministradorEntity, Integer>{
	
	AdministradorEntity findByEmail(String email);
}
