/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;


/**
 *
 * @author Gi
 */
public class ProdutoModel {
    
    private int idProduto;
    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;
    private String dtCadastro;
    private String nomeCategoria;
    private int disponivel;
    
    public ProdutoModel( int idProduto, String nome, String descricao,
            double precoCompra, double precoVenda, int quantidade, String dtCadastro, String nomeCategoria, int disponivel){
        
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.dtCadastro = dtCadastro;
        this.nomeCategoria = nomeCategoria;
        this.disponivel = disponivel;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the precoCompra
     */
    public double getPrecoCompra() {
        return precoCompra;
    }

    /**
     * @param precoCompra the precoCompra to set
     */
    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    /**
     * @return the precoVenda
     */
    public double getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the dtCadastro
     */
    public String getDtCadastro() {
        return dtCadastro;
    }

    /**
     * @param dtCadastro the dtCadastro to set
     */
    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
    
    public String getNomeCategoria(){
        return nomeCategoria;
    }
    
    public void setNomeCategoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }
    
    public int getDisponivel(){
        return this.disponivel;
    }
    
    public void setDisponivel(int disponivel){
        this.disponivel = disponivel;
    }
}
    
