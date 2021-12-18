package Model.Discussione;

import Model.Categoria.Categoria;
import Model.Utente.Utente;

import java.util.GregorianCalendar;

public class Discussione {
    private int idDiscussione;
    private String corpo;
    private GregorianCalendar dataOra;
    private String titolo;
    private int idCategoria;
    private Categoria categoria;//Controllare
    private int idUtente;
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

    public GregorianCalendar getDataOra() {
        return dataOra;
    }

    public void setDataOra(GregorianCalendar dataOra) {
        this.dataOra = dataOra;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Discussione(){}

    public Discussione(int idDiscussione, String corpo, GregorianCalendar dataOra, String titolo, int idCategoria, Categoria categoria, int idUtente, Utente utente) {
        this.idDiscussione = idDiscussione;
        this.corpo = corpo;
        this.dataOra = dataOra;
        this.titolo = titolo;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.idUtente = idUtente;
        this.utente = utente;
    }
}
