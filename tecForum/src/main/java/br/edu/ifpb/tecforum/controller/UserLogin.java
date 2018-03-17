/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tecforum.controller;

import br.edu.ifpb.tecforum.util.Mensagem;
import br.edu.ifpb.tecforum.entity.Usuario;
import br.edu.ifpb.tecforum.service.UserService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@SessionScoped
public class UserLogin implements Serializable{
    
    private UserService userService;
    private String login;
    private String password;
       @Inject
     private Mensagem msg;
      public void init(){
          this.userService = new UserService();
      }
        public String logar() {
            try {
                  
        Usuario result = userService.login(login, password);
                System.err.println("retorno "+result);
        if (result != null) {
            
            msg.addMessage ("Bem vindo "+result.getNome()+"!");
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", result);
            return "viewAvaliacao?faces-redirect=true";
      
        }
            } catch (Exception e) {
                 msg.addMessage("Usuário ou senha inválido");
            }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
        
}
