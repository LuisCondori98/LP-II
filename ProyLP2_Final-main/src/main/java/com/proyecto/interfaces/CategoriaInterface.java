package com.proyecto.interfaces;

import java.util.List;

import com.proyecto.models.CategoriaEntity;

public interface CategoriaInterface {
	
	
	
	List<CategoriaEntity> listadoCategorias();

	void registrarCategoria(CategoriaEntity categoriaNueva);

	CategoriaEntity buscarCategoriaPorId(Integer id);

	void actualizarCategoria(Integer id, CategoriaEntity categoriaActualizada);

	void eliminarCategoria(Integer id);
	

}
