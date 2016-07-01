/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.trabalho2.kesia.apresentacao;

import br.edu.ifnmg.trabalho2.kesia.entidade.Usuario;
import br.edu.ifnmg.trabalho2.kesia.entidade.validarNomeUsuario;
import br.edu.ifnmg.trabalho2.kesia.excecao.CampoObrigatorioException;
import br.edu.ifnmg.trabalho2.kesia.excecao.CampoPesquisaObrigatorioException;
import br.edu.ifnmg.trabalho2.kesia.excecao.MerciException;
import br.edu.ifnmg.trabalho2.kesia.negocio.UsuarioBO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

;

/**
 *
 * @author Késia Correiia
 */
public class CadastroUsuarioForm extends javax.swing.JFrame {
     private Usuario usuario;
     private ListagemUsuariosForm consultaUsuarioForm;
     private List<Usuario> listaUsuarios;
    
    
    /**
     * Creates new form CadastroUsuario
     */
   
    public CadastroUsuarioForm() {
        usuario = new Usuario();
        initComponents();
        desabilitarCamposPesquisa();
        txtNome.setDocument(new validarNomeUsuario());
        setLocationRelativeTo( null );
    }
     
    public CadastroUsuarioForm(ListagemUsuariosForm consultaUsuarioForm, Usuario usuarioEdicao) {
        this.consultaUsuarioForm = consultaUsuarioForm;
        this.usuario = usuarioEdicao;
        initComponents();
        txtNome.setDocument(new validarNomeUsuario());
        this.inicializarCamposTela();
        desabilitarCamposEditar();
    }
    
    private void inicializarCamposTela(){
        this.txtNome.setText(this.usuario.getNome());
        this.txtLogin.setText(this.usuario.getLogin());
        this.txtSenha.setText(this.usuario.getSenha());
         switch (usuario.getTipoUsuario()) {
             case "Gerente":
                 bxGerente.setSelected(true);
                 break;
             case "Gestor de Compras":
                 bxGestorCompras.setSelected(true);
                 break;
             case "Gestor de Estoque":
                 bxGestorEstoque.setSelected(true);
                 break;
             default:
                 bxCaixeiro.setSelected(true);
                 break;
         }
    }
    
    private void limparCamposTela() {
       this.txtNome.setText("");
       this.txtLogin.setText("");
       this.txtSenha.setText("");
       if(bxGerente.isSelected()){
            bxGerente.setSelected(false);
        }else if(bxGestorCompras.isSelected()){
            bxGestorCompras.setSelected(false);
        }else if(bxGestorEstoque.isSelected()){
            bxGestorEstoque.setSelected(false);
        }else{
            bxCaixeiro.setSelected(false);
        }
     }
    
    private void recuperarCamposPesquisa() throws ParseException{
       this.txtNome.setText(this.usuario.getNome());
       this.txtSenha.setText(this.usuario.getSenha());
         switch (usuario.getTipoUsuario()) {
             case "Gerente":
                 bxGerente.setSelected(true);
                 break;
             case "Gestor de Compras":
                 bxGestorCompras.setSelected(true);
                 break;
             case "Gestor de Estoque":
                 bxGestorEstoque.setSelected(true);
                 break;
             default:
                 bxCaixeiro.setSelected(true);
                 break;
         }
    }
    
