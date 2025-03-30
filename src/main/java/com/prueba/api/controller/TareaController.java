package com.prueba.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.prueba.api.service.TareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prueba.api.model.Tarea;

@RestController
@RequestMapping("/api/tareas")
@Tag(name = "Tareas", description = "API para la gestión de Tareas")
public class TareaController {

	private final TareaService tareaService;
	
	
	public TareaController( TareaService tareaService ) {
		this.tareaService = tareaService;
	}
	
	
	@GetMapping
	@Operation(summary = "Obtener todas las tareas", description = "Retorna una lista de tareas almacenados en la base de datos")
	public ResponseEntity<List<Tarea>> all() {
		List<Tarea> tareas = tareaService.all();
		return ResponseEntity.ok( tareas );
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Obtener una tarea", description = "Retorna una tarea almacenada en la base de datos")
	public ResponseEntity<Tarea> findByID( @PathVariable Long id) {
		Tarea t = tareaService.findByID(id);
		return ResponseEntity.ok( t );
	}
	
	@PostMapping
	@Operation(summary = "Crea una nueva tarea", description = "Crea en la base de datos y retorna la nueva tarea")
	public ResponseEntity<Tarea> crear( @RequestBody Tarea tarea ) {
		Tarea t = tareaService.create(tarea);
		return ResponseEntity.ok(t);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Actualiza una tarea existente", description = "Actualiza en la base de datos y retorna la tarea actualizada")
	public ResponseEntity<Tarea> actualizar( @PathVariable Long id, @RequestBody Tarea tarea ) {
		Tarea t = tareaService.update(id, tarea);
		return ResponseEntity.ok(t);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Elimina una tarea existente", description = "Elimina de la base de datos una tarea existente")
	public ResponseEntity<Void> eliminar( @PathVariable Long id ) {
		tareaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
