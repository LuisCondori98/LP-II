package com.proyecto.interfaces;

import java.util.List;

import com.proyecto.models.AutorEntity;

public interface AutorInterface {
    List<AutorEntity>listadoAutores();
    void registrarAutor(AutorEntity nuevoAutor);
    AutorEntity buscarAutorPorId(Integer id);
    void actualizarAutor(Integer id, AutorEntity autorActualizado);
    void eliminarAutor(Integer id);
}
