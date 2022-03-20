package es.joseluisgs.dam.controllers;

import es.joseluisgs.dam.models.Persona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Controlador de usuarios
 */
public class UsuariosController {
    private static UsuariosController instance;

    // Repositorio de la información
    List<Persona> personaRepository = new ArrayList<>();

    private UsuariosController() {
    }

    public static UsuariosController getInstance() {
        if (instance == null) {
            instance = new UsuariosController();
        }
        return instance;
    }

    /**
     * Añade un usuario al repositorio
     * @param nombre Nombre del usuario
     * @param edad Edad del usuario
     * @return El usuario creado o null si no se ha podido crear
     */
    public Persona crearUsuario(String nombre, int edad) {
        var persona = new Persona(nombre, edad);
        var res = personaRepository.add(persona);
        if (res) {
            return persona;
        } else {
            return null;
        }
    }

    /**
     * Busca un usuario por su nombre
     * @param nombre Nombre del usuario
     * @return El usuario o null si no se ha encontrado
     */
    public Persona buscarPorNombre(String nombre) {
        // Search for the user
       for (var persona : personaRepository) {
           if (persona.getNombre().equals(nombre)) {
               return persona;
           }
       }
        return null;
    }

    /**
     * Elimina un usuario del repositorio dado su nombre
     * @param nombre Nombre del usuario
     * @return El usuario o null si no se ha completado con éxito
     */
    public Persona eliminarPorPorNombre(String nombre) {
        var persona = buscarPorNombre(nombre);
        if (persona != null) {
            if (personaRepository.remove(persona)) {
                return persona;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Actualiza los datos de una persona
     * @param nombre nombre de la persona a cambiar los datos
     * @param nuevosDatos nuevos datos de la persona
     * @return El usuario o null si no se ha completado con éxito
     */
    public Persona actualizarUsuarioPorNombre(String nombre, Persona nuevosDatos) {
        var persona = buscarPorNombre(nombre);
        if (persona != null) {
            /*int index = personaRepository.indexOf(persona);
            persona.setNombre(nuevosDatos.getNombre());
            persona.setEdad(nuevosDatos.getEdad());
            personaRepository.set(index, persona);*/
            persona.setNombre(nuevosDatos.getNombre());
            persona.setEdad(nuevosDatos.getEdad());
            return persona;
        } else {
            return null;
        }
    }

    /**
     * Devuelve todos los usuarios del repositorio
     * @return Lista de usuarios
     */
    public List<Persona> obtenerTodos() {
        // Es facil :)
        return personaRepository;
    }
}
