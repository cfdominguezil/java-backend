package com.prueba.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.api.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
