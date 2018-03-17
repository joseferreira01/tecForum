/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tecforum.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author jose
 */
public class Topico {
    private String titulo;
    private String conteudo;
    private LocalDateTime data;
    private List<String> comentarios;
    private Categoria categoria;
}
