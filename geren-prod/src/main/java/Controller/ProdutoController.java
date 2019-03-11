package Controller;

import DAO.ProdutoDAO;
import Model.ProdutoModel;
import java.util.List;

/**
 *
 * @author Adriane
 */
public class ProdutoController {

//    public List<ProdutoModel> procurarProduto(String nome) {
//        ProdutoDAO produtoDao = new ProdutoDAO();
//        List<ProdutoModel> listaResposta = null;
//
//        try {
//            if (nome == null || "".equals(nome)) {
//                listaResposta = produtoDao.listarTodos();
//            } else {
//                listaResposta = ProdutoDAO.getByNome(nome);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return listaResposta;
//    }

//    public static ProdutoModel obterProduto(Integer id) {
//        ProdutoModel produtoResposta = null;
//
//        try {
//            produtoResposta = ProdutoDAO.obter(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return produtoResposta;
//    }

}
