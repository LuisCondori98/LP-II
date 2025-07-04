package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.interfaces.LibroCategoriaInterface;
import com.proyecto.models.LibroCategoriaEntity;
import com.proyecto.models.LibroCategoriaId;
import com.proyecto.repositorys.LibroCategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LibroCategoriaServiceImpl implements LibroCategoriaInterface{

	@Autowired
	private LibroCategoriaRepository libroCategoriaRepository;
	
	@Override
	public LibroCategoriaEntity guardarLibroCategoria(LibroCategoriaEntity libroCategoria) {
        return libroCategoriaRepository.save(libroCategoria);
    }

	@Override
	public void eliminarLibroCategoria(LibroCategoriaId id) {
		Optional<LibroCategoriaEntity> categoriaEncontradaOpt = buscarLibroCategoriaPorId(id);

        if (categoriaEncontradaOpt.isEmpty()) {
            throw new RuntimeException("Categoría no encontrada");
        }

        libroCategoriaRepository.delete(categoriaEncontradaOpt.get());
    }
		
	

	@Override
	public Optional<LibroCategoriaEntity> buscarLibroCategoriaPorId(LibroCategoriaId id) {
        return libroCategoriaRepository.findById(id);
    }

	@Override
	public List<LibroCategoriaEntity> listarTodosCategoriaLibro() {
		
		return libroCategoriaRepository.findAll();
	}

	@Override
	public LibroCategoriaEntity actualizarLibroCategoria(LibroCategoriaId id, LibroCategoriaEntity libroCategoria) {
        Optional<LibroCategoriaEntity> categoriaEncontradaOpt = buscarLibroCategoriaPorId(id);

        if (categoriaEncontradaOpt.isEmpty()) {
            throw new RuntimeException("Categoría no encontrada");
        }

        LibroCategoriaEntity categoriaEncontrada = categoriaEncontradaOpt.get();

        // Actualiza las propiedades según sea necesario
        categoriaEncontrada.setLibro(libroCategoria.getLibro());
        categoriaEncontrada.setCategoria(libroCategoria.getCategoria());

        return libroCategoriaRepository.save(categoriaEncontrada);
    }

	

}
