package Model.Utente;

public class UtenteSession {
    private final String Nome;
    private final String Cognome;
    private final int id;
    private final int Ruolo;


    public UtenteSession(Utente utente) {
        this.Nome=utente.getNome();
        this.Cognome=utente.getCognome();
        this.id=utente.getIdUtente();
        this.Ruolo=utente.getRuolo();
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
