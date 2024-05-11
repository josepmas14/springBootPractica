package com.josep.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josep.web.mvc.dao.ProyectoRepository;
import com.josep.web.mvc.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	public List<Proyecto> buscarTodos() {
		return (List<Proyecto>) proyectoRepository.findAll();
	}

	@Override
	public Proyecto buscarProyectoPorId(Long id) {
		return proyectoRepository.findById(id).get();
	}

	@Override
	public Proyecto grabarProyecto(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	@Override
	public void borrarProyecto(Long id) {
		proyectoRepository.deleteById(id);		
	}

}
