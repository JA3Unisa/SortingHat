package Model.Risposta;

import Model.Discussione.Discussione;
import Model.Utente.Utente;

import java.sql.Timestamp;

public class Risposta {
    private int idRisposta;
    private String corpo;
    private Timestamp dataOra;
    private Utente utente;//Controllare
    //private int idUtente;
    //private int idDiscussione;
    private Discussione discussione;//Discussione

    public int getIdRisposta() {
        return idRisposta;
    }

    public void setIdRisposta(int idRisposta) {
        this.idRisposta = idRisposta;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Timestamp getdataOra() {
        return dataOra;
    }

    public void setDataOra(Timestamp dataOra) {
        this.dataOra = dataOra;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

   /* public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdDiscussione() {
        return idDiscussione;
    }

    public void setIdDiscussione(int idDiscussione) {
        this.idDiscussione = idDiscussione;
    }
*/
    public Discussione getDiscussione() {
        return discussione;
    }

    public void setDiscussione(Discussione discussione) {
        this.discussione = discussione;
    }

    public Risposta(int idRisposta, String corpo, Timestamp dataOra, Utente utente, Discussione discussione) {
        this.idRisposta = idRisposta;
        this.corpo = corpo;
        this.dataOra = dataOra;
        this.utente = utente;
       // this.idUtente = idUtente;
      //  this.idDiscussione = idDiscussione;
        this.discussione = discussione;
    }
    public Risposta(){}
}
