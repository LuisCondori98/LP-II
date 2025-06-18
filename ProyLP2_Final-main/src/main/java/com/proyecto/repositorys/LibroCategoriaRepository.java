package com.proyecto.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.LibroCategoriaEntity;
import com.proyecto.models.LibroCategoriaId;

@Repository
public interface LibroCategoriaRepository extends JpaRepository<LibroCategoriaEntity, LibroCategoriaId>{

}
