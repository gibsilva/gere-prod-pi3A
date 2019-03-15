package Controller;

import Model.ProdutoModel;
import java.util.List;
import DAO.ProdutoDAO;

/**
 *
 * @author Adrianne
 */

public class ProdutoController {

    ProdutoDAO produtoDao = new ProdutoDAO();

    public boolean cadastrarProduto(ProdutoModel produto) {
        try {
            produtoDao.inserir(produto);
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ProdutoModel> listarTodos() {
        try {
            return produtoDao.listarTodos();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProdutoModel> filtroProduto(String nomeProduto, String nomeCategoria, int id) {
        try {
            return produtoDao.pesquisarProduto(nomeProduto, nomeCategoria, id);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirProduto(int id) {
        try {
            produtoDao.excluir(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void atualizarProduto(ProdutoModel p) {
        try {
            produtoDao.atualizar(p);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public ProdutoModel getPorId(int id) {
        try {
            return produtoDao.getPorId(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

}
