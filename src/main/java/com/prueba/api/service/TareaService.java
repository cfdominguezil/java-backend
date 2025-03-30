package com.prueba.api.service;
import java.util.List;

import com.prueba.api.model.Tarea;

public interface TareaService {
	Tarea create( Tarea t );
	List<Tarea> all();
	Tarea findByID( Long id );
	Tarea update( Long id, Tarea t);
	void delete( Long id);
}
