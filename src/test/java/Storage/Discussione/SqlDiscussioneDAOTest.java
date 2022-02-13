package Storage.Discussione;

import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;
import Storage.Utente.Utente;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SqlDiscussioneDAOTest {

    private SqlDiscussioneDAO testDao = new SqlDiscussioneDAO();
    private Categoria categoriaTest = new Categoria(100,"Test","TestCat",null,"TestTitolo");
    private Utente utenteTest = new Utente(132,"Ermene","Gildo","testing@gmail.com","testPass",false,0);

    private Discussione testDiscussione = new Discussione(50,"corpoTest",null,"titoloTest",categoriaTest,utenteTest);


    @Test
    public void fetchDiscussioniByCategoriaOKTEST() throws SQLException {
        Paginator paginator = new Paginator(1,"CategoriaServlet");
        List<Discussione> list = testDao.fetchDiscussioniByCategoria(categoriaTest,paginator);
        assertEquals(list.size(),0);
    }

    @Test
    public void updateDiscussioneOKTEST() throws SQLException{
        testDao.createDiscussione(testDiscussione);
        testDiscussione.setCorpo("cambioCorpo");
        testDao.updateDiscussione(testDiscussione);
        List<Discussione> lista = testDao.fetchDiscussioniAll();
        Discussione modified = lista.get(lista.size()-1);
        testDao.deleteDiscussione(String.valueOf(lista.get(lista.size()-1).getIdDiscussione()));
        assertEquals(testDiscussione.getCorpo(),modified.getCorpo());
    }

    @Test
    public void deleteDiscussioneOKTEST() throws  SQLException{
        testDao.createDiscussione(testDiscussione);
        List<Discussione> lista = testDao.fetchDiscussioniAll();
        int firstCount = testDao.countAll();
        testDao.deleteDiscussione(String.valueOf(lista.get(lista.size()-1).getIdDiscussione()));
        int lastCount = testDao.countAll();
        assertEquals(firstCount-1,lastCount);
    }

    @Test
    public void fetchDiscussioniByIDOKTEST() throws SQLException {
        Discussione d = testDao.fetchDiscussioniByID(3).get();
        assertNotEquals(d.getIdDiscussione(),0);
        assertNotNull(d.getUtente());
    }

    @Test
    public void countAllOKTEST() throws SQLException {
        assertEquals(testDao.countAll(),testDao.fetchDiscussioniAll().size());
    }

    @Test
    public void fetchDiscussioniOKTEST() throws SQLException {
        assertEquals(testDao.fetchDiscussioniAll().size(),testDao.countAll());
    }

}