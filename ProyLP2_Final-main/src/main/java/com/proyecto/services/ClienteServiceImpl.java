package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.interfaces.ClienteInterface;
import com.proyecto.models.ClienteEntity;
import com.proyecto.repositorys.ClienteRepository;
import com.proyecto.utils.Utilitarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteInterface{
    
	@Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> listadoClients() {
        // TODO Auto-generated method stub
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity buscarClientePorId(Integer id) {
        // TODO Auto-generated method stub
        return clienteRepository.findById(id).get();
    }

	@Override
	public void crearCliente(ClienteEntity clienteEntity, MultipartFile foto) {
		String urlFoto = Utilitarios.guardarImagen(foto);
		clienteEntity.setUrlImagen(urlFoto);
		String hashearPassword = Utilitarios.hashPassword(clienteEntity.getContrasenia());
		clienteEntity.setContrasenia(hashearPassword);
		clienteRepository.save(clienteEntity);
	}
}
