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
public class ValidarLoginException extends MerciException{
    public ValidarLoginException(){
        super(" O login só pode conter caracteres de a-z e/ ou A-Z e/ou números de 0-9");
    }
}
