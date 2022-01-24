package Model.Discussione;

import Model.Categoria.Categoria;
import Model.Utente.Utente;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Discussione {
    private int idDiscussione;
    private String corpo;
    private Timestamp dataOra;
    private String titolo;
    private Categoria categoria;//Controllare
    private Utente utente;//Controllare

    public int getIdDiscussione() {
        return idDiscussione;
    }

    public void setIdDiscussione(int idDiscussione) {
        this.idDiscussione = idDiscussione;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Timestamp getDataOra() {
        return dataOra;
    }

    public void setDataOra(Timestamp dataOra) {
        this.dataOra = dataOra;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }



    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Discussione(){}

    public Discussione(int idDiscussione, String corpo, Timestamp dataOra, String titolo,  Categoria categoria, Utente utente) {
        this.idDiscussione = idDiscussione;
        this.corpo = corpo;
        this.dataOra = dataOra;
        this.titolo = titolo;

        this.categoria = categoria;

        this.utente = utente;
    }
}
