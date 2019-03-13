/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.ProdutoController;
import Model.CategoriaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gi
 */
public class CategoriaDAO {

    public List<CategoriaModel> listarTodos() {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "SELECT * FROM CATEGORIA";

        ArrayList<CategoriaModel> listaCategoria = new ArrayList<CategoriaModel>();

        
        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            while (resultados.next()) {
                
                // TRATAR RESULTADOS
                CategoriaModel categoria = new CategoriaModel(resultados.getInt("ID"), resultados.getString("NOME"));

                listaCategoria.add(categoria);
            }
               
            conexao.close();
            return listaCategoria;

        } catch (SQLException ex) {
            ex.printStackTrace();
            conexao.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexao.close();
        }
        return null;
    }

    public void inserir(CategoriaModel c) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "INSERT INTO categoria(nome)" + "VALUES (" + "'" + c.getNome() + "');";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            conexao.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexao.close();
        }
    }

    public void atualizar(CategoriaModel c) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "UPDATE categoria SET" + "(nome)" + "VALUES (" + "'" + c.getNome() + "'"
                + "WHERE ID = " + c.getIdCategoria() + "');";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            conexao.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexao.close();
        }
    }

    public void excluir(int idCategoria) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "DELETE FROM categoria WHERE ID = " + idCategoria + "'";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            conexao.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexao.close();
        }
    }
}
