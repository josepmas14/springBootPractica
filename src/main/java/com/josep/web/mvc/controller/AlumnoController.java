package com.josep.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.josep.web.mvc.entity.Alumno;
import com.josep.web.mvc.service.AlumnoService;
import com.josep.web.mvc.service.ProyectoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/alumnos")
	public String listarAlumnos(Model modelo) {
		modelo.addAttribute("lista_alumno", alumnoService.buscarTodos());
		return "alumno";
	}
	
	@GetMapping({"/proyecto"})
	public String listarProyectos(Model modelo) {
		modelo.addAttribute("proyecto", proyectoService.buscarTodos());
		return "proyectos";
	}
	
	@GetMapping("/alumnos/new")
	public String formularioAlumno(Model modelo) {
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno", alumno);
		return "crear_alumno";
	}
	
	@PostMapping("/alumnos/new")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.grabarAlumno(alumno);
		return"redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/edit/{id}")
	public String formularioEditarAlummno(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("alumno", alumnoService.buscarAlumnoPorId(id));
		return "editar_alumno";
	}
	
	@PostMapping("/alumnos/edit/{id}")
	public String actualizarAlumno(@PathVariable Long id, @ModelAttribute("alumno") Alumno alumno) {
		Alumno alumnoUpdate = alumnoService.buscarAlumnoPorId(id);
		
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setApellido(alumno.getApellido());
		alumnoUpdate.setTelefono(alumno.getTelefono());
		alumnoUpdate.setEmail(alumno.getEmail());
		alumnoUpdate.setDni(alumno.getDni());
		alumnoUpdate.setFechaNac(alumno.getFechaNac());
		
		alumnoService.grabarAlumno(alumnoUpdate);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/eliminar/{id}")
	public String eliminarAlumno(@PathVariable Long id){
		alumnoService.borrarAlumno(id);
		return "redirect:/alumnos";
	}
	
	
}
