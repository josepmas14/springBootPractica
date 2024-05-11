package com.josep.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josep.web.mvc.entity.Proyecto;
import com.josep.web.mvc.service.ProyectoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "/**")
public class ProyectoController {

	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/proyectos")
	public List<Proyecto> indexProy(){
		return proyectoService.buscarTodos();
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto muestraProyectoId(@PathVariable Long id) {
		return proyectoService.buscarProyectoPorId(id);
	}
	
	@PostMapping("/proyectos")
	public Proyecto grabaProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.grabarProyecto(proyecto);
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizaProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
		Proyecto proyectoUpdate = proyectoService.buscarProyectoPorId(id);
		proyectoUpdate.setNombre(proyecto.getNombre());
		proyectoUpdate.setDescripcion(proyecto.getDescripcion());
		proyectoUpdate.setFechaInicio(proyecto.getFechaInicio());
		proyectoUpdate.setFecha_fin(proyecto.getFecha_fin());
		proyectoUpdate.setActivo(proyecto.isActivo());
		
		return proyectoService.grabarProyecto(proyectoUpdate);
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void eliminaProyecto(@PathVariable Long id) {
		proyectoService.borrarProyecto(id);	
	}
}
