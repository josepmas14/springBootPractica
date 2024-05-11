package com.josep.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josep.web.mvc.dao.AlumnoRepository;
import com.josep.web.mvc.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public List<Alumno> buscarTodos() {
		return (List<Alumno>) alumnoRepository.findAll();
	}

	@Override
	public Alumno buscarAlumnoPorId(Long id) {
		return alumnoRepository.findById(id).get();
	}

	@Override
	public Alumno grabarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public void borrarAlumno(Long id) {
		alumnoRepository.deleteById(id);
	}


}
