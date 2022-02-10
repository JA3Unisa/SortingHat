package Model.Utente;

import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
//c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec
class SqlUtenteDAOTest {
    private SqlUtenteDAO testDao = new SqlUtenteDAO();
    private Utente utenteTest = new Utente(132,"Ermene","Gildo","testing@gmail.com","testPass",false,0);

    /*FindUtenteByID*/
    @Test
    public void findUtentebyIDZero() throws SQLException{
        Utente utente = new Utente();
        assertEquals(testDao.findUtentebyID(0).get().toString(),utente.toString());
    }

    @Test
    public void findUtenteByIdOKTEST() throws SQLException {
        testDao.createUtente(this.utenteTest);
        Utente testUser = testDao.findUtente(utenteTest.getEmail(),utenteTest.getPassword()).get();
        testDao.deleteUtente(testDao.findUtente(utenteTest.getEmail(),utenteTest.getPassword()).get().getIdUtente());
        assertEquals(this.utenteTest.getNome(),testUser.getNome());
        assertEquals(this.utenteTest.getCognome(),testUser.getCognome());
        assertEquals(this.utenteTest.getEmail(),testUser.getEmail());
    }

    /*CountAllUtente*/
    @Test
    void countAllUtenteOKTEST() throws SQLException {
        int firstCount = testDao.countAllUtente();
        testDao.createUtente(this.utenteTest);
        int lastCount = testDao.countAllUtente();
        testDao.deleteUtente(testDao.findUtente(utenteTest.getEmail(),utenteTest.getPassword()).get().getIdUtente());
        assertEquals(firstCount+1,lastCount);
    }

    /*Fetch Utente*/
    @Test
    void fetchUtenteOKTEST() throws SQLException {
        Paginator paginator = new Paginator(1,"UtenteServlet");
        List<Utente> list = testDao.fetchAccounts(paginator);
        int firstCount = list.size();
        testDao.createUtente(this.utenteTest);
        list = testDao.fetchAccounts(paginator);
        int lastCount = list.size();
        testDao.deleteUtente(testDao.findUtente(utenteTest.getEmail(),utenteTest.getPassword()).get().getIdUtente());
        assertEquals(firstCount+1,lastCount);
    }

    /*Update User*/
    @Test
    void updateUtenteOKTEST() throws SQLException {
        testDao.createUtente(utenteTest);
        Optional<Utente> toModify = testDao.findUtente(utenteTest.getEmail(),utenteTest.getPassword());
        toModify.get().setEmail("testing2mail@gmail.com");
        testDao.updateUtente(toModify.get());
        Optional<Utente> modified = testDao.findUtentebyID(toModify.get().getIdUtente());
        testDao.deleteUtente(toModify.get().getIdUtente());
        assertEquals(modified.get().getEmail(),"testing2mail@gmail.com");
    }

    /*Utente sessio*/
    @Test
    public void UtenteSessionOKTEST(){
        UtenteSession u = new UtenteSession(utenteTest);
        assertEquals(u.getId(),utenteTest.getIdUtente());
        assertEquals(u.getRuolo(),utenteTest.getRuolo());
        assertEquals(u.getNome(),utenteTest.getNome());
        assertEquals(u.getCognome(),utenteTest.getCognome());
    }
}