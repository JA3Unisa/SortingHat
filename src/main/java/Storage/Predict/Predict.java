package Storage.Predict;

import java.sql.Timestamp;

public class Predict {
    private int id, dipartimento;
    private Timestamp dataOra;

    public Predict(int id, int dipartimento, Timestamp dataOra) {
        this.id = id;
        this.dipartimento = dipartimento;
        this.dataOra = dataOra;
    }

    public Predict() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(int dipartimento) {
        this.dipartimento = dipartimento;
    }

    public Timestamp getDataOra() {
        return dataOra;
    }

    public void setDataOra(Timestamp dataOra) {
        this.dataOra = dataOra;
    }
}
