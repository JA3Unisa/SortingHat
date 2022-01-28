package Model.Categoria;

import java.sql.Timestamp;

public class    Categoria {
    private int idCategoria;
    private String nome;
    private String descrizione;
    private Timestamp dataOra;
    private String titoloDescrizione;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Timestamp getDataOra() { return dataOra; }

    public void setDataOra(Timestamp dataOra) { this.dataOra = dataOra; }

    public String getTitoloDescrizione() {
        return titoloDescrizione;
    }

    public void setTitoloDescrizione(String titoloDescrizione) {
        this.titoloDescrizione = titoloDescrizione;
    }

    public Categoria(){}

    public Categoria(int idCategoria, String nome, String descrizione, Timestamp dataOra, String titoloDescrizione) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataOra = dataOra;
        this.titoloDescrizione = titoloDescrizione;
    }
}
