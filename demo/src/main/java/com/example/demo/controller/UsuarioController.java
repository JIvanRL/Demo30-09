package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

//importamos las anotaciones y clases necesarias de spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UsuarioService;


//anotamos la clase como un controlador REST
@RestController
//definimos la ruta base para los endpoints de este controlador
@RequestMapping("/api/usuarios")
public class UsuarioController {
    //inyectamos el servicio usuarioservice
    @Autowired
    private UsuarioService usuarioService;
    //EndPoint para obtener todos los usuarios
    @GetMapping
    public List<com.example.demo.model.Usuario>getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }
    //end point para obtener un usuario por su id
    @GetMapping("/{id}")
    public ResponseEntity<com.example.demo.model.Usuario>getUsuarioById(@PathVariable Long id){
    //llamamos al usuario para obtener el usuario
    Optional<com.example.demo.model.Usuario> usuario=usuarioService.getUsuarioById(id);
    //si el usuario existe, devolvemos una respuesta ok con el usuario
    //si no, devolvemos una respuesta not found
    return usuario.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    //endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<com.example.demo.model.Usuario> createUsuario(@RequestBody com.example.demo.model.Usuario usuario){
        //llamamos al servicio para guardar el nuevo usuario
        com.example.demo.model.Usuario newUsuario= usuarioService.saveUsuario(usuario);
    //devolvemos una respuesta created con el neuvo usuario
    return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }
    //EndPoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        //llmamos al servicio para eliminar el usuario 
        usuarioService.deleteUsusario(id);
        //Devolvemos una respuesta No content
        return ResponseEntity.noContent().build();
    }
    
}

