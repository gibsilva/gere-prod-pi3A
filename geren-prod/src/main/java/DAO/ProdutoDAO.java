/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Model.ProdutoModel;
import java.util.ArrayList;

/**
 *
 * @author Gi
 */
public class ProdutoDAO {

    public List<ProdutoModel> listarTodos() {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "select p.*, c.nome as categoria\n"
                + "from produto p\n"
                + "inner join produto_categoria pc\n"
                + "	on pc.id_produto = p.id\n"
                + "inner join categoria c\n"
                + "	on c.id = pc.id_categoria";

        ArrayList<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            while (resultados.next()) {

                // TRATAR RESULTADOS
                ProdutoModel produto = new ProdutoModel(resultados.getInt("ID"), resultados.getString("NOME"),
                        resultados.getString("DESCRICAO"), resultados.getDouble("PRECO_COMPRA"),
                        resultados.getDouble("PRECO_VENDA"), resultados.getInt("QUANTIDADE"),
                        resultados.getDate("DT_CADASTRO"), resultados.getString("CATEGORIA"));

                listaProduto.add(produto);
            }

            conexao.close();
            return listaProduto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            conexao.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexao.close();
        }
        return null;
    }

    public static void inserir(ProdutoModel p) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = " INSERT INTO produto "
                + "(Nome, Descricao, preco_compra, preco_venda, quantidade, dt_cadastro)"
                + "VALUES (" + "'" + p.getNome() + "',"
                + "'" + p.getDescricao() + "',"
                + "'" + p.getPrecoCompra() + "',"
                + "'" + p.getPrecoVenda() + "',"
                + "'" + p.getQuantidade() + "',"
                + "'" + p.getDtCadastro() + "'),";

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

    public static void atualizar(ProdutoModel p) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "UPTADE produto SET"
                + "(Nome, Descricao, preco_compra, preco_venda, quantidade, dt_cadastro)"
                + "VALUES (" + "'" + p.getNome() + "',"
                + "'" + p.getDescricao() + "',"
                + "'" + p.getPrecoCompra() + "',"
                + "'" + p.getPrecoVenda() + "',"
                + "'" + p.getQuantidade() + "',"
                + "'" + p.getDtCadastro() + "',"
                + "WHERE ID = " + p.getIdProduto() + "'),";

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void excluir(int idProduto) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "DELETE FROM produto WHERE ID = " + idProduto;

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public int getMaxId() {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "select MAX(id) FROM Produto";
        int id = 0;

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            while (resultados.next()) {
                id = resultados.getInt(1);
            }

            conexao.close();
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return 0;
        }

    }
    public List<ProdutoModel> pesquisarProduto(String nomeProduto, String nomeCategoria, int id) {
        ConexaoBd conexao = new ConexaoBd();
        String sql = "select p.*, c.nome as categoria\n"
                + "from produto p\n"
                + "inner join produto_categoria pc\n"
                + "	on pc.id_produto = p.id\n"
                + "inner join categoria c\n"
                + "	on c.id = pc.id_categoria"
                + "where 1 = 1";
        
        if(id != 0){
            sql += "and id = " + id;
        }
        
        if(!nomeProduto.equals("")){
            sql += "and p.nome like '%" + nomeProduto + "'%";
        }
        
        if(!nomeCategoria.equals("")){
            sql += "and c.nome like '%" + nomeCategoria + "'%";
        }

        ArrayList<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();

        try (Connection conn = conexao.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet resultados = stmt.executeQuery()) {
            while (resultados.next()) {

                // TRATAR RESULTADOS
                ProdutoModel produto = new ProdutoModel(resultados.getInt("ID"), resultados.getString("NOME"),
                        resultados.getString("DESCRICAO"), resultados.getDouble("PRECO_COMPRA"),
                        resultados.getDouble("PRECO_VENDA"), resultados.getInt("QUANTIDADE"),
                        resultados.getDate("DT_CADASTRO"), resultados.getString("CATEGORIA"));

                listaProduto.add(produto);
            }

            conexao.close();
            return listaProduto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            conexao.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexao.close();
        }
        return null;
    }
}
