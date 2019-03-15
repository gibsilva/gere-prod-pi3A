/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoriaDAO;
import Model.CategoriaModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gi
 */
public class CategoriaController {
    CategoriaDAO categoriaDao = new CategoriaDAO();
    
    public List<CategoriaModel> carregarCategorias(){
        List<CategoriaModel> categorias = new ArrayList();
        
        for(CategoriaModel c: categoriaDao.listarTodos()){
            categorias.add(c);
        }
        
        return categorias;
    }
}
