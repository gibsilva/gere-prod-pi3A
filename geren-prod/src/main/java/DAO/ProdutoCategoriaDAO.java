/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import Model.ProdutoCategoriaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gi
 */
public class ProdutoCategoriaDAO {

    public void inserir(ProdutoCategoriaModel pc) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "INSERT INTO produto_categoria (id_Produto, id_Categoria)" + "VALUES ("  + pc.getIdProduto() + ","
                + pc.getIdCategoria() + ");";

        try{
            Connection conn = conexao.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void atualizar(ProdutoCategoriaModel pc) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "UPDATE produto_categoria SET id_categoria = " + pc.getIdCategoria()
                +" where id_produto = " + pc.getIdProduto();

        try{
            Connection conn = conexao.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(int idProduto) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "DELETE FROM produto_categoria WHERE ID_PRODUTO = " + idProduto;

        try{
            Connection conn = conexao.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getIdPorNome(String nomeCategoria){
        ConexaoBd conexao = new ConexaoBd();
        int id = 0;
        
        String sql = "SELECT ID FROM CATEGORIA WHERE NOME = '" + nomeCategoria + "';";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            while(resultados.next()){
                id = resultados.getInt("ID");
            }
            
            return id;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
