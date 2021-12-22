package Model.Utente;
//Da compilare
public class UtenteSession {
    private final String Nome;
    private final String Cognome;
    private final int id;
    private final int Ruolo;

    public UtenteSession(String nome, String cognome, int id, int ruolo) {
        Nome = nome;
        Cognome = cognome;
        this.id = id;
        Ruolo = ruolo;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public int getId() {
        return id;
    }

    public int getRuolo() {
        return Ruolo;
    }
}
