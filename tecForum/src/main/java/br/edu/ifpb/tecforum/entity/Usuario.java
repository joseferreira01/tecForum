/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tecforum.entity;

/**
 *
 * @author jose
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    private Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    private Usuario(String nome, String email, String senha) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Método util para criar um objeto do tipo Usuario
     *
     * @param id
     * @param nome
     * @param email
     * @param senha
     * @return retorna um objeto do tipo Usuario
     */
    public static Usuario of(int id, String nome, String email, String senha) {
        return new Usuario(id, nome, email, senha);
    }

    /**
     * Método util para criar um objeto do tipo Usuario
     *
     * @param nome
     * @param email
     * @param senha
     * @return retorna um objeto do tipo Usuario
     */
    public static Usuario of(String nome, String email, String senha) {
        return new Usuario(nome, email, senha);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }

}
