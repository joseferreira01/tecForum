/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tecforum.repository;

import br.edu.ifpb.tecforum.entity.Usuario;

/**
 *
 * @author jose
 */
public interface UsuarioRepositotory extends  Repository<Usuario>{
      Usuario login(String Email, String password);
}
