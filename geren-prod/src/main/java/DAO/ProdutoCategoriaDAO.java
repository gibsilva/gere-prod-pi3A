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
        String sql = "INSERT INTO produto_categoria (idProduto, idCategoria)" + "VALUES (" + "'" + pc.getIdProduto() + "',"
                + "'" + pc.getIdCategoria() + "');";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void atualizar(ProdutoCategoriaModel pc) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "UPDATE produto_categoria SET" + "(idProduto, idCategoria)" + "VALUES (" + "'" + pc.getIdProduto() + "',"
                + "'" + pc.getIdCategoria() + "WHERE ID_Produto = " + pc.getIdProduto()
                + "AND ID_Categoria = " + pc.getIdCategoria() + "');";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(int idProduto, int idCategoria) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "DELETE FROM produto_categoria WHERE ID_produto = " + idProduto + "'" + "AND ID_categoria =" + idCategoria + "'";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
