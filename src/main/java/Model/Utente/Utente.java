package Model.Utente;

public class Utente {
    private int idUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Boolean universitario;
    private int ruolo;

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUniversitario() {
        return universitario;
    }

    public void setUniversitario(Boolean universitario) {
        this.universitario = universitario;
    }

    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

    public Utente(){
    }
    public Utente(int idUtente,String nome,String cognome,String email,String password,Boolean universitario,int ruolo){
        this.idUtente=idUtente;
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.password=password;
        this.universitario=universitario;
        this.ruolo=ruolo;
    }

}
