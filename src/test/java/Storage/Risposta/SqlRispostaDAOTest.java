package Storage.Risposta;

import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;
import Storage.Discussione.Discussione;
import Storage.Utente.Utente;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class SqlRispostaDAOTest {
    private SqlRispostaDAO testDao = new SqlRispostaDAO();
    private Categoria categoriaTest = new Categoria(100,"Test","TestCat",null,"TestTitolo");
    private Utente utenteTest = new Utente(132,"Ermene","Gildo","testing@gmail.com","testPass",false,0);
    private Discussione discussioneTest = new Discussione(50,"corpoTest",null,"titoloTest",categoriaTest,utenteTest);
    private Risposta rispostaTest = new Risposta(0,"corpo",null,utenteTest,discussioneTest);
    private Paginator paginator = new Paginator(1,"RispostaServlet");

    @Test
    public void fetchRisposta() throws SQLException {
        Optional<Risposta> r = testDao.fetchRisposte(18);
        assertNotNull(r.get());
    }

    @Test
    public void fetchRispostaOKTEST() throws SQLException {
        List<Risposta> lista = testDao.fetchRisposta(paginator);
        assertNotNull(lista.get(0));
    }

    @Test
    public void countAll() throws Exception {
        int firstCount = testDao.countAll();
        testDao.createRisposta(rispostaTest);
        int lastCount = testDao.countAll();
        List<Risposta> lista = testDao.fetchRisposta(paginator);
        testDao.deleteRisposta(lista.get(lista.size()-1).getIdRisposta());
        assertNotEquals(firstCount,lastCount);

    }

    @Test
    public void deleteRispostaOKTEST() throws Exception {
        testDao.createRisposta(rispostaTest);
        int firstCount = testDao.countAll();
        List<Risposta> lista = testDao.fetchRisposta(paginator);
        testDao.deleteRisposta(lista.get(lista.size()-1).getIdRisposta());
        int lastCount = testDao.countAll();
        assertNotEquals(firstCount,lastCount);
    }

    @Test
    public void updateRispostaOKTEST() throws Exception {
        testDao.createRisposta(rispostaTest);
        rispostaTest.setCorpo("NuovoCorpo");
        testDao.updateRisposta(rispostaTest);
        List<Risposta> lista = testDao.fetchRisposta(paginator);
        Risposta newR= lista.get(lista.size()-1);
        testDao.deleteRisposta(lista.get(lista.size()-1).getIdRisposta());
        assertNotEquals(rispostaTest.getCorpo(),newR.getCorpo());
    }

    @Test
    public void createRispostaOKTEST() throws Exception {
        testDao.createRisposta(rispostaTest);
        List<Risposta> lista = testDao.fetchRisposta(paginator);
        Risposta newR= lista.get(lista.size()-1);
        testDao.deleteRisposta(lista.get(lista.size()-1).getIdRisposta());
        assertEquals(rispostaTest.getCorpo(),newR.getCorpo());
    }

}