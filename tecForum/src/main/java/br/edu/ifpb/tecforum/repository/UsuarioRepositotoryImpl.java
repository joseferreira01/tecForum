/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tecforum.repository;

import br.edu.ifpb.tecforum.conexao.Conexao;
import br.edu.ifpb.tecforum.conexao.DataBaseException;
import br.edu.ifpb.tecforum.entity.Usuario;
import com.vividsolutions.jts.io.ParseException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioRepositotoryImpl implements UsuarioRepositotory {

    private Conexao conn;
    private StringBuffer sql = null;
    PreparedStatement stat;
    //  private WKTReader reader;
    private Map<String, String> resultado;

    public UsuarioRepositotoryImpl() {
        this.conn = new Conexao();
        this.sql = new StringBuffer();
    }

    @Override
    public void salvar(Usuario u) {

        sql.append("INSERT INTO usuario (nome,email,senha)"
                + "VALUES (?,?,?)");
        try {
            saveBD(u, sql.toString());
        } catch (SQLException | IOException | ClassNotFoundException | URISyntaxException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void atualizar(Usuario entity) {
        sql.append("UPDATE usuario SET nome =?, email =? ,senha =? WHERE id =");
        sql.append(entity.getId());
        sql.append("");

        try {
            saveBD(entity, sql.toString());
        } catch (SQLException | IOException | ClassNotFoundException | URISyntaxException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(int chavePrimaria) {
        Connection connection = conn.init();
        try {

            sql.append("DELETE FROM usuario WHERE id =");
            sql.append(chavePrimaria);
            sql.append("");
            stat = connection.prepareStatement(sql.toString());
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.fecharConexao(connection);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Usuario buscar(String atributo, Object chavePrimaria) {
        sql.append("SELECT * FROM usuario WHERE ");
        sql.append(atributo);
        sql.append("=");
        sql.append(chavePrimaria);
        sql.append("");
        Usuario resutado = new Usuario();
        try {
            resutado = queryBD(sql.toString()).get(0);
        } catch (URISyntaxException | ParseException | IOException | ClassNotFoundException | DataBaseException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resutado;
    }

    @Override
    public List<Usuario> buscarTodos() {
        sql.append("SELECT * FROM usuario");
        List<Usuario> resutado = null;
        try {
            resutado = queryBD(sql.toString());
        } catch (URISyntaxException | ParseException | IOException | ClassNotFoundException | DataBaseException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resutado;
    }

    @Override
    public Usuario login(String Email, String senha) {
      String  query =" SELECT * FROM usuario WHERE email =  '" + Email + "' AND senha = '" + senha + "'";
//      
        Usuario resutado = null;
        try {
             resutado = queryBD(query).get(0);
        } catch (URISyntaxException | ParseException | IOException | ClassNotFoundException | DataBaseException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resutado;
    }

    private void saveBD(Usuario u, String query) throws SQLException, IOException, ClassNotFoundException, URISyntaxException {

        Connection conection = conn.init();
        try {

            stat = conection.prepareStatement(query);
            stat.setString(1, u.getNome());
            stat.setString(2, u.getEmail());
            stat.setString(3, u.getSenha());

            stat.executeUpdate();
        } finally {
            conn.fecharConexao(conection);
        }

    }

    private List<Usuario> queryBD(String query) throws URISyntaxException, ParseException, IOException, ClassNotFoundException, DataBaseException, SQLException {

        List<Usuario> result = null;
        Connection connection = conn.init();
        try {
            //  System.err.println("try list");
System.err.println("sql "+query);
            stat = connection.prepareStatement(query);
            ResultSet rs = stat.executeQuery();
            // System.err.println("passou conn");
            result = montarUsuario(rs);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepositotoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.fecharConexao(connection);
        }

        return result;
    }

    private List<Usuario> montarUsuario(ResultSet rs) throws ParseException, SQLException {
        List<Usuario> list = new ArrayList<>();
        while (rs.next()) {
            Usuario novo = Usuario.of(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
            );
            list.add(novo);
            // System.err.println(" user monte ============= " + novo.toString());
        }
        if (!list.isEmpty()) {

            return list;
        }
        return Collections.EMPTY_LIST;

    }

}
