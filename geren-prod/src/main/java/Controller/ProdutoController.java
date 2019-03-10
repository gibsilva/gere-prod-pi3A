package Controller;

import java.util.List;

/**
 *
 * @author Gi
 */
public class ProdutoController {

    public static List<Produto> procurarProduto(String nome) {
        List<Produto> listaResposta = null;

        try {
            if (nome == null || "".equals(nome)) {
                listaResposta = ProdutoDAO.listar();
            } else {
                listaResposta = ProdutoDAO.procurar(nome);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listaResposta;
    }

    public static Produto obterProduto(Integer id) {
        Produto produtoResposta = null;

        try {
            produtoResposta = ProdutoDAO.obter(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtoResposta;
    }

}
