/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.br.ifnmg.trabalho2.kesia.entidade;


import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Késia Correiia
 */
public class validarNomeUsuario extends PlainDocument{
    @Override
        public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
        throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^a-z|^A-z|^ ]", ""),attr);
        }   
        
        public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
        throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^a-z|^A-z|^ ]", ""),attr);
        } 
}
    

