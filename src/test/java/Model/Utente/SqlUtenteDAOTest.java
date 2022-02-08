package Model.Utente;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
    private Utente utenteTest = new Utente(12,"Ermene","Gildo","testing@gmail.com","testPass",false,0);
    private Utente u = new Utente();
    /*FindById Tests*/

    protected void mapper()  {
        this.u.setEmail("testmail@gmail.com");
        this.u.setNome("Ermene");
        this.u.setCognome("Gildo");
        this.u.setUniversitario(false);
        this.u.obtainPassword("giancarlo");
    }

    @Before
    public void setup() {
        mapper();
    }

    @Test
    public void findUtentebyIDZero() throws SQLException{
        Utente utente = new Utente();
        assertEquals(testDao.findUtentebyID(0).get().toString(),utente.toString());
    }

    @Test
    public void findUtenteByIdOKTEST() throws SQLException {
        mapper();
        System.out.println(this.u.toString());
        testDao.createUtente(this.u);
        Utente testUser = testDao.findUtente(u.getEmail(),u.getPassword()).get();
        assertEquals(this.u.getNome(),testUser.getNome());
        assertEquals(this.u.getCognome(),testUser.getCognome());
        assertEquals(this.u.getEmail(),testUser.getEmail());
    }








}