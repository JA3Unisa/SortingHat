package Model.Discussione;

import Controller.Http.FormMapper;
import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;
import Model.Utente.SqlUtenteDAO;
import Model.Utente.Utente;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;


public class DiscussioneFormMapper implements FormMapper<Discussione> {


    public Discussione map(HttpServletRequest rs, Boolean update) throws SQLException {


        Discussione dis = new Discussione();

        dis.setCorpo(rs.getParameter("nome"));
       // dis.setDataOra(rs.("dataOra"));          #########RICORDARE############
        dis.setTitolo(rs.getParameter("titolo"));
        int idCategoria=(Integer.parseInt(rs.getParameter("idCategoria")));
        SqlCategoriaDAO sqlCategoriaDAO=new SqlCategoriaDAO();
        Optional<Categoria> categoria=sqlCategoriaDAO.fetchCategoriesByID(idCategoria);

        int idUtente=(Integer.parseInt(rs.getParameter("idUtente")));
        SqlUtenteDAO sqlUtenteDAO=new SqlUtenteDAO();
        Optional<Utente> utente=sqlUtenteDAO.findUtentebyID(idUtente);
        dis.setUtente(utente.get());
        if (update) {
            dis.setIdDiscussione(Integer.parseInt(rs.getParameter("idDiscussione")));
        }
        return dis;

    }
}