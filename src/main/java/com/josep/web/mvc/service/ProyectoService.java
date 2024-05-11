package com.josep.web.mvc.service;

import java.util.List;

import com.josep.web.mvc.entity.Proyecto;

public interface ProyectoService {
	// método para devolver todos los proyectos
	public List<Proyecto> buscarTodos();
	
	// método para buscar un proyecto por ID
	public Proyecto buscarProyectoPorId(Long id);
	
	// Método para insertar proyecto en base de datos
	public Proyecto grabarProyecto(Proyecto proyecto);
	
	// Método para borrar un proyecto
	public void borrarProyecto(Long id);
}
