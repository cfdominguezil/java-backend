package com.prueba.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.prueba.api.controller.TareaController;
import com.prueba.api.model.Tarea;
import com.prueba.api.service.TareaService;

@SpringBootTest
class ApiApplicationTests {

	@Mock
    private TareaService tareaService;

    @InjectMocks
    private TareaController tareaController;

    private Tarea tarea;

    @BeforeEach
    void setUp() {
        tarea = new Tarea();
        tarea.setId(1L);
        tarea.setTarea("Tarea de prueba");
    }

    @Test
    void testAll() {
        when(tareaService.all()).thenReturn(Arrays.asList(tarea));

        ResponseEntity<List<Tarea>> response = tareaController.all();
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testFindByID() {
        when(tareaService.findByID(1L)).thenReturn(tarea);

        ResponseEntity<Tarea> response = tareaController.findByID(1L);
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testCrear() {
        when(tareaService.create(any(Tarea.class))).thenReturn(tarea);

        ResponseEntity<Tarea> response = tareaController.crear(tarea);
        assertNotNull(response.getBody());
        assertEquals("Tarea de prueba", response.getBody().getTarea());
    }

    @Test
    void testActualizar() {
        when(tareaService.update(eq(1L), any(Tarea.class))).thenReturn(tarea);

        ResponseEntity<Tarea> response = tareaController.actualizar(1L, tarea);
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testEliminar() {
        doNothing().when(tareaService).delete(1L);

        ResponseEntity<Void> response = tareaController.eliminar(1L);
        assertEquals(204, response.getStatusCodeValue());
    }

}
