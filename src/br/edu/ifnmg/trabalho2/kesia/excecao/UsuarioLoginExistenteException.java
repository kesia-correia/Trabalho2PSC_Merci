/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.trabalho2.kesia.excecao;

/**
 *
 * @author Késia Correiia
 */
public class UsuarioLoginExistenteException extends MerciException{
    public UsuarioLoginExistenteException(){
        super("Já existe um usuário cadastrado no sistema com esse LOGIN!!");
    }
}

