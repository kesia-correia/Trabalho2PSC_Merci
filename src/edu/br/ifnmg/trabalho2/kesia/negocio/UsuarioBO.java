/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.br.ifnmg.trabalho2.kesia.negocio;

import edu.br.ifnmg.trabalho2.kesia.entidade.Usuario;
import edu.br.ifnmg.trabalho2.kesia.excecao.ConsultaSemResultadoException;
import edu.br.ifnmg.trabalho2.kesia.excecao.UsuarioLoginExistenteException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarLoginESenhaException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarLoginException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarSenhaAlterarSenhaException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarSenhaException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarTamanhoConfirmaSenhaException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarTamanhoLoginException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarTamanhoNomeException;
import edu.br.ifnmg.trabalho2.kesia.excecao.ValidarTamanhoSenhaException;
import edu.br.ifnmg.trabalho2.kesia.persistencia.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Késia Correiia
 */
public class UsuarioBO {
     public void inserir(Usuario usuario) throws SQLException{
        this.validarTamanhoNome(usuario);
        this.validarTamanhoLogin(usuario);
        this.validarTamanhoSenha(usuario);   
        this.validarSenha(usuario);
        this.validarLogin(usuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }
    
   public void excluir(String Login) throws SQLException{
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      usuarioDAO.excluir(Login);
    }
   
   public void alterar(Usuario usuario) throws Exception{
        this.validarTamanhoNome(usuario);
        this.validarTamanhoLogin(usuario);
        this.validarTamanhoSenha(usuario);   
        this.validarSenha(usuario);
        this.validarLogin(usuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.alterar(usuario);
   }
    
    public List<Usuario> buscarTodos() throws SQLException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarTodos();
    }
    
    public List<Usuario> buscarPorTipoUsuario(String tipoUsuario) throws SQLException{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.carregarTabelaTipoUsuario(tipoUsuario);
    }
   
      public Usuario login(String login, String senha) throws SQLException{
         Usuario usuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioExistente = usuarioDAO.login(login, senha);
        if (usuarioExistente != null) {
            return usuarioExistente;
        }else{
            throw new ValidarLoginESenhaException();
        }
    }
        
     public void verificaUsuarioLoginExistente(Usuario usuario) throws SQLException {
        Usuario usuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioExistente = usuarioDAO.buscarByLogin(usuario.getLogin());
        if (usuarioExistente != null) {
            throw new UsuarioLoginExistenteException();
        }
    }
     
     public Usuario pesquisar(Usuario usuario) throws SQLException {
        Usuario usuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioExistente = usuarioDAO.buscarByLogin(usuario.getLogin());
        if(usuarioExistente != null){
            return usuarioExistente;
        }else{
            throw new ConsultaSemResultadoException();
        }
    }
  
    public void atualizarDadosSenha(Usuario usuario) throws SQLException {
        this.validarTamanhoSenha(usuario);
        this.validarTamanhoConfirmaSenha(usuario);
        this.validarSenhaAlterarSenha(usuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.atualizarDadosSenha(usuario);
    } 
    
    private void validarSenha(Usuario usuario){
         String replaceAll = usuario.getSenha().replaceAll("[^a-zA-Z0-9 ]", "");
         if(usuario.getSenha() == null ? replaceAll != null : !usuario.getSenha().equals(replaceAll)){
             throw new ValidarSenhaException();
         }
    }
    
    
    private void validarSenhaAlterarSenha(Usuario usuario){
         String replaceAll = usuario.getConfirmaSenha().replaceAll("[^a-zA-Z0-9 ]", "");
         if(usuario.getSenha() == null ? replaceAll != null : !usuario.getConfirmaSenha().equals(replaceAll)){
             throw new ValidarSenhaAlterarSenhaException();
         }
    }
    
    private void validarLogin(Usuario usuario){
        String replaceAll = usuario.getLogin().replaceAll("[^a-zA-Z0-9 ]", "");
         if(usuario.getLogin().trim() == null ? replaceAll != null : !usuario.getLogin().trim().equals(replaceAll)){
             throw new ValidarLoginException();
         }
    }
    
    private void validarTamanhoSenha(Usuario usuario) {
        if (usuario.getSenha().trim().length() > 8) {
            throw new ValidarTamanhoSenhaException();
        }
    }  
    
    private void validarTamanhoLogin(Usuario usuario) {
        if (usuario.getLogin().trim().length() > 8) {
            throw new ValidarTamanhoLoginException();
        }
    } 
    
    private void validarTamanhoConfirmaSenha(Usuario usuario) {
        if (usuario.getSenha().trim().length() > 8) {
            throw new ValidarTamanhoConfirmaSenhaException();
        }                                       
    }
    
    private void validarTamanhoNome(Usuario usuario) {
        if (usuario.getNome().trim().length() > 60) {
            throw new ValidarTamanhoNomeException();
        }
    }
}
    

