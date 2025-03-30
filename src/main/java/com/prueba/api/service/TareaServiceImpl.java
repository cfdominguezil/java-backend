package com.prueba.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.api.model.Tarea;
import com.prueba.api.repositories.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService {

	@Autowired
	TareaRepository tareaRepository;

	@Override
	public Tarea create(Tarea t) {
		return tareaRepository.save(t);
	}

	@Override
	public List<Tarea> all() {
		return tareaRepository.findAll();
	}

	@Override
	public Tarea findByID(Long id) {
		return tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no Encontrada"));
	}

	@Override
	public Tarea update(Long id, Tarea tarea) {
		Tarea t = findByID(id);
		t.setTarea( tarea.getTarea() );
		t.setDone( tarea.getDone() );
		return tareaRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		tareaRepository.deleteById(id);
	}

}
