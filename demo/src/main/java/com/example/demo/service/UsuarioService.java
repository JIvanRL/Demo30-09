package com.example.demo.service;
import java.util.List;
import java.util.Optional;
//anotamos la clase como un servicio de Spring

//importamos las anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//importamos la clase Usuario que representa la entidad
import com.example.demo.model.Usuario;
//importamos el repositorio UsuarioRepository que interactúa con la base de datos
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    // inyectamos el repositorio UsuarioRepository
    @Autowired
    private UsuarioRepository usuarioRepository;

    //metodo para obtener todos los usuarios
    public List<Usuario> getAllUsuarios()
    {
        //utilizamos el repositorio para encontrar y devolver todos los usuarios
        return usuarioRepository.findAll();
    }

    //metodo para obtener todos los susuarios por su ID
    public Optional<Usuario> getUsuarioById(Long id)
    {
        //utiliza el repositorio para encontrar un susario por su Id
        return usuarioRepository.findById(id);
    }

    //metodo para guardar un nuevo usuario o actualizar uno existente
    public Usuario saveUsuario(Usuario usuario)
    {
        //utiliza el repositorio para guardar el usuario
        return usuarioRepository.save(usuario);
    }

    //metodo para eliminar un usuario por su ID
    public void deleteUsusario(Long id)
    {
        //utiliza el repositorio para eliminar el usuario por su Id
        //nota: es necesario trabajar con ESTADOS 1 activo y inactivos cuando se trabaja en la BD
        usuarioRepository.deleteById(id);
    }
}
