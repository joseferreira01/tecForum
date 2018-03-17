/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tecforum.service;

import br.edu.ifpb.tecforum.entity.Usuario;
import br.edu.ifpb.tecforum.repository.UsuarioRepositotory;
import br.edu.ifpb.tecforum.repository.UsuarioRepositotoryImpl;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jose
 */


public class UserService {
    
     private UsuarioRepositotory repository;
      
    private UserValidation validation;

    public UserService() {
        this.repository = new UsuarioRepositotoryImpl();
        validation = new UserValidation();
    }
     
    public Map<String, String> salve(Usuario u){
         Map<String, String> execute = validation.execute(u);
         if(execute.get("passou").equalsIgnoreCase("true"))
        repository.salvar(u);
        return execute;
         
    }
    public Map<String, String> atualizar(Usuario u){
        Map<String, String> execute = validation.execute(u);
         if(execute.get("passou").equalsIgnoreCase("true"))
        repository.atualizar(u);
        return execute;
    }
      public Usuario buscar(String atributo, Object valor){
        return this.repository.buscar(atributo, valor);
        
    }
       public List<Usuario> buscarTodos(){
        return this.repository.buscarTodos();
}
       public Usuario login(String login, String password){
          if (login == null || login.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return null;
        } else {
            Usuario usuario = repository.login(login, password);
          //  System.out.println("login sev -> "+l);
            return usuario;
        }
       }
}
       