    private void recuperarCamposTela() throws ParseException {
        if (!txtNome.getText().trim().equals("")) {
            usuario.setNome(txtNome.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        
        if (!txtLogin.getText().trim().equals("")) {
            usuario.setLogin(txtLogin.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        
        if (!txtSenha.getText().trim().equals("")) {
            usuario.setSenha(txtSenha.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        
        if (bxGerente.isSelected()) {
           usuario.setTipoUsuario("Gerente");
        } else if (bxGestorCompras.isSelected()) {
            usuario.setTipoUsuario("Gestor de Compras");
        }else if(bxGestorEstoque.isSelected()){
            usuario.setTipoUsuario("Gestor de Estoque");
        }else{
            usuario.setTipoUsuario("Caixeiro");
        } 
    }
    
    private void desabilitarCampos(){
        if (bxGerente.isSelected()) {
            bxGestorCompras.setEnabled(false);
            bxGestorEstoque.setEnabled(false);
            bxCaixeiro.setEnabled(false);
        } else if (bxGestorCompras.isSelected()) {
            bxGerente.setEnabled(false);
            bxGestorEstoque.setEnabled(false);
            bxCaixeiro.setEnabled(false);
        } else if (bxGestorEstoque.isSelected()){
             bxGerente.setEnabled(false);
             bxGestorCompras.setEnabled(false);
             bxCaixeiro.setEnabled(false);
        }else if(bxCaixeiro.isSelected()){
            bxGerente.setEnabled(false);
            bxGestorEstoque.setEnabled(false); 
            bxGestorEstoque.setEnabled(false);
        }else{
            bxCaixeiro.setEnabled(true);
            bxGerente.setEnabled(true);
            bxGestorEstoque.setEnabled(true); 
            bxGestorCompras.setEnabled(true); 
        }
    }
     
    private void bloquearCampoLogin(){
        this.txtLogin.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        bxGerente = new javax.swing.JCheckBox();
        bxGestorEstoque = new javax.swing.JCheckBox();
        bxGestorCompras = new javax.swing.JCheckBox();
        bxCaixeiro = new javax.swing.JCheckBox();
        lblGrupoUsuario = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário - Merci");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLogin.setText("Login:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSenha.setText("Senha:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bxGerente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bxGerente.setText("Gerente");
        bxGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxGerenteActionPerformed(evt);
            }
        });

        bxGestorEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bxGestorEstoque.setText("Gestor Estoque");
        bxGestorEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxGestorEstoqueActionPerformed(evt);
            }
        });

        bxGestorCompras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bxGestorCompras.setText("Gestor Compras");
        bxGestorCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxGestorComprasActionPerformed(evt);
            }
        });

        bxCaixeiro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bxCaixeiro.setText("Caixeiro");
        bxCaixeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bxCaixeiroActionPerformed(evt);
            }
        });

        lblGrupoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGrupoUsuario.setText("Grupo de Usuários");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bxGerente)
                            .addComponent(bxGestorEstoque))
                        .addGap(147, 147, 147)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bxGestorCompras)
                            .addComponent(bxCaixeiro)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGrupoUsuario)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblGrupoUsuario)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bxGestorCompras)
                    .addComponent(bxGerente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bxGestorEstoque)
                    .addComponent(bxCaixeiro))
                .addGap(16, 16, 16))
        );

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/fechar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/buscar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/deletar.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/sair_seta.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnFechar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/trabalho2/kesia/apresentacao/icones/fechar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    private void cancelar(){
        int resposta;
                String mensagem = "Realmente deseja cancelar essa operação? ";
                String titulo = " Cancelar";
                resposta = JOptionPane.showConfirmDialog(this,
                        mensagem, titulo, JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    this.limparCamposTela();
                    this.desabilitarCamposPesquisa();
                }
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
       this.salvarUsuario();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void bxGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxGerenteActionPerformed
        // TODO add your handling code here:
        this.desabilitarCampos();
    }//GEN-LAST:event_bxGerenteActionPerformed

    private void bxGestorEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxGestorEstoqueActionPerformed
        // TODO add your handling code here:
        this.desabilitarCampos();
    }//GEN-LAST:event_bxGestorEstoqueActionPerformed

    private void bxGestorComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxGestorComprasActionPerformed
        // TODO add your handling code here:
       this.desabilitarCampos();
    }//GEN-LAST:event_bxGestorComprasActionPerformed

    private void bxCaixeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bxCaixeiroActionPerformed
        // TODO add your handling code here:
        this.desabilitarCampos();
    }//GEN-LAST:event_bxCaixeiroActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        this.pesquisarUsuario();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         try {
             // TODO add your handling code here:
             this.excluir();
         } catch (SQLException ex) {
             Logger.getLogger(CadastroUsuarioForm.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
       this.habilitarCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.voltar();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed
    
    private void voltar(){
        this.dispose();
        ListagemUsuariosForm listagemUsuariosForm = new ListagemUsuariosForm();
        listagemUsuariosForm.setVisible(true);
    }
    
    private void excluir() throws SQLException{
                int resposta;
                String mensagem = "Realmente deseja excluir esse usuário? ";
                String titulo = "Exclusão de Usuário";
                resposta = JOptionPane.showConfirmDialog(this,
                        mensagem, titulo, JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    desabilitarCamposPesquisa();
                    UsuarioBO usuarioBO = new UsuarioBO();
                    usuarioBO.excluir(usuario.getLogin());
                    String mensagemSuceso = "Usuário excluído com sucesso!!";
                    JOptionPane.showMessageDialog(this,
                            mensagemSuceso, titulo,
                            JOptionPane.INFORMATION_MESSAGE);
                    this.limparCamposTela();
                            
                }        
    }
    
    
    private void desabilitarCamposPesquisa(){
        txtNome.setEnabled(false);
        lblNome.setEnabled(false);
        txtSenha.setEnabled(false);
        lblSenha.setEnabled(false);
        bxGerente.setEnabled(false);
        bxGestorCompras.setEnabled(false);
        bxGestorEstoque.setEnabled(false);
        bxCaixeiro.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnNovo.setEnabled(true);
        lblGrupoUsuario.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnFechar.setEnabled(true);
        btnVoltar.setEnabled(false);
    }
    
    private void habilitarCampos(){
        txtNome.setEnabled(true);
        lblNome.setEnabled(true);
        txtSenha.setEnabled(true);
        lblSenha.setEnabled(true);
        bxGerente.setEnabled(true);
        bxGestorCompras.setEnabled(true);
        bxGestorEstoque.setEnabled(true);
        bxCaixeiro.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(true);
        lblGrupoUsuario.setEnabled(true);
        btnNovo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnFechar.setEnabled(true);
    }
    
    private void validarCamposObrigatorios() {
        if (txtNome.getText().trim().isEmpty()
                || txtLogin.getText().trim().isEmpty()
                || txtSenha.getText().trim().isEmpty()
                || (!bxGerente.isSelected() && !bxGestorEstoque.isSelected() && !bxGestorCompras.isSelected() && !bxCaixeiro.isSelected())) {
            throw new CampoObrigatorioException();
        }
    }
    
    private void fecharCadastroUsuario(){
        CadastroUsuarioForm.this.dispose();
        if (consultaUsuarioForm == null) {
           consultaUsuarioForm = new ListagemUsuariosForm();
        }
        consultaUsuarioForm.setVisible(true);
        consultaUsuarioForm.toFront();
    } 
       
    private void salvarUsuario(){
         try {
            this.validarCamposObrigatorios();
            this.recuperarCamposTela();
            UsuarioBO usuarioBO = new UsuarioBO();
            String tituloMensagem;
            if (usuario.getID() == -1) {
               usuarioBO.verificaUsuarioLoginExistente(usuario);
               tituloMensagem = "Cadastro de usuário";
               usuarioBO.inserir(usuario);
               JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", tituloMensagem, JOptionPane.INFORMATION_MESSAGE);
               this.desabilitarCamposPesquisa();
            } else {
                tituloMensagem = "Editar usuário";
                usuarioBO.alterar(usuario);
                JOptionPane.showMessageDialog(this, "Usuário alterado com sucesso!", tituloMensagem, JOptionPane.INFORMATION_MESSAGE);
                this.desabilitarCamposPesquisa();
                btnVoltar.setEnabled(true);
            }
            this.limparCamposTela();
        } catch (MerciException e) {
            String mensagem = "Erro ao realizar cadastro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Cadastro de usuário", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private void validarCamposPesquisa() {
        if (txtLogin.getText().trim().isEmpty()) {
            throw new CampoPesquisaObrigatorioException();
        }
    }
    
     private void pesquisarUsuario() {
        try {
            Usuario usuarioPesquisado = new Usuario();
            String login = txtLogin.getText().trim();
            usuarioPesquisado.setLogin(login);
            this.validarCamposPesquisa();
            UsuarioBO usuarioBO = new UsuarioBO();
            usuario = usuarioBO.pesquisar(usuarioPesquisado);
            this.recuperarCamposPesquisa();
            this.habilitarCampos();
            btnExcluir.setEnabled(true);
        } catch (MerciException e) {
            String mensagem = "Pesquisa não realizada:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ParseException e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de usuário", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUsuarioForm().setVisible(true);
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JCheckBox bxCaixeiro;
    private javax.swing.JCheckBox bxGerente;
    private javax.swing.JCheckBox bxGestorCompras;
    private javax.swing.JCheckBox bxGestorEstoque;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGrupoUsuario;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void desabilitarCamposEditar() {
        btnNovo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnVoltar.setEnabled(false);
        btnFechar.setEnabled(false);
    }

}
