package com.proyecto.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.models.ClienteEntity;

public interface ClienteInterface {
	void crearCliente(ClienteEntity clienteEntity, MultipartFile foto);
    List<ClienteEntity> listadoClients();
    ClienteEntity buscarClientePorId(Integer id);
}
