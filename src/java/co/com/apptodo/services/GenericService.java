/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apptodo.services;

import java.util.List;

/**
 * 
 * @author Jhonny <jegm@hotmail.com>
 */
public interface GenericService<Entity, Key> {
    
    void insertar(Entity obj);
    
    Entity consultarPorId(Key id, Class<Entity> clazz);
    
    void modificar(Entity obj);
    
    void eliminar(Key id, Class clazz);
    
    List<Entity> listarTodo(Class clazz);
}
