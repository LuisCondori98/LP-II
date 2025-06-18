package com.proyecto.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.LibroCategoriaEntity;
import com.proyecto.models.LibroCategoriaId;

public interface LibroCategoriaInterface {
    
    LibroCategoriaEntity guardarLibroCategoria(LibroCategoriaEntity libroCategoria);

    LibroCategoriaEntity actualizarLibroCategoria( LibroCategoriaId id , LibroCategoriaEntity libroCategoria);

    void eliminarLibroCategoria(LibroCategoriaId id);

    Optional<LibroCategoriaEntity> buscarLibroCategoriaPorId(LibroCategoriaId id);

    List<LibroCategoriaEntity> listarTodosCategoriaLibro();
}
