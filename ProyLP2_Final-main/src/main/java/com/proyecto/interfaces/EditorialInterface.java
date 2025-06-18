package com.proyecto.interfaces;

import java.util.List;

import com.proyecto.models.EditorialEntity;

public interface EditorialInterface {
    List<EditorialEntity> listadoEditoriales();
    void reistrarEditorial(EditorialEntity nuevaEditorial);
    EditorialEntity buscarEditorialPorId(Integer id);
    void actualizarEditorial(Integer id, EditorialEntity editorialActualizada);
    void eliminarEditorial(Integer id);
}
