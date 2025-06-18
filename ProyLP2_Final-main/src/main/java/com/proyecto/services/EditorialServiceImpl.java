package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.interfaces.EditorialInterface;
import com.proyecto.models.EditorialEntity;
import com.proyecto.repositorys.EditorialRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditorialServiceImpl implements EditorialInterface {
    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public List<EditorialEntity> listadoEditoriales() {
        // TODO Auto-generated method stub
        return editorialRepository.findAll();
    }

    @Override
    public void reistrarEditorial(EditorialEntity nuevaEditorial) {
        // TODO Auto-generated method stub
        editorialRepository.save(nuevaEditorial);
    }

    @Override
    public EditorialEntity buscarEditorialPorId(Integer id) {
        // TODO Auto-generated method stub
        return editorialRepository.findById(id).get();
    }

    @Override
    public void actualizarEditorial(Integer id, EditorialEntity editorialActualizada) {
        // TODO Auto-generated method stub
        EditorialEntity editorialEncontrada = buscarEditorialPorId(id);

        if (editorialEncontrada==null) {
            throw new RuntimeException("Editorial no encontrda");
        }
        try {
            editorialEncontrada.setNombreEditorial(editorialActualizada.getNombreEditorial());
            editorialRepository.save(editorialEncontrada);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Error al actuaizar");
        }
    }

    @Override
    public void eliminarEditorial(Integer id) {
        // TODO Auto-generated method stub
        EditorialEntity editorialEncontrada = buscarEditorialPorId(id);

        if (editorialEncontrada==null) {
            throw new RuntimeException("Editorial no encontrda");
        }
        editorialRepository.delete(editorialEncontrada);
    }
    
}
