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
public class ValidarTamanhoNomeException extends MerciException{
    public ValidarTamanhoNomeException(){
        super("O nome só pode conter no máximo 60 caracteres!");
    }
}
