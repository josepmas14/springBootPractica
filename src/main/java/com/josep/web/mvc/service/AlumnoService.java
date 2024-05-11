package com.josep.web.mvc.service;

import java.util.List;

import com.josep.web.mvc.entity.Alumno;



public interface AlumnoService {
	
	// método para devolver todos los Alumnos
	public List<Alumno> buscarTodos();
	
	// método para buscar un alumno por ID
	public Alumno buscarAlumnoPorId(Long id);
	
	// Método para insertar alumno en base de datos
	public Alumno grabarAlumno(Alumno alumno);
	
	// Método para borrar un alumno
	public void borrarAlumno(Long id);
	
	
}
