package Controller;

import Model.ProdutoModel;
import java.util.List;
import DAO.ProdutoDAO;

/**
 *
 * @author Adrianne
 */
public class ProdutoController {
    public static String cadastrarProduto(ProdutoModel produto){
        String resposta = null;
        
        if(resposta == null){
            try{
                ProdutoDAO.inserir(produto);
                
            }catch (Exception e){
                
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }
        return resposta;
    }
    
    public static String atualizarProduto(ProdutoModel produto){
        String resposta = null;
       
        if(resposta == null){
            try{
                ProdutoDAO.atualizar(produto);
            } catch (Exception e){
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }
        return resposta;
    }
    
    public static String excluirProduto(Integer id){
        String resposta = null;
        
        try{
            ProdutoDAO.excluir(id);
        } catch (Exception e){
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        return resposta;
    }

    public List<ProdutoModel> procurarProduto(String nomeProduto, String nomeCategoria, int id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<ProdutoModel> listaResposta = null;

        try {
            if ((nomeProduto == null || "".equals(nomeProduto)) && 
                (nomeCategoria == null || "".equals(nomeCategoria)) &&
                (id == 0 || "".equals(id))) {
                listaResposta = produtoDAO.listarTodos();
            } else {
                listaResposta = produtoDAO.pesquisarProduto(nomeProduto, nomeCategoria, id);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listaResposta;
    }

}
