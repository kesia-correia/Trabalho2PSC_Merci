/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.trabalho2.kesia.persistencia;

import br.edu.ifnmg.trabalho2.kesia.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Késia Correiia
 */
public class UsuarioDAO {
private static final String INSERT = "INSERT INTO USUARIO (NOME, LOGIN,SENHA, TIPO_USUARIO) VALUES (?, ?, ?, ?)";
private static final String SELECT_TODOS = "SELECT NOME, LOGIN, SENHA, TIPO_USUARIO, ID FROM USUARIO ORDER BY NOME";
private static final String DELETE = "DELETE FROM USUARIO WHERE LOGIN=?";
private static final String UPDATE = "UPDATE USUARIO SET NOME = ?, LOGIN=?, SENHA = ?, TIPO_USUARIO=? WHERE ID = ?";
private static final String BUSCAR_LOGIN_E_SENHA = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ? ";
private static final String LOGIN = "SELECT * FROM USUARIO WHERE LOGIN = ?";
private final String BUSCAR_TIPO_USUARIO = "SELECT * FROM USUARIO WHERE TIPO_USUARIO = ?";
private static final String UPDATE_SENHA = "UPDATE USUARIO SET SENHA = ? WHERE ID = ?";

public void inserir(Usuario usuario) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(INSERT);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getLogin());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTipoUsuario());
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

     public void alterar(Usuario usuario) throws SQLException {
       Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(UPDATE);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getLogin());
            comando.setString(3, usuario.getSenha());
            comando.setString(4, usuario.getTipoUsuario());
            comando.setInt(5, usuario.getID());
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }
     
    public void excluir(String Login) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(DELETE);        
            comando.setString(1, Login);
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }
     
     public List<Usuario> buscarTodos() throws SQLException{
        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SELECT_TODOS);
            resultado = comando.executeQuery();           
            while(resultado.next()){
                Usuario usuario = this.extrairLinhaResultadoBuscarTodas(resultado);
                listaUsuarios.add(usuario);
            }    
        }finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        return listaUsuarios;
    }
      
    public List<Usuario> carregarTabelaTipoUsuario(String tipoUsuario) throws SQLException{
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;           
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(BUSCAR_TIPO_USUARIO);
            
            comando.setString(1, tipoUsuario);
            resultado = comando.executeQuery();
            while(resultado.next()){
                usuario = new Usuario();
                usuario.setID(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setLogin(resultado.getString(3));
                usuario.setSenha(resultado.getString(4));
                usuario.setTipoUsuario(resultado.getString(5));
                listaUsuarios.add(usuario);
            }
        }catch(Exception e){
            if(conexao != null){
                conexao.rollback();
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            return listaUsuarios;
    }
  
    public Usuario login(String login, String senha) throws SQLException{
    
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuario = null;   
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(BUSCAR_LOGIN_E_SENHA); 
            comando.setString(1, login); 
            comando.setString(2, senha);
            resultado = comando.executeQuery();           
            while(resultado.next()){
                usuario = new Usuario();
                usuario.setID(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setLogin(resultado.getString(3));
                usuario.setSenha(resultado.getString(4));
                usuario.setTipoUsuario(resultado.getString(5));
            }
        }catch(Exception e){
            if(conexao != null){
            conexao.rollback();           
            } 
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuario;
    }
    
    public Usuario buscarByLogin(String login) throws SQLException{
        Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(LOGIN);
            comando.setString(1, login);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                usuario = new Usuario();
                usuario.setID(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setLogin(resultado.getString(3));
                usuario.setSenha(resultado.getString(4));
                usuario.setTipoUsuario(resultado.getString(5));
            }
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuario;
    }
    
    public void atualizarDadosSenha(Usuario usuario) throws SQLException{
        PreparedStatement comando = null;
        Connection conexao = null;    
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(UPDATE_SENHA);
            comando.setString(1, usuario.getSenha());
            comando.setInt(2, usuario.getID());
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
     
    private Usuario extrairLinhaResultadoBuscarTodas(ResultSet resultado) throws SQLException {
        Usuario usuario = this.extrairLinhaResultado(resultado);
        return usuario;
    }

    private Usuario extrairLinhaResultado(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNome(resultado.getString(1));
        usuario.setLogin(resultado.getString(2));
        usuario.setSenha(resultado.getString(3));
        usuario.setTipoUsuario(resultado.getString(4));
        usuario.setID(resultado.getInt(5));

        return usuario;
    }   
}
