/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.br.ifnmg.trabalho2.kesia.excecao;

/**
 *
 * @author Késia Correiia
 */
public class ValidarTamanhoLoginException extends MerciException{
    public ValidarTamanhoLoginException(){
         super("O login deve ter no máximo 8 caracteres!");
    }
}
