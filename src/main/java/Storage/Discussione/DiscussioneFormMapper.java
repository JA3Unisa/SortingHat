package Storage.Discussione;

import ApplicationLogic.Http.FormMapper;
import Storage.Categoria.Categoria;
import Storage.Utente.Utente;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class DiscussioneFormMapper implements FormMapper<Discussione> {


    public Discussione map(HttpServletRequest rs, Boolean update) throws SQLException {


        Discussione dis = new Discussione();

        dis.setCorpo(rs.getParameter("Corpo"));

        dis.setTitolo(rs.getParameter("Titolo"));

        int idCategoria=(Integer.parseInt(rs.getParameter("Categoria")));
        Categoria categoria=new Categoria();
        categoria.setIdCategoria(idCategoria);
        dis.setCategoria(categoria);

        Utente utente=new Utente();
        utente.setIdUtente(0);
        dis.setUtente(utente);
        //int idUtente=(Integer.parseInt(rs.getParameter("idUtente")));
        //SqlUtenteDAO sqlUtenteDAO=new SqlUtenteDAO();
        //Optional<Utente> utente=sqlUtenteDAO.findUtentebyID(idUtente);
        //dis.setUtente(utente.get());
        if (update) {
            dis.setIdDiscussione(Integer.parseInt(rs.getParameter("id")));
        }
        return dis;

    }
}