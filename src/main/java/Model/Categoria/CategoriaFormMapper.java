package Model.Categoria;

import Controller.Http.FormMapper;

import javax.servlet.http.HttpServletRequest;

public class CategoriaFormMapper implements FormMapper<Categoria> {

    @Override
    public Categoria map(HttpServletRequest request, Boolean update) {
        Categoria categoria = new Categoria();

        categoria.setNome(request.getParameter("Nome"));
        categoria.setDescrizione(request.getParameter("Descrizione"));
        categoria.setTitoloDescrizione(request.getParameter("TitoloDescrizione"));
        if (update) {
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("id")));
        }
            return categoria;

    }
}