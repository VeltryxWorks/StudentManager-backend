package com.veltryxworks.studentmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Qui ci sono le API REST: gestiscono le richieste HTTP (GET, POST, PUT, DELETE) e rispondono al frontend (es. Flutter).
 *
 * Non fanno logica complessa, solo coordinano.
 *
 * Usano le service per recuperare/elaborare dati.
 */
@RestController
@RequestMapping("/api/todos")
public class ToDoController {
}
