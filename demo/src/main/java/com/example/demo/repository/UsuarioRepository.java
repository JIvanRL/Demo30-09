package com.example.demo.repository;
//imposrtamos la clase del Usuario que representará la entidad
//importamos la interfaz JPA CRUD
//importamos la clase Usuario que representa la entidad

// importamos la interfaz JPARepository que nos proporciona metodos CRUD estandar
import org.springframework.data.jpa.repository.JpaRepository;
//importamos la anotacion Repository que indica que esta interfaz es un repositorio
import org.springframework.stereotype.Repository;
//indicamos que esta interfaz es un repositorio con la @

import com.example.demo.model.Usuario;

@Repository
//definicmos la interfaz UsuarioRepository que extiende Jpa Repository
//JpaRepository<T,ID> toma dos parametros: la entidad y el tipo de la clave primaria

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}
