package com.example.demo.model;
import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity

public class Usuario {
    @jakarta.persistence.Id //es la lclave primaria de la entidad
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id; //Identificar unico para cada usuario
    private String correo;
    private String nombre;

    //metodos getter y setter para acceder y modificar los campos privados

public Long getId()  //get obtener, set establecer
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }
    public String getCorreo()
    {
        return correo;
    }
    public void setCorreo(String correo)
    {
        this.correo= correo;
    }
}
 


