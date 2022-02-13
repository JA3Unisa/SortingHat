package Storage.Contribuisci;

import java.sql.Timestamp;
import java.util.List;

public class Contribuisci {
    private int id,idUtente;
    private List<Integer> domande;
    private Timestamp dataOra;

    public Contribuisci(int id, int idUtente, List<Integer> domande, Timestamp dataOra) {
        this.id = id;
        this.idUtente = idUtente;
        this.domande = domande;
        this.dataOra = dataOra;
    }

    public Contribuisci() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public List<Integer> getDomande() {
        return domande;
    }

    public void setDomande(List<Integer> domande) {
        this.domande = domande;
    }

    public Timestamp getDataOra() {
        return dataOra;
    }

    public void setDataOra(Timestamp dataOra) {
        this.dataOra = dataOra;
    }
}
