package Model.Categoria;

public class Categoria {
    private int idCategoria;
    private String nome;
    private String descrizione;

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

    public Categoria(){}

    public Categoria(int idCategoria, String nome, String descrizione) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descrizione = descrizione;
    }
}
