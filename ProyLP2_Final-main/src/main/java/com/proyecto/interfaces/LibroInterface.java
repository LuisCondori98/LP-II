package com.proyecto.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.models.Inventario;
import com.proyecto.models.LibroEntity;

public interface LibroInterface {
    List<LibroEntity>listadoLibros();
    void registrarLibro(LibroEntity nuevoLibro, MultipartFile imagen);
    Optional<LibroEntity> buscarLibroPorISBN(String isbn);
    void actualizarLibro(String isbn, LibroEntity libroActualizado, MultipartFile imagen);
    void eliminarLibro(String isbn);
   
    List<Inventario> listaInventario();

}
