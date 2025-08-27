package com.veltryxworks.studentmanager.model;

import jakarta.persistence.*;

/**
 * Entità JPA (tabella DB).
 *
 * DTO (Data Transfer Object): classi che usi per passare dati al frontend senza esporre tutto il DB.
 *
 * Enum o altre strutture dati comuni.
 */
@Entity
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

}
