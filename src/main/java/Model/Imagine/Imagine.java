package Model.Imagine;

public class Imagine {
    private int idImagine;
    private String url;
    private int idProvenienza;
    private int tipo;

    public int getIdImagine() {
        return idImagine;
    }

    public void setIdImagine(int idImagine) {
        this.idImagine = idImagine;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdProvenienza() {
        return idProvenienza;
    }

    public void setIdProvenienza(int idProvenienza) {
        this.idProvenienza = idProvenienza;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Imagine(){}

    public Imagine(int idImagine, String url, int idProvenienza, int tipo) {
        this.idImagine = idImagine;
        this.url = url;
        this.idProvenienza = idProvenienza;
        this.tipo = tipo;
    }
}
