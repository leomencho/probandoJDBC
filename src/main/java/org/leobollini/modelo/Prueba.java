package org.leobollini.modelo;

public class Prueba {

    public Prueba() {
    }

    public Prueba(Long id, String nombre, String otro) {
        this.id = id;
        this.nombre = nombre;
        this.otro = otro;
    }

    private Long id;

    private String nombre;

    private String otro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }
}
